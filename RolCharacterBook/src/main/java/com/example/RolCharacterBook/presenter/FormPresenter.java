package com.example.RolCharacterBook.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.model.Data;
import com.example.RolCharacterBook.view.Form;
import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class FormPresenter {

    private Character c;
    private Form view;
    private Context context;
    private Boolean init = false;
    public static final int CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 123;

    private FormPresenter() {
    }

    public FormPresenter(Form view) {
        Character c = Data.getDATA().getActual();
        if (c != null) {
            init = true;
            this.c = c;
        } else {
            init = false;
            this.c = new Character();
        }
        this.view = view;
        context = view.getApplicationContext();
    }

    public Character getC() {
        return c;
    }

    public String getError(int error) {
        String errorS = "";

        switch (error) {
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

    public Boolean isInit() {
        return init;
    }


    public int setName(String name) {
        return c.setName(name);
    }

    public int setStrength(String strength) {
        return c.setStrength(strength);
    }

    public int setDexterity(String dexterity) {
        return c.setDexterity(dexterity);
    }

    public int setConstitution(String constitution) {
        return c.setConstitution(constitution);
    }

    public int setIntelligence(String intelligence) {
        return c.setIntelligence(intelligence);
    }

    public int setWisdom(String wisdom) {
        return c.setWisdom(wisdom);
    }

    public int setCharisma(String charisma) {
        return c.setCharisma(charisma);
    }

    public int setEmail(String email) {
        return c.setEmail(email);
    }

    public int setDate(String date) {
        return c.setPlayDate(date);
    }

    public void setClass(String c) {
        this.c.setCharClass(c);
    }

    public void setNPC(Boolean npc) {
        c.setPlayer(npc);
    }


    public void eraseYes() {
        Data.getDATA().remove(c);
        view.finish();
    }

    public void finish() {
        view.finish();
    }

    public void setImg(String s) {
        c.setPortrait(s);
    }


    public boolean permission(Activity activity) {

        int WriteExternalStoragePermission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Log.d("FormPrsnter", "WRITE_EXTERNAL_STORAGE Permission: " + WriteExternalStoragePermission);

        if (WriteExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            // Permiso denegado
            // A partir de Marshmallow (6.0) se pide aceptar o rechazar el permiso en tiempo de ejecución
            // En las versiones anteriores no es posible hacerlo

            return false;
        } else {
            // Permiso aceptado
            return true;
        }

    }

    public void selectPicture() {
        // Se le pide al sistema una imagen del dispositivo
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        view.startActivityForResult(
                Intent.createChooser(intent, view.getResources().getString(R.string.chooseImg)),
                view.REQUEST_SELECT_IMAGE);
    }


    public void denied() {
        Snackbar snackbar = Snackbar
                .make(view.findViewById(R.id.coordinatorLayout), context.getResources().getString(R.string.needWrite), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void save() {
        Data.getDATA().save(c);
    }

    public ArrayList<String> loadClass() {
        return Data.getDATA().loadClass();
    }

    public void setPortrait(String encodeToString) {
        c.setPortrait(encodeToString);
    }

    public boolean getImage(int resultCode) {
        return  resultCode== Activity.RESULT_OK;
    }
}
