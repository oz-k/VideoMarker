package com.example.videomarker.ui.main.folder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FolderViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FolderViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Folder fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}