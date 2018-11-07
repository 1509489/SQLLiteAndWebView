package com.pixelarts.sqlliteandwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private WebView webView;
    private EditText etName, etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding Views
        webView = findViewById(R.id.webView);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);

        WebViewClient webViewClient = new WebViewClient();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(webViewClient);

        webView.loadUrl("https://developer.android.com");
    }

    public void saveContact(View view) {
        Contacts contact = new Contacts(etName.getText().toString(), etNumber.getText().toString());
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.saveNewContact(contact);
    }

    public void displayContact(View view) {
        Intent intent = new Intent(this, DisplayActivity.class);
        startActivity(intent);
    }
}
