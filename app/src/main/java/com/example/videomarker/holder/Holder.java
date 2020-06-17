package com.example.videomarker.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.videomarker.R;

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

    public String getId() {
        return textId.getText().toString();
    }

    public void setId(String value) {
        textId.setText(value);
    }

    public String getTitle() {
        return textName.getText().toString();
    }
    public void setTitle(String value) {
        textName.setText(value);
    }
    public String getContent() {
        return textType.getText().toString();
    }
    public void setContent(String value) {
        textType.setText(value);
    }
};