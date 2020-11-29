package com.example.RolCharacterBook.presenter;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.view.Form;

public class FormPresenter {

    private Character c;
    private Form view;
    private Context context;

    private FormPresenter() {
    }

    public FormPresenter(Form view) {
        this.c = new Character();
        this.view = view;
        context = view.getApplicationContext();
    }


    public String getError(int error){
        String errorS = "";

        switch (error){
            case -1:
               errorS = context.getResources().getString(R.string.error_1);
               break;
            case -2:
                errorS = context.getResources().getString(R.string.error_2);
                break;
            case -3:
                errorS = context.getResources().getString(R.string.error_3);
                break;
        }
        return errorS;
    }


    public int setName(String name){
        return c.setName(name);
    }

    public int setStrength(String strength){
        return c.setStrength(strength);
    }
    public int setDexterity(String dexterity){
        return c.setDexterity(dexterity);
    }
    public int setConstitution(String constitution){
        return c.setConstitution(constitution);
    }
    public int setIntelligence(String intelligence){
        return c.setIntelligence(intelligence);
    }
    public int setWisdom(String wisdom){
        return c.setWisdom(wisdom);
    }
    public int setCharisma(String charisma){
        return c.setCharisma(charisma);
    }
    public int setEmail(String email){
        return c.setEmail(email);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public int setDate(String email){
        return c.setPlayDate(email);
    }

    public void eraseYes(){
        view.finish();
    }


}
