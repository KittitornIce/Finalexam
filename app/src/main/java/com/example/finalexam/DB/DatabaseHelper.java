package com.example.finalexam.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Kittitorn on 18-Dec-16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "login.db"; //ชื่อDB
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "user";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";


    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_USERNAME + " TEXT, "
                    + COL_PASSWORD + " TEXT "
                    + ")"; // insert ข้อมูลลงDB

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE);
        insertIntitial(db);

    }

    private void insertIntitial(SQLiteDatabase db) {

        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "Android Studio");
        cv.put(COL_USERNAME, "androidd");
        cv.put(COL_PASSWORD, "123456");
        db.insert(TABLE_NAME, null, cv);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade(): oldVersion = " + oldVersion +", newVersion =" + newVersion);

        db.execSQL("DROP TABLE " + TABLE_NAME);
        db.execSQL(SQL_CREATE_TABLE);
        insertIntitial(db);

    }
}
