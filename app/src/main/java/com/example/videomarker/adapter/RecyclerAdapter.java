package com.example.videomarker.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videomarker.R;
import com.example.videomarker.activity.InfoActivity;
import com.example.videomarker.data.entities.Data;
import com.example.videomarker.holder.Holder;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<Holder> {

    private List<Data> datas;
    public final Context context;
<<<<<<< Updated upstream
=======
    private String id;
>>>>>>> Stashed changes

    public RecyclerAdapter(List<Data> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        Data data = datas.get(position);
        //holder.setId(String.valueOf(data.getResId()));
        holder.setName(data.getName());
        holder.setDur(data.getDur());
        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< Updated upstream
                showPopup(v, context);
            }
        });

=======
                onItemLongClick(v,position);
            }
        });
>>>>>>> Stashed changes
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

<<<<<<< Updated upstream
    private void showPopup(final View v, final Context context){
=======
    @Override
    public void onItemLongClick(View v, int position) {
        List<Data> datas = ContentLoader.getContent(context);

        id = String.valueOf(datas.get(position).getResId());
>>>>>>> Stashed changes
        PopupMenu p = new PopupMenu(context, v);
        MenuInflater inflater = p.getMenuInflater();
        Menu menu = p.getMenu();
        inflater.inflate(R.menu.popup_menu, menu);

        p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pPlay:
                        break;
                    case R.id.pInfo:
                        Intent intent = new Intent(context, InfoActivity.class);
                        //intent.putExtra("Uri", );
                        context.startActivity(intent);
                        break;
                    case R.id.pAddpl:
                        break;
                    case R.id.pDel:

                        break;
                }
                return false;
            }
        });
        p.show();
    }
}
