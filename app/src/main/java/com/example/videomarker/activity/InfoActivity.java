package com.example.videomarker.activity;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.MediaStore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.videomarker.R;
import com.example.videomarker.adapter.RecyclerAdapter;
import com.example.videomarker.data.util.ContentLoader;
import com.example.videomarker.data.entities.Data;

import java.util.List;

public class InfoActivity extends AppCompatActivity {


    private String id;
    public Uri contentUri;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_info);

        Intent intent = getIntent();

        id = intent.getExtras().getString("ID");


        //TODO: ID로 MediaStore 검색 > 상세정보
        //TODO: TITLE로 FILE에서 검색 > RENAME, DELETE기능 구현 (일단 여기에 만들고 나중에 FileUtil로 넘어가기)
        //Id를 Uri로 변환하는 코드
        contentUri = Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id.toString());
        Toast.makeText(getApplicationContext(), contentUri.toString(), Toast.LENGTH_SHORT).show();

        final EditText et = new EditText(InfoActivity.this);
        Button reNameBtn = (Button) findViewById(R.id.reName);
        reNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(InfoActivity.this);
                builder.setView(et);
                builder.setTitle("파일 명 변경");
                builder.setMessage("파일 명을 변경하시겠습니까?");
                et.setHint(name);
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ContentValues updateValue = new ContentValues(); //업데이트 할 값을 저장하는 객체 생성
                        Uri uri = contentUri;
                        String proj[] = {
                            MediaStore.Video.Media.TITLE
                        };
                        String selection = MediaStore.Video.Media.TITLE; //무엇을 업데이트 할지 설정

                        //업데이트 할 값, 업데이트
                        updateValue.put(MediaStore.Video.Media.TITLE, et.getText().toString());
                        getContentResolver().update(uri, updateValue, selection, null);
                        getContentResolver().query(uri, proj, null,null,null);
                        getVideoInfo();
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });


        getVideoInfo();
    }


    public void getVideoInfo() {

        TextView tv1 = (TextView) findViewById(R.id.fName);
        TextView tv2 = (TextView) findViewById(R.id.fDuration);
        TextView tv3 = (TextView) findViewById(R.id.fSize);
        TextView tv4 = (TextView) findViewById(R.id.fMime);
        TextView tv5 = (TextView) findViewById(R.id.fAdded);
        TextView tv6 = (TextView) findViewById(R.id.fPath);

        ContentLoader re = new ContentLoader();
        ContentResolver resolver = getApplicationContext().getContentResolver();

        Uri uri = contentUri;
        String projections[] = {
                MediaStore.Video.Media._ID,
                MediaStore.Video.Media.TITLE,
                MediaStore.Video.Media.DURATION,
                MediaStore.Video.Media.SIZE,
                MediaStore.Video.Media.MIME_TYPE,
                MediaStore.Video.Media.DATE_ADDED,
                MediaStore.Video.Media.DATA
        };

        Cursor c = resolver.query(uri, projections, null,null,null);

        if (c != null) {
            while (c.moveToNext()) {
                int index = c.getColumnIndex(projections[0]);
                int id = c.getInt(index);

                index = c.getColumnIndex(projections[1]);
                name = c.getString(index);

                index = c.getColumnIndex(projections[2]);
                String millisDur = c.getString(index);
                long millis = Long.parseLong(millisDur);

                index = c.getColumnIndex(projections[3]);
                String bytesize = c.getString(index);
                int size = Integer.parseInt(bytesize);

                index = c.getColumnIndex(projections[4]);
                String mime = c.getString(index);

                index = c.getColumnIndex(projections[5]);
                String added = c.getString(index);

                index = c.getColumnIndex(projections[6]);
                String path = c.getString(index);

                String changedTime = re.getReadableDuration(millis);
                String changedSize = re.getReadableFileSize(size);

                tv1.setText(name);
                tv2.setText(changedTime);
                tv3.setText(changedSize);
                tv4.setText(mime);
                tv5.setText(added);
                tv6.setText(path);
            }
        }
        c.close();
    }


    //TODO: 이 메소드는 android api 29 부터 permission을 요구함 https://codechacha.com/ko/android-mediastore-remove-media-files/ 참고
    private void deleteContent(Context context, Uri contentUri) {
        List<Data> datas = ContentLoader.getContent(context);
        ContentResolver cr = context.getContentResolver();
        cr.delete(contentUri, null, null);
        RecyclerAdapter adapter = new RecyclerAdapter(datas, context);
        adapter.notifyDataSetChanged();
    }

    public void getUriToPath() {
        //final Uri uri = data.getData();
        //String path = FileUtil.getPath(context, uri);
    }
}
