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
                MediaStore.Video.Media.DURATION
        };
        Cursor c = resolver.query(uri, projections, null, null, null);

        if (c != null) {
            while (c.moveToNext()) {
                int index = c.getColumnIndex(projections[0]);
                int id = c.getInt(index);

                index = c.getColumnIndex(projections[1]);
                String name = c.getString(index);

                index = c.getColumnIndex(projections[2]);
                String duration = c.getString(index);

                //Todo: 밀리세컨값을 그냥 뒤에 3자리를 짤라버리고 코딩함. 나중에 오류생기면 TimeUnit으로 바꿀것
                //Todo: 밀리세컨 > 시분초, Byte > MegaByte : presenter로 나중에 옮겨야됨(재사용가능한 코드로)
                int millis = Integer.parseInt(duration.substring(0,duration.length()-3));

                int h, m, s;
                String hour, min, sec;
                m = millis / 60;
                h = m / 60;
                s = millis % 60;
                m = m % 60;

                hour = Integer.toString(h) + ":";
                if(m<10) { min = "0" + Integer.toString(m) + ":"; }
                else{ min = Integer.toString(m) + ":"; }
                if(s<10) { sec = "0" + Integer.toString(s); }
                else{ sec = Integer.toString(s); }

                String dur = (hour + min + sec);


                Data data = new Data();
                //data.setResId(id);
                data.setName(name);
                data.setDur(dur);

                datas.add(data);
            }
        }
        c.close();
        return datas;
    }
}
