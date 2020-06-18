package com.example.videomarker.activity;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;

import com.example.videomarker.R;
import com.example.videomarker.data.util.FileUtil;

public class InfoActivity extends AppCompatActivity {

    private int id;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        id = intent.getExtras().getInt("ID");
        Uri singleUri = ContentUris.withAppendedId(MediaStore.Video.Media.getContentUri("external"),id);
        FileUtil.getPath(context, singleUri);
        getUriToPath();
    }

    public void getUriToPath() {
        final Uri uri = data.getData();
        String path = FileUtil.getPath(context, uri);


    }
}
