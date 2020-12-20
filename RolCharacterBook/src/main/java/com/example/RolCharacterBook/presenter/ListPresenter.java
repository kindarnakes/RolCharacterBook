package com.example.RolCharacterBook.presenter;

import android.content.Context;

import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.model.Data;
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

    public void clickElement(Character element) {
        Data.getDATA().setActual(element);
    }

}
