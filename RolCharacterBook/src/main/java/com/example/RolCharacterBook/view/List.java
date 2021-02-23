package com.example.RolCharacterBook.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.model.Character;
import com.example.RolCharacterBook.model.Data;
import com.example.RolCharacterBook.presenter.ListPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    private ListPresenter presenter;
    private RecyclerView recyclerView;
    private Context context;
    private ConstraintLayout layout;
    private TextView nelements;
    private CharacterAdapter adapter;
    private Boolean loadorsearch = true;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        presenter = new ListPresenter(this);
        context = this;
        recyclerView = findViewById(R.id.recycler);
        nelements = findViewById(R.id.nelements);
        swipeContainer = findViewById(R.id.swipeContainer);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadorsearch = true;
                loadData(adapter);
                swipeContainer.setRefreshing(false);
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clickElement(null);
                Intent intent = new Intent(List.this, Form.class);
                startActivity(intent);
            }
        });

        adapter = new CharacterAdapter(new ArrayList<>());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.search:
                intent = new Intent(List.this, Search.class);
                startActivityForResult(intent, 1);
                loadorsearch = false;
                return true;
            case R.id.about:
                intent = new Intent(List.this, About.class);
                startActivity(intent);
                return true;
            case R.id.help:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("RESULT", String.valueOf(resultCode));
        if (resultCode == 1) {
            ArrayList<Character> chars = data.getExtras().getBundle("search").getParcelableArrayList("search");
            String msg = data.getExtras().getString("message");
            adapter.setItems(chars);
            adapter.notifyDataSetChanged();
            nelements.setText(context.getResources().getString(R.string.number_elements) + chars.size() + msg);

        } else {
            loadorsearch = true;
        }

    }

    public void loadData(CharacterAdapter adapter) {
        ArrayList<Character> items = presenter.load();
        nelements.setText(context.getResources().getString(R.string.number_elements) + items.size());
        adapter.setItems(items);
        Log.d("PASO", "loadData");
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickElement(presenter.getElement(recyclerView.getChildAdapterPosition(v)));
                Intent intent = new Intent(List.this, Form.class);
                startActivity(intent);

            }
        });

        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.
                SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                presenter.swiped(viewHolder, Data.getDATA().getItems(), adapter, nelements);

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        adapter.notifyDataSetChanged();

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (loadorsearch) {
            loadData(adapter);
        } else {
            loadorsearch = true;
        }
    }
}