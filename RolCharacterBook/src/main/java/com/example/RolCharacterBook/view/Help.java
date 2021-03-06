package com.example.RolCharacterBook.view;

import android.os.Bundle;

import com.example.RolCharacterBook.R;
import com.example.RolCharacterBook.presenter.AboutPresenter;
import com.example.RolCharacterBook.presenter.HelpPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Help extends AppCompatActivity {
    private HelpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        presenter = new HelpPresenter(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




        WebView myWebView = (WebView) findViewById(R.id.webViewer);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        int opt = getIntent().getIntExtra("page", 0);
        String url;
        switch(opt){
            case 1:
                url = "https://kindarnakes.github.io/RolCharacterBook/list.html";
                break;
            case 2:
                url= "https://kindarnakes.github.io/RolCharacterBook/form.html";
                break;
            case 3:
                url= "https://kindarnakes.github.io/RolCharacterBook/search.html";
                break;
            default:
                url = "https://kindarnakes.github.io/RolCharacterBook/";
        }
        myWebView.loadUrl(url);
    }
}