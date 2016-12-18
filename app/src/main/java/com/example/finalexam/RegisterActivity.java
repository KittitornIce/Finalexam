package com.example.finalexam;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexam.DB.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    private EditText mNameEditText,mUsernameEditText,mPasswordText;
    private Button mCreateButton;
    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();

        mNameEditText = (EditText)findViewById(R.id.name_text);
        mUsernameEditText = (EditText)findViewById(R.id.username_text);
        mPasswordText = (EditText) findViewById(R.id.password_text);
        mCreateButton = (Button)findViewById(R.id.create_button);

        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameEditText.getText().toString();
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordText.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put(DatabaseHelper.COL_NAME, name);
                cv.put(DatabaseHelper.COL_USERNAME, username);
                cv.put(DatabaseHelper.COL_PASSWORD, password);

                mDb.insert(DatabaseHelper.TABLE_NAME, null, cv);
                finish();
                Toast.makeText(RegisterActivity.this, "Create account successfully.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
