package com.example.RolCharacterBook.presenter;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.model.Data;
import com.example.RolCharacterBook.view.CharacterAdapter;
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
        Data.getDATA().setActual(element);
    }


    public void swiped(RecyclerView.ViewHolder viewHolder, ArrayList<Character> items, CharacterAdapter adapter) {
        int position = viewHolder.getAdapterPosition();
        Toast.makeText(context, context.getResources().getString(R.string.deleted) + items.get(position).getName(), Toast.LENGTH_SHORT).show();
        Character removed = items.remove(position);
        if (items.contains(removed)) {
            Toast.makeText(context, context.getResources().getString(R.string.noDeleted) + items.get(position).getName(), Toast.LENGTH_SHORT).show();
        } else {
            adapter.notifyDataSetChanged();
            Toast.makeText(context, context.getResources().getString(R.string.deleted) + items.get(position).getName(), Toast.LENGTH_SHORT).show();

        }
    }

}
