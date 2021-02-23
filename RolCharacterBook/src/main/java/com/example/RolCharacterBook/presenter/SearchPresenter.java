package com.example.RolCharacterBook.presenter;

import android.content.Context;

import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.model.Data;
import com.example.RolCharacterBook.view.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchPresenter {

    private Context context;
    private Search view;

    public SearchPresenter(Search view) {
        this.view = view;
        this.context = view.getApplicationContext();
    }

    private SearchPresenter() {
    }

    public void searchClick() {
        view.finish();
    }

    public List<Character> search(String name, String date, String charClass) {
        return Data.getDATA().search(name, date, charClass);
    }

    public ArrayList<String> loadClass() {
        return Data.getDATA().loadClass();
    }
}
