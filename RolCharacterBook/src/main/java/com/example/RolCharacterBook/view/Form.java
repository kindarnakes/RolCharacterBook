package com.example.RolCharacterBook.view;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.presenter.FormPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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
    private  int Month;
    private int Day;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private Spinner s;
    private ArrayList<String> arraySpinner;
    private ArrayAdapter<String> adapter;


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

        arraySpinner = new ArrayList<>();
        arraySpinner.add(context.getResources().getString(R.string.barbarian));
        arraySpinner.add(context.getResources().getString(R.string.wizard));
        arraySpinner.add(context.getResources().getString(R.string.cleric));
        arraySpinner.add(context.getResources().getString(R.string.rogue));
        arraySpinner.add(context.getResources().getString(R.string.warrior));
        setSpinner(arraySpinner);

        presenter = new FormPresenter(this);

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



       nameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    int error = presenter.setName(nameText.getText().toString());
                    name.setError(presenter.getError(error));
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        strengthText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    int error = presenter.setStrength(strengthText.getText().toString());
                    strength.setError(presenter.getError(error));
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        dexterityText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    int error = presenter.setDexterity(dexterityText.getText().toString());
                    dexterity.setError(presenter.getError(error));
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        constitutionText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    int error = presenter.setConstitution(constitutionText.getText().toString());
                    constitution.setError(presenter.getError(error));
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        intelligenceText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    int error = presenter.setIntelligence(intelligenceText.getText().toString());
                    intelligence.setError(presenter.getError(error));
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        wisdomText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    int error = presenter.setWisdom(wisdomText.getText().toString());
                    wisdom.setError(presenter.getError(error));
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        charismaText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    int error = presenter.setCharisma(charismaText.getText().toString());
                    charisma.setError(presenter.getError(error));
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        emailText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    int error = presenter.setEmail(emailText.getText().toString());
                    email.setError(presenter.getError(error));
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });


        dateText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    int error = presenter.setDate(dateText.getText().toString());
                    date.setError(presenter.getError(error));
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });


        calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR) ;
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

                        dateText.setText(String.valueOf(year) + "-" + String.valueOf(month) + "-" + (day<10?"0":"") + String.valueOf(day));
                    }
                },Year, Month, Day);
                // Mostrar el calendario
                datePickerDialog.show();
            }
        });
    }

    private void setSpinner(ArrayList<String> arraySpinner) {
        s = (Spinner) findViewById(R.id.characterClass);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
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



    public void addClass(View v){

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
                        if(newS != null && !newS.matches("")) {
                            arraySpinner.add(newS);
                            setSpinner(arraySpinner);
                            s.setSelection(adapter.getPosition(newS));
                            Toast.makeText(getApplicationContext(), newS + context.getResources().getString(R.string.add), Toast.LENGTH_LONG).show();
                        }else{
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


}