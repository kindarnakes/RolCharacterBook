package com.example.RolCharacterBook.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.model.Character;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> implements View.OnClickListener {
    private ArrayList<Character> items;
    private View.OnClickListener listener;


    public CharacterAdapter(ArrayList<Character> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_row, parent, false);
        row.setOnClickListener(this);

        CharacterViewHolder avh = new CharacterViewHolder(row);
        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character item = items.get(position);
        holder.CharacterBind(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }


    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        private TextView TextView_characterName;
        private TextView TextView_emailCreator;
        private ImageView image;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView_characterName = (TextView) itemView.findViewById(R.id.characterName);
            TextView_emailCreator = (TextView) itemView.findViewById(R.id.emailCreator);
            image = (ImageView) itemView.findViewById(R.id.photo);
        }

        public void CharacterBind(Character item) {
            TextView_characterName.setText(item.getName());
            TextView_emailCreator.setText(item.getEmail());
            image.setImageBitmap(item.getPortraitAsBitmap());
        }

    }
}
