package com.example.RolCharacterBook.presenter;

import android.content.Context;

import com.example.RolCharacterBook.view.Search;

public class SearchPresenter {

    private Context context;
    private Search view;

    public SearchPresenter(Search view) {
        this.view = view;
        this.context = view.getApplicationContext();
    }

    private SearchPresenter() {
    }
}
