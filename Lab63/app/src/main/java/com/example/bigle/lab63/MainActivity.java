package com.example.bigle.lab63;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    DBHelper helper;

    String[] info;
    private Button buttonAdd;
    private Button ButtonDelete;
    private EditText name = null;
    private EditText number = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(MainActivity.this, "student.db", null, 1);
        name = findViewById(R.id.schoolName);
        number = findViewById(R.id.schoolNumber);
        listView = findViewById(R.id.listView);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        ButtonDelete= findViewById(R.id.buttonDelete);
        ButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    public void add() {
        String termN = name.getText().toString();
        String termSN = number.getText().toString();

        if(termN.isEmpty()||termSN.isEmpty()) {
            Toast.makeText(getApplicationContext(),"모든 항목을 입력해주세요.",Toast.LENGTH_SHORT).show();
        }
        else{
            database = helper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put("name",termN);
            contentValues.put("sn",termSN);
            database.insert("student",null,contentValues);

            database =helper.getReadableDatabase();
            Cursor cursor =database.query("student",null,null,null,null,null,null);
            info = new String[cursor.getCount()];
            int count=0;

            while(cursor.moveToNext()){
                info[count++] = cursor.getString(cursor.getColumnIndex("name"))+" "+ cursor.getString(cursor.getColumnIndex("sn"));
            }
            name.setText("");
            number.setText("");
            cursor.close();

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,info);
            listView.setAdapter(adapter);
        }
    }

    public void delete() {
        String termN = name.getText().toString();

        if (termN.isEmpty())
            Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_LONG).show();
        else {
            database = helper.getWritableDatabase();
            database.delete("student", "name=?", new String[]{termN});

            database = helper.getReadableDatabase();
            Cursor cursor = database.query("student", null, null, null, null, null, null);
            info = new String[cursor.getCount()];

            int count = 0;
            while (cursor.moveToNext()) {
                info[count++] = cursor.getString(cursor.getColumnIndex("name")) + "  " + cursor.getString(cursor.getColumnIndex("sn"));
            }

            name.setText("");
            number.setText("");
            cursor.close();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, info);
            listView.setAdapter(adapter);
        }
    }
}
