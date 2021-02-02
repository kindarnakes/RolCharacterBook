package com.example.RolCharacterBook.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.model.Data;
import com.example.RolCharacterBook.presenter.FormPresenter;
import com.example.RolCharacterBook.presenter.SearchPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    private Button searchB;
    private Spinner sClass;


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
        sClass = findViewById(R.id.isclass);

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
                        dateSearchText.setText(String.valueOf(year) + "-" + ((month + 1) < 10 ? "0" : "") + String.valueOf(month + 1) + "-" + (day < 10 ? "0" : "") + String.valueOf(day));
                    }
                }, Year, Month, Day);
                // Mostrar el calendario
                datePickerDialog.show();
            }
        });

        setSpinner(Data.getDATA().loadClass(), sClass);


        searchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(v);
            }
        });


    }

    public void search(View v){
        String name = nameSearchText.getText().toString();
        String date = dateSearchText.getText().toString();
        String cclass = sClass.getSelectedItem().toString();
        ArrayList<Character> search = (ArrayList<Character>) presenter.search(name, date, cclass);
        Intent i = getIntent();
        Bundle b = new Bundle();
        b.putParcelableArrayList("search",search);
        i.putExtra("search",b);
        String message = "\n" + (date.equals("")? "":(context.getResources().getString(R.string.date)+": "+date + "\n")) +
                (name.equals("")?"":(context.getResources().getString(R.string.name)+": "+name + "\n")) +
                (cclass.equals("")?"":(context.getResources().getString(R.string.char_class)+": "+cclass+ "\n"));
        i.putExtra("message", message);
        setResult(1, i);
        finish();
    }

    private void setSpinner(ArrayList<String> arraySpinner, Spinner sp) {
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad.add("");
        sp.setAdapter(ad);
        sp.setSelection(ad.getPosition(""));
        sp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ad.remove("");
                ad.notifyDataSetChanged();
                return false;
            }
        });
    }
}