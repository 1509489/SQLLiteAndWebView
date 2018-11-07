package com.pixelarts.sqlliteandwebview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    private static final String TAG = "DisplayActivity";

    private TextView tvName1, tvName2, tvName3, tvName4, tvName5;
    private TextView tvNumber1, tvNumber2, tvNumber3, tvNumber4, tvNumber5;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvName1 = findViewById(R.id.tvContact1Name);
        tvName2 = findViewById(R.id.tvContact2Name);
        tvName3 = findViewById(R.id.tvContact3Name);
        tvName4 = findViewById(R.id.tvContact4Name);
        tvName5 = findViewById(R.id.tvContact5Name);

        tvNumber1 = findViewById(R.id.tvContact1Number);
        tvNumber2 = findViewById(R.id.tvContact2Number);
        tvNumber3 = findViewById(R.id.tvContact3Number);
        tvNumber4 = findViewById(R.id.tvContact4Number);
        tvNumber5 = findViewById(R.id.tvContact5Number);

        listView = findViewById(R.id.listView);

    }

    @Override
    protected void onResume() {
        super.onResume();

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Contacts> contacts = databaseHelper.getContacts();

        for (Contacts  contact : contacts)
        {
            Log.d(TAG, "displayContact " + contact.getName() + " " + contact.getNumber());
        }

        for (int i = 0; i < contacts.size(); i++) {

            switch (i)
            {
                case 0:
                    tvName1.setText(contacts.get(i).getName());
                    tvNumber1.setText(contacts.get(i).getNumber());
                    break;

                case 1:
                    tvName2.setText(contacts.get(i).getName());
                    tvNumber2.setText(contacts.get(i).getNumber());
                    break;

                case 2:
                    tvName3.setText(contacts.get(i).getName());
                    tvNumber3.setText(contacts.get(i).getNumber());
                    break;

                case 3:
                    tvName4.setText(contacts.get(i).getName());
                    tvNumber4.setText(contacts.get(i).getNumber());
                    break;

                case 4:
                    tvName5.setText(contacts.get(i).getName());
                    tvNumber5.setText(contacts.get(i).getNumber());
                    break;

                    default:
                        break;
            }
        }
    }
}

class CustomAdapter extends ArrayAdapter<String>
{

    public CustomAdapter( Context context, int resource) {
        super(context, resource);
    }
}
