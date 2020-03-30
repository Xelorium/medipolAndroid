package com.example.ders09_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

public class SecondAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(new MyViewAdapter(getSupportFragmentManager()));

        CirclePageIndicator indicator = findViewById(R.id.circleIndicator);
        indicator.setViewPager(pager);

       // TitlePageIndicator indicator = findViewById(R.id.titleIndicator);
       // indicator.setViewPager(pager);

    }
}
