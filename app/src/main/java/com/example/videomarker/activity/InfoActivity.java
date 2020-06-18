package com.example.videomarker.activity;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< Updated upstream
import android.view.View;
import android.widget.Button;
=======
import android.provider.MediaStore;
import android.widget.Toast;
>>>>>>> Stashed changes

import androidx.appcompat.app.AppCompatActivity;

import com.example.videomarker.R;

public class InfoActivity extends AppCompatActivity {
<<<<<<< Updated upstream
    private String fileUri;
    private Button close;
=======

    private String id;
    private Context context;

>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
<<<<<<< Updated upstream
=======
        id = intent.getExtras().getString("ID");
        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
        //Uri singleUri = ContentUris.withAppendedId(MediaStore.Video.Media.getContentUri("external"),id);
        //FileUtil.getPath(context, singleUri);
        //getUriToPath();
    }

    public void getUriToPath() {
        //final Uri uri = data.getData();
        //String path = FileUtil.getPath(context, uri);

>>>>>>> Stashed changes

    }
}
