package com.example.ders09_03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

public class FragmentUlke extends Fragment implements AndroidReq.AndroidReqListener {

    ProgressBar bar;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ulke, container, false);

        bar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.rc);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AndroidReq req = new AndroidReq(this);
        req.execute();
    }

    @Override
    public void onRequestDone(String result) {
        bar.setVisibility(View.GONE);

        Gson gson = new Gson();

        CountryModel[] arr = gson.fromJson(result, CountryModel[].class);

        MyAdapter adapter = new MyAdapter(arr);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


    }
}


