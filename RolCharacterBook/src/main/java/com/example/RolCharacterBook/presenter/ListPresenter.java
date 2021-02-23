package com.example.RolCharacterBook.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.model.Data;
import com.example.RolCharacterBook.view.CharacterAdapter;
import com.example.RolCharacterBook.view.Form;
import com.example.RolCharacterBook.view.List;

import java.util.ArrayList;

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
        if (element != null) {
            Data.getDATA().getById(element.getId());
        } else {
            Data.getDATA().setActual(element);
        }
    }


    public int swiped(RecyclerView.ViewHolder viewHolder, ArrayList<Character> items, CharacterAdapter adapter, TextView text) {
        int position = viewHolder.getLayoutPosition();
        Character removed = items.remove(position);
        if (items.contains(removed)) {
            return -1;
        } else {
            Data.getDATA().remove(removed);
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
            text.setText(context.getResources().getText(R.string.number_elements) + String.valueOf(items.size()));
            return position;

        }
    }

    public ArrayList<Character> load() {
        return Data.getDATA().loadAll();
    }


    public Character getElement(int pos) {
        return Data.getDATA().getItems().get(pos);
    }


    public void addElement() {
        Intent intent = new Intent(view, Form.class);
        view.startActivity(intent);
    }
}
