package com.example.videomarker.ui.main.folder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.videomarker.R;

public class FolderFragment extends Fragment {

    private FolderViewModel folderViewModel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        folderViewModel =
                ViewModelProviders.of(this).get(FolderViewModel.class);
        View root = inflater.inflate(R.layout.fragment_folder, container, false);
        final TextView textView = root.findViewById(R.id.text_folder);
        folderViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
