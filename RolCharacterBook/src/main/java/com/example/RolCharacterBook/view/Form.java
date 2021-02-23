package com.example.RolCharacterBook.view;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.model.Data;
import com.example.RolCharacterBook.presenter.FormPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;

public class Form extends AppCompatActivity {

    private FormPresenter presenter;
    private TextInputLayout name;
    private TextInputEditText nameText;
    private TextInputLayout strength;
    private TextInputEditText strengthText;
    private TextInputLayout dexterity;
    private TextInputEditText dexterityText;
    private TextInputLayout constitution;
    private TextInputEditText constitutionText;
    private TextInputLayout intelligence;
    private TextInputEditText intelligenceText;
    private TextInputLayout wisdom;
    private TextInputEditText wisdomText;
    private TextInputLayout charisma;
    private TextInputEditText charismaText;
    private TextInputLayout email;
    private TextInputEditText emailText;
    private TextInputLayout date;
    private TextInputEditText dateText;
    private Context context;
    private ImageButton datePick;
    private int Year;
    private int Month;
    private int Day;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private Spinner s;
    private ArrayList<String> arraySpinner;
    private ArrayAdapter<String> adapter;
    private Button save;
    private ImageView portrait;
    private Switch player;
    private Button clearImg;
    private Button delete;


    public static final int REQUEST_SELECT_IMAGE = 201;
    final String pathFotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/images/";
    private Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        context = this;

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        presenter = new FormPresenter(this);
        arraySpinner = presenter.loadClass();
        setSpinner(arraySpinner);

        name = findViewById(R.id.name);
        nameText = findViewById(R.id.nameText);
        strength = findViewById(R.id.strength);
        strengthText = findViewById(R.id.strengthText);
        dexterity = findViewById(R.id.dexterity);
        dexterityText = findViewById(R.id.dexterityText);
        constitution = findViewById(R.id.constitution);
        constitutionText = findViewById(R.id.constitutionText);
        intelligence = findViewById(R.id.intelligence);
        intelligenceText = findViewById(R.id.intelligenceText);
        wisdom = findViewById(R.id.wisdom);
        wisdomText = findViewById(R.id.wisdomText);
        charisma = findViewById(R.id.charisma);
        charismaText = findViewById(R.id.charismaText);
        email = findViewById(R.id.email);
        emailText = findViewById(R.id.emailText);
        date = findViewById(R.id.playDate);
        dateText = findViewById(R.id.playDateText);
        save = findViewById(R.id.save);
        portrait = findViewById(R.id.imagePortrait);
        player = findViewById(R.id.player);
        clearImg = findViewById(R.id.clearImg);
        delete = findViewById(R.id.clearForm);

        delete.setVisibility(View.INVISIBLE);

        player.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                presenter.setNPC(isChecked);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate all fields, if all validates, object is set
                boolean check = checkField(nameText, name, "setName");
                check = checkField(strengthText, strength, "setStrength") ? check : false;
                check = checkField(strengthText, strength, "setStrength") ? check : false;
                check = checkField(dexterityText, dexterity, "setDexterity") ? check : false;
                check = checkField(constitutionText, constitution, "setConstitution") ? check : false;
                check = checkField(intelligenceText, intelligence, "setIntelligence") ? check : false;
                check = checkField(wisdomText, wisdom, "setWisdom") ? check : false;
                check = checkField(charismaText, charisma, "setCharisma") ? check : false;
                check = checkField(emailText, email, "setEmail") ? check : false;
                check = checkField(dateText, date, "setDate") ? check : false;
                String clas = (String) s.getSelectedItem();
                if (clas == null || (clas != null && clas.equals(""))) {
                    check = false;
                    Toast.makeText(context, context.getResources().getString(R.string.inv_class), Toast.LENGTH_SHORT).show();
                }

                if (check) {
                    presenter.setClass(s.getSelectedItem().toString());
                    presenter.generateUUID();
                    presenter.save();
                    presenter.finish();
                } else {
                    dialog(context.getResources().getString(R.string.error), context.getResources().getString(R.string.error_save), context.getResources().getString(R.string.acept));
                }

            }
        });

        portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenter.permission(Form.this)) {
                    //tenemos permiso
                    presenter.selectPicture();

                } else {
                    //no tenemos permiso
                    presenter.denied();
                }
            }
        });

        listenerCheckField(nameText, name, "setName");
        listenerCheckField(strengthText, strength, "setStrength");
        listenerCheckField(dexterityText, dexterity, "setDexterity");
        listenerCheckField(constitutionText, constitution, "setConstitution");
        listenerCheckField(intelligenceText, intelligence, "setIntelligence");
        listenerCheckField(wisdomText, wisdom, "setWisdom");
        listenerCheckField(charismaText, charisma, "setCharisma");
        listenerCheckField(emailText, email, "setEmail");
        listenerCheckField(dateText, date, "setDate");


        calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
        datePick = findViewById(R.id.dateButton);
        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Definir el calendario con la fecha seleccionada por defecto
                datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        Log.d("TAG", "onDateSet: " + month);
                        dateText.setText(String.valueOf(year) + "-" + ((month + 1) < 10 ? "0" : "") + String.valueOf(month + 1) + "-" + (day < 10 ? "0" : "") + String.valueOf(day));
                    }
                }, Year, Month, Day);
                // Mostrar el calendario
                datePickerDialog.show();
            }
        });
        clearImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setImg(null);
                portrait.setImageBitmap(null);
            }
        });


        if (presenter.isInit()) {
            Character c = presenter.getC();
            if (!arraySpinner.contains(c.getCharClass())) {
                arraySpinner.add(c.getCharClass());
                setSpinner(arraySpinner);
            }
            s.setSelection(adapter.getPosition(c.getCharClass()));
            nameText.setText(c.getName());
            emailText.setText(c.getEmail());
            dateText.setText(c.getPlayDateAsString());
            strengthText.setText(c.getStrength().toString());
            dexterityText.setText(c.getDexterity().toString());
            constitutionText.setText(c.getConstitution().toString());
            intelligenceText.setText(c.getIntelligence().toString());
            wisdomText.setText(c.getWisdom().toString());
            charismaText.setText(c.getCharisma().toString());
            portrait.setImageBitmap(c.getPortraitAsBitmap());
            player.setChecked(c.getPlayer());
            getSupportActionBar().setTitle(c.getName());
            delete.setVisibility(View.VISIBLE);
        }


    }

    private void setSpinner(ArrayList<String> arraySpinner) {
        s = (Spinner) findViewById(R.id.characterClass);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        adapter.add("");
        s.setAdapter(adapter);
        s.setSelection(adapter.getPosition(""));
        s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                adapter.remove("");
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public Context getContext() {
        return context;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void addClass(View v) {

        LayoutInflater li = LayoutInflater.from(Form.this);
        View promptsView = li.inflate(R.layout.add_class, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                Form.this);

        // set alert_dialog.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView.findViewById(R.id.etUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton(context.getResources().getString(R.string.acept), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String newS = userInput.getText().toString();
                        if (newS != null && !newS.matches("") && !arraySpinner.contains(newS)) {
                            arraySpinner.add(newS);
                            Data.getDATA().saveClass(newS);
                            setSpinner(arraySpinner);
                            s.setSelection(adapter.getPosition(newS));
                            Toast.makeText(getApplicationContext(), newS + context.getResources().getString(R.string.add), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), context.getResources().getString(R.string.empty_text), Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton(context.getResources().getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

        Button btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();
        layoutParams.weight = 10;
        btnPositive.setLayoutParams(layoutParams);
        btnNegative.setLayoutParams(layoutParams);
    }


    public void erase(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Form.this);
        builder.setTitle(context.getResources().getString(R.string.formEraseTitle));
        builder.setMessage(context.getResources().getString(R.string.formEraseText));

        //Yes Button
        builder.setPositiveButton(context.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.eraseYes();
                Log.i("erase ", "Yes button Clicked!");
            }
        });

        //No Button
        builder.setNegativeButton(context.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("erase", "No button Clicked!");
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        Button btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();
        layoutParams.weight = 10;
        btnPositive.setLayoutParams(layoutParams);
        btnNegative.setLayoutParams(layoutParams);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case FormPresenter.CODE_WRITE_EXTERNAL_STORAGE_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permiso aceptado
                    presenter.selectPicture();
                } else {
                    // Permiso rechazado
                    presenter.denied();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case (REQUEST_SELECT_IMAGE):
                if (resultCode == Activity.RESULT_OK) {
                    Bitmap bmp = presenter.imageSelected(data);

                    // Se carga el Bitmap en el ImageView
                    portrait.setImageBitmap(bmp);
                }
                break;
        }
    }


    private void listenerCheckField(TextInputEditText editText, TextInputLayout layoutText, String method) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    try {
                        Method m = FormPresenter.class.getDeclaredMethod(method, String.class);
                        int error = (int) m.invoke(presenter, editText.getText().toString());
                        layoutText.setError(presenter.getError(error));
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
    }

    private boolean checkField(TextInputEditText text, TextInputLayout layout, String method) {
        boolean correct = false;
        Method m = null;
        try {
            m = FormPresenter.class.getDeclaredMethod(method, String.class);
            int error = (int) m.invoke(presenter, text.getText().toString());
            layout.setError(presenter.getError(error));
            if (error == 0) {
                correct = true;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return correct;

    }

    private void dialog(String title, String message, String button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Form.this);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Button btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();
        layoutParams.weight = 10;
        btnPositive.setLayoutParams(layoutParams);
    }

}