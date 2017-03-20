package br.com.heiderlopes.stickyheaders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import br.com.heiderlopes.stickyheaders.adapter.stickyheader.AddressBookDemoAdapter;
import br.com.heiderlopes.stickyheaders.adapter.stickyheader.StickyHeaderLayoutManager;
import br.com.heiderlopes.stickyheaders.model.Person;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    AddressBookDemoAdapter adapter = new AddressBookDemoAdapter();

    private RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new StickyHeaderLayoutManager());
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Person> persons =new ArrayList<>();
        persons.add(new Person("Amanda"));
        persons.add(new Person("Amanda"));
        persons.add(new Person("Amanda"));
        persons.add(new Person("Amanda"));persons.add(new Person("Amanda"));
        persons.add(new Person("Amanda"));



        persons.add(new Person("Bianca"));
        persons.add(new Person("Bianca"));
        persons.add(new Person("Bianca"));
        persons.add(new Person("Bianca"));
        persons.add(new Person("Bianca"));
        persons.add(new Person("Bianca"));
        persons.add(new Person("Bianca"));
        persons.add(new Person("Bianca"));
        persons.add(new Person("Bianca"));


        persons.add(new Person("Camila"));
        persons.add(new Person("Camila"));
        persons.add(new Person("Camila"));
        persons.add(new Person("Camila"));
        persons.add(new Person("Camila"));
        persons.add(new Person("Camila"));
        persons.add(new Person("Camila"));
        persons.add(new Person("Camila"));

        adapter.setPeople(persons);
        recyclerView.setAdapter(adapter);
    }
}
