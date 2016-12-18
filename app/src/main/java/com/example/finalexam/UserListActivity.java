package com.example.finalexam;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.support.v7.app.AppCompatActivity;
import com.example.finalexam.DB.DatabaseHelper;
import com.example.finalexam.MODEL.Contact;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private ListView mContactListView;

    private ArrayList<Contact> mContactList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();
        mContactListView = (ListView) findViewById(R.id.contact_list);

    }

    protected void onResume() {
        super.onResume();

        Cursor cursor = mDb.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);

        mContactList.clear();

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
            String username = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));

            Contact contact = new Contact(name, username, password);
            mContactList.add(contact);

        }
        ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(
                this,
                android.R.layout.simple_list_item_1       //context,layout,จะไปใส่ตรงไหน,ทีแหล่งข้อมูล
                ,mContactList);
        mContactListView.setAdapter(adapter);
    }
}
