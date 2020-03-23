package com.example.ders09_03;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tvName;
    public TextView tvCapital;
    public TextView tvPopulation;
    public TextView tvTranslation;

    public MyViewHolder(@NonNull View itemView) {

        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        tvCapital = itemView.findViewById(R.id.tvCapital);
        tvPopulation = itemView.findViewById(R.id.tvPopulation);
        tvTranslation = itemView.findViewById(R.id.tvTranslation);

    }
}
