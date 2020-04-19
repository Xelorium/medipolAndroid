package com.example.covidnineteen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class cl extends AppCompatActivity implements infReq.infReqListener {

    private ListView countryProps;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl);
        countryProps = findViewById(R.id.countryProps);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);


        infReq infReqq= new infReq(this);
        infReqq.execute();
    }

    @Override
    public void infReqDone(String result) {
        Gson tableCnt = new Gson();

        ProModel model = tableCnt.fromJson(result, ProModel.class);
        System.out.println(model.countries_stat[1].country_name);
        String countryId = getIntent().getExtras().getString("country");

        for (int i=1; i < model.countries_stat.length; i++ ){
        if (model.countries_stat[i].country_name.equals(countryId) ){
            arrayList.add("Ülke Adı: "+model.countries_stat[i].country_name);
            arrayList.add("Toplam Vaka: "+model.countries_stat[i].cases);
            arrayList.add("Toplam Ölüm: "+model.countries_stat[i].deaths);
            arrayList.add("Bölge: "+model.countries_stat[i].region);
            arrayList.add("Toplam İyileşen: "+model.countries_stat[i].total_recovered);
            arrayList.add("Bugünkü Ölümler: "+model.countries_stat[i].new_deaths);
            arrayList.add("Yeni Vakalar: "+model.countries_stat[i].new_cases);
            arrayList.add("Ciddi Vakalar: "+model.countries_stat[i].serious_critical);
            arrayList.add("Devam Eden Vakalar: "+model.countries_stat[i].active_cases);
            arrayList.add("total_cases_per_1m_population: "+model.countries_stat[i].total_cases_per_1m_population);
            arrayList.add("deaths_per_1m_population: "+model.countries_stat[i].deaths_per_1m_population);
            arrayList.add("Toplam Test: "+model.countries_stat[i].total_tests);
            arrayList.add("tests_per_1m_population: "+model.countries_stat[i].tests_per_1m_population);

            countryProps.setAdapter(arrayAdapter);

        }
        }
        //putextra ile veriyi al
        //put extara caont name esitse
        //listvieve hepsini kaydet
        //
        //
        //
        //
    }
}
