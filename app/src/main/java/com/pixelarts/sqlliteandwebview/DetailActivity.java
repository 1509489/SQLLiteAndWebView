package com.pixelarts.sqlliteandwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvNumber, tvAge, tvGender, tvFavoriteAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tvName);
        tvNumber = findViewById(R.id.tvNumber);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        tvFavoriteAnimal = findViewById(R.id.tvFavoriteAnimal);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String getName = getIntent().getStringExtra("name");
        String getNumber = getIntent().getStringExtra("number");
        String getAge = getIntent().getStringExtra("age");
        String getGender = getIntent().getStringExtra("gender");
        String getFavoriteAnimal = getIntent().getStringExtra("favoriteAnimal");

        tvName.setText("Name: " + getName);
        tvNumber.setText("Number: " + getNumber);
        tvAge.setText("Age: " + getAge);
        tvGender.setText("Gender: " + getGender);
        tvFavoriteAnimal.setText("Favorite Animal: " + getFavoriteAnimal);
    }
}
