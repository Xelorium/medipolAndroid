package com.example.covidnineteen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

public class FragmentCorona extends Fragment implements CoronaReq.CoronaReqListener {

    TextView tvTotalCase;
    TextView tvTotalDeath;
    TextView tvTotalRecover;
    TextView tvDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_corona, container, false);

        tvTotalCase = view.findViewById(R.id.tvTotalCase);
        tvTotalDeath = view.findViewById(R.id.tvTotalDeath);
        tvTotalRecover = view.findViewById(R.id.tvTotalRecover);
        tvDate = view.findViewById(R.id.tvDate);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CoronaReq coronaReq = new CoronaReq(this);
        coronaReq.execute();
    }

    @Override
    public void coronaReqDone(String result) {
        Gson gson = new Gson();

        CoronaModel model = gson.fromJson(result, CoronaModel.class);

        tvTotalCase.setText("Total Cases: "+model.total_cases);
        tvTotalRecover.setText("Total Recovered Patients: "+model.total_recovered);
        tvTotalDeath.setText("Total Deaths: "+model.total_deaths);
        tvDate.setText("Last Updated: "+model.statistic_taken_at);

    }
}
