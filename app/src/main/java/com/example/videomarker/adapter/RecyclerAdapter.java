package com.example.videomarker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videomarker.R;
import com.example.videomarker.data.Data;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    private List<Data> datas;

    public RecyclerAdapter(List<Data> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
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

    public class Holder extends RecyclerView.ViewHolder {

        private TextView textName;
        private TextView textType;
        private TextView textId;

        public Holder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.textView1);
            textType = (TextView) itemView.findViewById(R.id.textView2);
            textId = (TextView) itemView.findViewById(R.id.textView3);
        }
        public String getId() { return textId.getText().toString(); }
        public void setId(String value) {textId.setText(value);}
        public String getTitle(){
            return textName.getText().toString();
        }
        public void setTitle (String value){
            textName.setText(value);
        }
        public String getContent() {
            return  textType.getText().toString();
        }
        public void setContent(String value) {
            textType.setText(value);
        }

        /*asdad*/
/*        hello*/
/*        dasdasdsasad*/
    }


}
