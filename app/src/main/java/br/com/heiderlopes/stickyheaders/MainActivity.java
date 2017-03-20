package br.com.heiderlopes.stickyheaders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.heiderlopes.stickyheaders.adapter.stickyheader.AddressBookDemoAdapter;
import br.com.heiderlopes.stickyheaders.adapter.stickyheader.ClickListener;
import br.com.heiderlopes.stickyheaders.adapter.stickyheader.RecyclerTouchListener;
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

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {

                int itemPosition = recyclerView.getChildLayoutPosition(view);
                //String item = adapter.getIte(itemPosition);
                //Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();

                Toast.makeText(MainActivity.this, "Single Click on position        :"+position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Long press on position :"+position,
                        Toast.LENGTH_LONG).show();
            }
        }));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Person> persons =new ArrayList<>();
        persons.add(new Person("Amanda"));
        persons.add(new Person("Amanda"));
        persons.add(new Person("Amanda"));
        persons.add(new Person("Amanda"));
        persons.add(new Person("Amanda"));
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


        persons.add(new Person("Andreia"));

        adapter.setPeople(persons);
        //recyclerView.setAdapter(adapter);

        recyclerView.setAdapter(adapter);
    }
}
