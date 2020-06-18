package com.example.videomarker.data.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.provider.MediaStore;

import androidx.annotation.Nullable;

import com.example.videomarker.data.entities.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContentLoader {

    public final List<Data> datas = new ArrayList<>();

    public List<Data> getContent(Context context) {

        ContentResolver resolver = context.getContentResolver(); //데이터를 가져오는 커넥터
        ContentLoader re = new ContentLoader();

        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String projections[] = {
                MediaStore.Video.Media._ID,
                MediaStore.Video.Media.TITLE,
                MediaStore.Video.Media.DURATION,
                MediaStore.Video.Media.SIZE,
                MediaStore.Video.Media.MIME_TYPE,
                MediaStore.Video.Media.DATE_ADDED
        };
        Cursor c = resolver.query(uri, projections, null, null, null);

        if (c != null) {
            while (c.moveToNext()) {
                int index = c.getColumnIndex(projections[0]);
                int id = c.getInt(index);

                index = c.getColumnIndex(projections[1]);
                String name = c.getString(index);

                index = c.getColumnIndex(projections[2]);
                String millisDur = c.getString(index);
                long millis = Long.parseLong(millisDur);

                index = c.getColumnIndex(projections[3]);
<<<<<<< Updated upstream
                String bsize = c.getString(index);
                int btomb = Integer.parseInt(bsize);
                String size = Integer.toString(btomb/1024/1024)+"MB";
=======
                String bytesize = c.getString(index);
                int size = Integer.parseInt(bytesize);
>>>>>>> Stashed changes

                index = c.getColumnIndex(projections[4]);
                String mime = c.getString(index);

                index = c.getColumnIndex(projections[5]);
                String added = c.getString(index);


                Data data = new Data();
                //data.setResId(id);
                data.setName(name);
<<<<<<< Updated upstream
                data.setDur(dur);
                data.setSize(size);
=======

                String changedTime = re.getReadableDuration(millis);
                data.setDur(changedTime);

                String changedSize = re.getReadableFileSize(size);
                data.setSize(changedSize);

>>>>>>> Stashed changes
                data.setMime(mime);
                data.setAdded(added);

                datas.add(data);
            }
        }
        c.close();
        return datas;
    }
<<<<<<< Updated upstream
    public static List<Data> Loader(Context context) {
        List<Data> datas = new ArrayList<>();
        return datas;
    }
=======
//    public static List<Data> getData(Context context) {
//        List<Data> datas = new ArrayList<>();
//
//        Data data = new Data();
//
//        data.setName(name);
//        data.setDur(dur);
//
//        datas.add(data);
//        return datas;
//    }

    //    public static List<Data> getInfoData(Context context) {
//        List<Data> datas = new ArrayList<>();
//
//        Data data = new Data();
//
//        data.setResId(id);
//        data.setName(name);
//        data.setDur(dur);
//        data.setSize(size);
//        data.setMime(mime);
//        data.setAdded(added);
//
//        datas.add(data);
//        return datas;
//    }
    public String getReadableFileSize(int size) {
        final int BYTES_IN_KILOBYTES = 1024;
        final DecimalFormat dec = new DecimalFormat("###.#");
        final String KILOBYTES = "KB";
        final String MEGABYTES = "MB";
        final String GIGABYTES = "GB";
        float fileSize = 0;
        String suffix = KILOBYTES;

        if (size > BYTES_IN_KILOBYTES) {
            fileSize = size / BYTES_IN_KILOBYTES;
            if (fileSize > BYTES_IN_KILOBYTES) {
                fileSize = fileSize / BYTES_IN_KILOBYTES;
                if (fileSize > BYTES_IN_KILOBYTES) {
                    fileSize = fileSize / BYTES_IN_KILOBYTES;
                    suffix = GIGABYTES;
                } else {
                    suffix = MEGABYTES;
                }
            }
        }
        return String.valueOf(dec.format(fileSize) + suffix);
    }

    public String getReadableDuration(long millis) {
        //TODO: 60분 미만이어도 00:00:00 로 표시되는 현상
        String dur = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), // The change is in this line
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        return dur;
    }

>>>>>>> Stashed changes
}
