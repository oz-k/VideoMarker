package com.example.videomarker.activity;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.widget.Toast;
import android.provider.MediaStore;

import androidx.appcompat.app.AppCompatActivity;

import com.example.videomarker.R;
import com.example.videomarker.data.util.FileUtil;

public class InfoActivity extends AppCompatActivity {


    private String id;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();

        id = intent.getExtras().getString("ID");
        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
        //Uri singleUri = ContentUris.withAppendedId(MediaStore.Video.Media.getContentUri("external"),id);
        //FileUtil.getPath(context, singleUri);
        //getUriToPath();
        //TODO: ID로 MediaStore 검색 > 상세정보
        //TODO: TITLE로 FILE에서 검색 > RENAME, DELETE기능 구현 (일단 여기에 만들고 나중에 FileUtil로 넘어가기)
    }

    public void getUriToPath() {
        //final Uri uri = data.getData();
        //String path = FileUtil.getPath(context, uri);
    }
}
