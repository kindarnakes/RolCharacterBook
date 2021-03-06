package com.example.RolCharacterBook.presenter;

import android.content.Context;
import com.example.RolCharacterBook.view.Help;

public class HelpPresenter {

    private Context context;
    private Help view;

    public HelpPresenter(Help view) {
        this.view = view;
        this.context = view.getApplicationContext();
    }

    private HelpPresenter() {
    }
}
