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
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private WebView webView;
    private EditText etName, etNumber, etAge, etGender, etFavoriteAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding Views
        webView = findViewById(R.id.webView);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etAge = findViewById(R.id.etAge);
        etGender = findViewById(R.id.etGender);
        etFavoriteAnimal = findViewById(R.id.etFavoriteAnimal);

        WebViewClient webViewClient = new WebViewClient();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(webViewClient);

        webView.loadUrl("https://developer.android.com");
    }

    public void saveContact(View view) {
        String name = etName.getText().toString();
        String number = etNumber.getText().toString();
        String age = etAge.getText().toString();
        String gender = etGender.getText().toString();
        String favoriteAnimal = etFavoriteAnimal.getText().toString();

        if(!name.equals("") && !number.equals("") && !age.equals("") && !gender.equals("") && !favoriteAnimal.equals(""))
        {
            Contacts contact = new Contacts(name, number, age, gender, favoriteAnimal );
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            databaseHelper.saveNewContact(contact);
            Toast.makeText(this, "Contact saved", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "All the text boxes must be filled", Toast.LENGTH_LONG).show();
    }

    public void displayContact(View view) {
        Intent intent = new Intent(this, DisplayActivity.class);
        startActivity(intent);
    }

    public void clear(View view) {
        etName.setText("");
        etNumber.setText("");
        etAge.setText("");
        etGender.setText("");
        etFavoriteAnimal.setText("");
    }
}
