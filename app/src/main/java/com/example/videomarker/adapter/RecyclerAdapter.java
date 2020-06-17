package com.example.videomarker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videomarker.R;
import com.example.videomarker.data.entities.Data;
import com.example.videomarker.holder.Holder;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<Holder> {

    private List<Data> datas;

    public RecyclerAdapter(List<Data> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Data data = datas.get(position);
        holder.setId(String.valueOf(data.getResId()));
        holder.setTitle(data.getTitle());
        holder.setContent(data.getContent());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
