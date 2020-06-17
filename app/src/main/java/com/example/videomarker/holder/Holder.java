package com.example.videomarker.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.videomarker.R;

public class Holder extends RecyclerView.ViewHolder {

    private TextView textName;
    private TextView textDur;
    private TextView textTag;
    //private TextView textId;

    public Holder(View itemView) {
        super(itemView);
        textName = (TextView) itemView.findViewById(R.id.textName);
        textDur = (TextView) itemView.findViewById(R.id.textDur);
        //textId = (TextView) itemView.findViewById(R.id.textView3);

    }

    /*public String getId() {
        return textId.getText().toString();
    }
    public void setId(String value) {
        textId.setText(value);
    }*/

    public String getName() {
        return textName.getText().toString();
    }
    public void setName(String value) {
        textName.setText(value);
    }
    public String getDur() {
        return textDur.getText().toString();
    }
    public void setDur(String value) {
        textDur.setText(value);
    }
};