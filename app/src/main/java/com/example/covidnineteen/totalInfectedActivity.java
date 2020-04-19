package com.example.covidnineteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class totalInfectedActivity extends AppCompatActivity {

    Button affected_Countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_infected);
        affected_Countries= findViewById(R.id.affected_Countries);
        affected_Countries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(totalInfectedActivity.this, AffectedCountries.class);
                    startActivity(intent);

            }
        });

        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        FragmentCorona coronaMain = new FragmentCorona();
        trans.replace(R.id.totalInfected, coronaMain);
        trans.addToBackStack(null);
        trans.commit();
    }
}
