package com.example.videomarker.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videomarker.R;
import com.example.videomarker.activity.MainActivity;
import com.example.videomarker.data.Data;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    private List<Data> datas;
    //Todo: 깃허브
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

    public class Holder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        private TextView textName;
        private TextView textType;
        private TextView textId;

        public Holder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.textView1);
            textType = (TextView) itemView.findViewById(R.id.textView2);
            textId = (TextView) itemView.findViewById(R.id.textView3);

            itemView.setOnCreateContextMenuListener(this);
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

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Info = menu.add(Menu.NONE, 1001, 1, "정보");
            MenuItem Delete = menu.add(Menu.NONE, 1002, 2, "삭제");
            Info.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
        }
        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
//        @Override
//        public boolean onMenuItemClick(MenuItem item) {
//            switch (item.getItemId()) {
//                case 1001:
//                    //Intent intent = new Intent;
//                case 1002:
//                    //AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                    //builder.setTitle("삭제");
//                    //builder.setMessage("삭제하시겠습니까?");
//                    //builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(context, "삭제되었습니다", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                    builder.setNegativeButton("취소", null);
//            }
//            return true;
//        }
    };
}
