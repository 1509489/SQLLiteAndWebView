package com.pixelarts.sqlliteandwebview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDatabase";
    private static final String TAG = "MyDBTag";

    public static final  String TABLE_NAME = "Contacts";
    public static final String CONTACT_NAME = "Name";
    public static final String CONTACT_NUMBER = "Number";
    public static final String CONTACT_AGE = "Age";
    public static final String CONTACT_GENDER = "Gender";
    public static final String CONTACT_FAVORITE_ANIMAL = "FavoriteAnimal";

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + CONTACT_NAME + " TEXT,"+ CONTACT_NUMBER + " TEXT PRIMARY KEY," +
                CONTACT_AGE + " TEXT," + CONTACT_GENDER + " TEXT," + CONTACT_FAVORITE_ANIMAL + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void saveNewContact(Contacts contacts)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACT_NAME, contacts.getName());
        contentValues.put(CONTACT_NUMBER, contacts.getNumber());
        contentValues.put(CONTACT_AGE, contacts.getAge());
        contentValues.put(CONTACT_GENDER, contacts.getGender());
        contentValues.put(CONTACT_FAVORITE_ANIMAL, contacts.getFavoriteAnimal());
        database.insert(TABLE_NAME, null, contentValues);
        Log.d(TAG, "saveContact");

    }

    public List<Contacts> getContacts()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(query, null);
        List<Contacts> contacts = new ArrayList<>();
        if (cursor.moveToFirst())
        {
            do
            {
                Contacts contact = new Contacts(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4));
                contacts.add(contact);
            }while (cursor.moveToNext());
        }

        return  contacts;
    }
}
