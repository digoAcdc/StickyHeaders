package br.com.heiderlopes.stickyheaders.adapter.stickyheader;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.heiderlopes.stickyheaders.R;
import br.com.heiderlopes.stickyheaders.model.Person;

public class AddressBookDemoAdapter extends SectioningAdapter {

    private List<Person> people;
    private ArrayList<Section> sections = new ArrayList<>();

    public  class Section {
        String alpha;
        List<Person> people = new ArrayList<>();

        public List<Person> getPeople() {
            return people;
        }
    }

    public class ItemViewHolder extends SectioningAdapter.ItemViewHolder implements View.OnClickListener {
        TextView personNameTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            personNameTextView = (TextView) itemView.findViewById(R.id.personNameTextView);
            personNameTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            final int section = AddressBookDemoAdapter.this.getSectionForAdapterPosition(adapterPosition);
            final int item = AddressBookDemoAdapter.this.getPositionOfItemInSection(section, adapterPosition);
            clicado(section, item);
        }
    }

    public class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder {
        TextView titleTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }

    void clicado(int sectionIndex, int itemIndex) {
        Log.d("", "onCloneItem() called with: " + "sectionIndex = [" + sectionIndex + "], itemIndex = [" + itemIndex + "]");
        Section s = sections.get(sectionIndex);
        Person p = s.getPeople().get(itemIndex);
        notifySectionItemInserted(sectionIndex, itemIndex + 1);
    }

    public AddressBookDemoAdapter() {

    }

    public Section getPerson(int pos) {
        return sections.get(pos);
    }
    public void setPeople(List<Person> people) {
        this.people = people;

        Collections.sort(people, Person.PersonNameComparator);

        sections.clear();

        char alpha = 0;

        Section currentSection = null;

        for (Person person : people) {

            if (person.getNome().charAt(0) != alpha) {
                if (currentSection != null) {
                    sections.add(currentSection);
                }

                currentSection = new Section();
                alpha = person.getNome().charAt(0);
                currentSection.alpha = String.valueOf(alpha);
            }

            if (currentSection != null) {
                currentSection.people.add(person);
            }
        }

        sections.add(currentSection);
        notifyAllSectionsDataSetChanged();
    }

    @Override
    public int getNumberOfSections() {
        return sections.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {
        return sections.get(sectionIndex).people.size();
    }

    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        return true;
    }

    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item_addressbook_person, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item_addressbook_header, parent, false);
        return new HeaderViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex, int itemType) {
        Section s = sections.get(sectionIndex);
        ItemViewHolder ivh = (ItemViewHolder) viewHolder;
        Person person = s.people.get(itemIndex);
        ivh.personNameTextView.setText(person.getNome());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex, int headerType) {
        Section s = sections.get(sectionIndex);
        HeaderViewHolder hvh = (HeaderViewHolder) viewHolder;
        hvh.titleTextView.setText(s.alpha);
    }
}
