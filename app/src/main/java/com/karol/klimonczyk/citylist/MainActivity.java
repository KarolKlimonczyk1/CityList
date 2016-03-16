package com.karol.klimonczyk.citylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<String> cities;
    private ListAdapter adapter;
    private com.android.volley.RequestQueue requestQueue;
    private AsyncGetCity asyncGetCity;
    private EditText cityEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // cities list
        cities=new ArrayList<String>();
        fillData();

        // custom adapter
        adapter=new ListAdapter(this, cities);

        // set custom adapter
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        //Volley
        requestQueue=Volley.newRequestQueue(this);

        // listView onclick
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View view, int i, long l) {

                // requestQueuee can work asynchronously  if it need. Nevertheless I use AsyncTask
                asyncGetCity = new AsyncGetCity(requestQueue, cities.get(i), getApplicationContext());
                asyncGetCity.execute();

            }
        });

         cityEt=(EditText)findViewById(R.id.cityEt);

    }



// test data
    void fillData() {
        cities.add("Wadowice");
        cities.add("Warszawa");
        cities.add("Katowice");
        cities.add("Olkusz");
        cities.add("fffzxc2");
        cities.add("yyuouiasd2");

    }

    public void addCity(View view) {
        cities.add(cityEt.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
