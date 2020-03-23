package com.example.ders09_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements AndroidReq.AndroidReqListener {


    Button btnRq;
    TextView tvRq;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRq = findViewById(R.id.btnRq);
        tvRq = findViewById(R.id.tvRq);
        bar = findViewById(R.id.bar);

        btnRq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.setVisibility(View.VISIBLE);
                AndroidReq req = new AndroidReq(MainActivity.this);
                req.execute();
            }
        });



    }

    @Override
    public void onRequestDone(String result) {
        bar.setVisibility(View.GONE);
        tvRq.setText(result);

        Intent intent = new Intent(this, UlkeAct.class);

        Bundle bundle = new Bundle();
        bundle.putString("data", result);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
