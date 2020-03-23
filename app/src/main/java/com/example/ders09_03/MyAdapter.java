package com.example.ders09_03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public CountryModel[] arr;

    public MyAdapter(CountryModel[] arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view  = inflater.inflate(R.layout.recycler_item, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvName.setText(arr[position].name);
        holder.tvCapital.setText(arr[position].capital);
        holder.tvPopulation.setText(arr[position].population + "");
        holder.tvTranslation.setText(arr[position].translations.de + " " + arr[position].translations.fr + " " +
                arr[position].translations.es);

    }

    @Override
    public int getItemCount() {
        return arr.length;
    }
}
