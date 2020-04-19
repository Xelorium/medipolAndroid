package com.example.covidnineteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class AffectedCountries extends AppCompatActivity implements CountReq.CountReqListener {

    ListView list_AffectedCountries;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected_countries);
        CountReq countReq = new CountReq(this);
        countReq.execute();
        list_AffectedCountries = findViewById(R.id.list_AffectedCountries);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);



    }

    @Override
    public void countReqDone(String result) {
        Gson gson = new Gson();

        CountModel model = gson.fromJson(result, CountModel.class);

        for (int i=1; i < model.affected_countries.length; i++ ){
            arrayList.add(model.affected_countries[i]);

        }

        list_AffectedCountries.setAdapter(arrayAdapter);
        list_AffectedCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String country= arrayList.get(position);
                Intent intent = new Intent(AffectedCountries.this, cl.class);
                intent.putExtra("country",country);
                startActivity(intent);
            }
        });
    }
}
