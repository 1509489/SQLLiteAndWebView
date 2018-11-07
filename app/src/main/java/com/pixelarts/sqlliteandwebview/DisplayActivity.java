package com.pixelarts.sqlliteandwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class DisplayActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DisplayActivity";

    private TextView tvName1, tvName2, tvName3, tvName4, tvName5;
    private TextView tvNumber1, tvNumber2, tvNumber3, tvNumber4, tvNumber5;
    private TextView tvAge1, tvAge2, tvAge3, tvAge4, tvAge5;
    private TextView tvGender1, tvGender2, tvGender3, tvGender4, tvGender5;
    private TextView tvFavoriteAnimal1, tvFavoriteAnimal2, tvFavoriteAnimal3, tvFavoriteAnimal4, tvFavoriteAnimal5;

    private LinearLayout llContact1, llContact2, llContact3, llContact4, llContact5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //Binding name text views
        tvName1 = findViewById(R.id.tvName1);
        tvName2 = findViewById(R.id.tvName2);
        tvName3 = findViewById(R.id.tvName3);
        tvName4 = findViewById(R.id.tvName4);
        tvName5 = findViewById(R.id.tvName5);

        //Binding phone number text views
        tvNumber1 = findViewById(R.id.tvNumber1);
        tvNumber2 = findViewById(R.id.tvNumber2);
        tvNumber3 = findViewById(R.id.tvNumber3);
        tvNumber4 = findViewById(R.id.tvNumber4);
        tvNumber5 = findViewById(R.id.tvNumber5);

        //Binding age text views
        tvAge1 = findViewById(R.id.tvAge1);
        tvAge2 = findViewById(R.id.tvAge2);
        tvAge3 = findViewById(R.id.tvAge3);
        tvAge4 = findViewById(R.id.tvAge4);
        tvAge5 = findViewById(R.id.tvAge5);

        //Binding gender text views
        tvGender1 = findViewById(R.id.tvGender1);
        tvGender2 = findViewById(R.id.tvGender2);
        tvGender3 = findViewById(R.id.tvGender3);
        tvGender4 = findViewById(R.id.tvGender4);
        tvGender5 = findViewById(R.id.tvGender5);

        //Binding favorite animal text views
        tvFavoriteAnimal1 = findViewById(R.id.tvFavoriteAnimal1);
        tvFavoriteAnimal2 = findViewById(R.id.tvFavoriteAnimal2);
        tvFavoriteAnimal3 = findViewById(R.id.tvFavoriteAnimal3);
        tvFavoriteAnimal4 = findViewById(R.id.tvFavoriteAnimal4);
        tvFavoriteAnimal5 = findViewById(R.id.tvFavoriteAnimal5);

        //Binding Linear layouts
        llContact1 = findViewById(R.id.llContact1);
        llContact2 = findViewById(R.id.llContact2);
        llContact3 = findViewById(R.id.llContact3);
        llContact4 = findViewById(R.id.llContact4);
        llContact5 = findViewById(R.id.llContact5);

        llContact1.setOnClickListener(this);
        llContact2.setOnClickListener(this);
        llContact3.setOnClickListener(this);
        llContact4.setOnClickListener(this);
        llContact5.setOnClickListener(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Contacts> contacts = databaseHelper.getContacts();

        for (Contacts  contact : contacts)
        {
            Log.d(TAG, "displayContact " + contact.getName() + " " + contact.getNumber() + " " +
            contact.getAge() + " " + contact.getGender() + " " + contact.getFavoriteAnimal());
        }

        for (int i = 0; i < contacts.size(); i++) {

            switch (i)
            {
                case 0:
                    tvName1.setText(contacts.get(i).getName());
                    tvNumber1.setText(contacts.get(i).getNumber());
                    tvAge1.setText(contacts.get(i).getAge());
                    tvGender1.setText(contacts.get(i).getGender());
                    tvFavoriteAnimal1.setText(contacts.get(i).getFavoriteAnimal());
                    break;

                case 1:
                    tvName2.setText(contacts.get(i).getName());
                    tvNumber2.setText(contacts.get(i).getNumber());
                    tvAge2.setText(contacts.get(i).getAge());
                    tvGender2.setText(contacts.get(i).getGender());
                    tvFavoriteAnimal2.setText(contacts.get(i).getFavoriteAnimal());
                    break;

                case 2:
                    tvName3.setText(contacts.get(i).getName());
                    tvNumber3.setText(contacts.get(i).getNumber());
                    tvAge3.setText(contacts.get(i).getAge());
                    tvGender3.setText(contacts.get(i).getGender());
                    tvFavoriteAnimal3.setText(contacts.get(i).getFavoriteAnimal());
                    break;

                case 3:
                    tvName4.setText(contacts.get(i).getName());
                    tvNumber4.setText(contacts.get(i).getNumber());
                    tvAge4.setText(contacts.get(i).getAge());
                    tvGender4.setText(contacts.get(i).getGender());
                    tvFavoriteAnimal4.setText(contacts.get(i).getFavoriteAnimal());
                    break;

                case 4:
                    tvName5.setText(contacts.get(i).getName());
                    tvNumber5.setText(contacts.get(i).getNumber());
                    tvAge5.setText(contacts.get(i).getAge());
                    tvGender5.setText(contacts.get(i).getGender());
                    tvFavoriteAnimal5.setText(contacts.get(i).getFavoriteAnimal());
                    break;

                    default:
                        break;
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.llContact1:
                Intent contact1Intent = new Intent(this, DetailActivity.class);
                contact1Intent.putExtra("name", tvName1.getText().toString());
                contact1Intent.putExtra("number", tvNumber1.getText().toString());
                contact1Intent.putExtra("age", tvAge1.getText().toString());
                contact1Intent.putExtra("gender", tvGender1.getText().toString());
                contact1Intent.putExtra("favoriteAnimal", tvFavoriteAnimal1.getText().toString());
                startActivity(contact1Intent);
                break;

            case R.id.llContact2:
                Intent contact2Intent = new Intent(this, DetailActivity.class);
                contact2Intent.putExtra("name", tvName2.getText().toString());
                contact2Intent.putExtra("number", tvNumber2.getText().toString());
                contact2Intent.putExtra("age", tvAge2.getText().toString());
                contact2Intent.putExtra("gender", tvGender2.getText().toString());
                contact2Intent.putExtra("favoriteAnimal", tvFavoriteAnimal2.getText().toString());
                startActivity(contact2Intent);
                break;

            case R.id.llContact3:
                Intent contact3Intent = new Intent(this, DetailActivity.class);
                contact3Intent.putExtra("name", tvName3.getText().toString());
                contact3Intent.putExtra("number", tvNumber3.getText().toString());
                contact3Intent.putExtra("age", tvAge3.getText().toString());
                contact3Intent.putExtra("gender", tvGender3.getText().toString());
                contact3Intent.putExtra("favoriteAnimal", tvFavoriteAnimal3.getText().toString());
                startActivity(contact3Intent);
                break;

            case R.id.llContact4:
                Intent contact4Intent = new Intent(this, DetailActivity.class);
                contact4Intent.putExtra("name", tvName4.getText().toString());
                contact4Intent.putExtra("number", tvNumber4.getText().toString());
                contact4Intent.putExtra("age", tvAge4.getText().toString());
                contact4Intent.putExtra("gender", tvGender4.getText().toString());
                contact4Intent.putExtra("favoriteAnimal", tvFavoriteAnimal4.getText().toString());
                startActivity(contact4Intent);
                break;

            case R.id.llContact5:
                Intent contact5Intent = new Intent(this, DetailActivity.class);
                contact5Intent.putExtra("name", tvName5.getText().toString());
                contact5Intent.putExtra("number", tvNumber5.getText().toString());
                contact5Intent.putExtra("age", tvAge5.getText().toString());
                contact5Intent.putExtra("gender", tvGender5.getText().toString());
                contact5Intent.putExtra("favoriteAnimal", tvFavoriteAnimal5.getText().toString());
                startActivity(contact5Intent);
                break;

                default:
                    break;
        }
    }
}
