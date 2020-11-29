package com.example.RolCharacterBook.presenter;

import android.content.Context;

import com.example.RolCharacterBook.view.About;

public class AboutPresenter {

    private Context context;
    private About view;

    public AboutPresenter(About view) {
        this.view = view;
        this.context = view.getApplicationContext();
    }

    private AboutPresenter() {
    }
}
