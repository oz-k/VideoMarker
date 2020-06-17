package com.example.videomarker.data.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.videomarker.data.entities.Data;

import java.util.ArrayList;
import java.util.List;

public class Loader {
    public static List<Data> getData(Context context) {
        List<Data> datas = new ArrayList<>();
        //로직

        ContentResolver resolver = context.getContentResolver(); //데이터를 가져오는 커넥터

        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String projections[] = {
                MediaStore.Video.Media._ID,
                MediaStore.Video.Media.TITLE,
                MediaStore.Video.Media.MIME_TYPE
        };
        Cursor c = resolver.query(uri, projections, null, null, null);

        if (c != null) {
            while (c.moveToNext()) {
                int index = c.getColumnIndex(projections[0]);
                int id = c.getInt(index);

                index = c.getColumnIndex(projections[1]);
                String name = c.getString(index);

                index = c.getColumnIndex(projections[2]);
                String type = c.getString(index);


                Data data = new Data();
                data.setResId(id);
                data.setTitle(name);
                data.setContent(type);

                datas.add(data);
            }
        }
        c.close();
        return datas;
    }
}
