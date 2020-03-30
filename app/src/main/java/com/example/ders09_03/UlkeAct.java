package com.example.ders09_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;

public class UlkeAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ulke);

        Bundle bundle = getIntent().getExtras();
        String result = bundle.getString("data");

        Gson gson = new Gson();

        CountryModel[] arr = gson.fromJson(result, CountryModel[].class);

        MyAdapter adapter = new MyAdapter(arr);

        RecyclerView recyclerView = findViewById(R.id.rc);

        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(adapter);

    }
}
