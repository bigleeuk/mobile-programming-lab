package com.example.bigle.lab62;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private Button loadbutton ;
    private Button savebutton;
    private Button clearbutton;
    private EditText schoolNumber;
    private EditText schoolname;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor SP_editor;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        schoolNumber = findViewById(R.id.SchoolNumber);
        schoolname = findViewById(R.id.name);

        loadbutton = findViewById(R.id.buttonLoad);
        loadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("LAB6_2", MODE_PRIVATE);
                if (sharedPreferences != null) {
                    String sn = sharedPreferences.getString("sn", null);
                    String name = sharedPreferences.getString("name", null);
                    schoolNumber.setText(sn);
                    schoolname.setText(name);
                }
            }
        });

        savebutton = findViewById(R.id.buttonSave);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputSN = schoolNumber.getText().toString();
                String inputName = schoolname.getText().toString();
                sharedPreferences = getSharedPreferences("LAB6_2", MODE_PRIVATE);
                SP_editor = sharedPreferences.edit();
                SP_editor.putString("sn", inputSN);
                SP_editor.putString("name", inputName);
                SP_editor.commit();
            }
        });

        clearbutton = findViewById(R.id.buttonClear);
        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                schoolNumber.setText("");
                schoolname.setText("");
            }
        });
    }
}
