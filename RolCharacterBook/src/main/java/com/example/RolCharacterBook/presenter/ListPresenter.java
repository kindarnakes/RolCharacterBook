package com.example.RolCharacterBook.presenter;

import android.content.Context;
import android.view.View;

import com.example.RolCharacterBook.view.List;

public class ListPresenter {

    private Context context;
    private List view;

    public ListPresenter(List view) {
        this.context = view.getApplicationContext();
        this.view = view;
    }

    private ListPresenter() {
    }
}
