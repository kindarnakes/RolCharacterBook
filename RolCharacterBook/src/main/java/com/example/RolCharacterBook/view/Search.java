package com.example.RolCharacterBook.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.presenter.SearchPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class Search extends AppCompatActivity {

    private SearchPresenter presenter;
    private TextInputLayout nameSearch;
    private TextInputEditText nameSearchText;
    private TextInputLayout dateSearch;
    private TextInputEditText dateSearchText;
    private ImageButton calendarB;
    private int Year;
    private int Month;
    private int Day;
    private Calendar calendar;
    private Context context;
    private DatePickerDialog datePickerDialog;
    private Spinner s;
    private ArrayList<String> arraySpinner;
    private ArrayAdapter<String> adapter;
    private Button searchB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        presenter = new SearchPresenter(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.searchClick();
            }
        });

        context = this;


        nameSearch = findViewById(R.id.nameSearch);
        nameSearchText = findViewById(R.id.nameSearchText);
        dateSearch = findViewById(R.id.dateSearch);
        dateSearchText = findViewById(R.id.dateSearchText);
        calendarB = findViewById(R.id.calendarButton);
        searchB = findViewById(R.id.searchButton);

        dateSearchText.setEnabled(false);

        calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
        calendarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Definir el calendario con la fecha seleccionada por defecto
                datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    // Definir la acción al pulsar OK en el calendario
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        // Asignar la fecha a un campo de texto
                        dateSearchText.setText(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day));
                    }
                }, Year, Month, Day);
                // Mostrar el calendario
                datePickerDialog.show();
            }
        });

        arraySpinner = new ArrayList<>();
        arraySpinner.add(context.getResources().getString(R.string.before));
        arraySpinner.add(context.getResources().getString(R.string.after));
        arraySpinner.add(context.getResources().getString(R.string.exactDate));
        setSpinner(arraySpinner);

        searchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void setSpinner(ArrayList<String> arraySpinner) {
        s = (Spinner) findViewById(R.id.isplayer);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
}