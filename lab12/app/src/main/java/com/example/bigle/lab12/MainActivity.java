package com.example.bigle.lab12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText edit_name;      //Create EditText Object

    public Button btn_print;        //Create Button object
    public Button btn_clear;        //Create Button object
    public TextView view_print;     //Create Textview object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();                     //Calling the init method
    }

    public void init() {             //Create init method
        view_print = (TextView) findViewById(R.id.textview);     //Import textview id
        edit_name = (EditText) findViewById(R.id.edittext);       //Import edittext id
        btn_clear = (Button) findViewById(R.id.btn_clear);        //Import btn_clear id
        btn_print = (Button) findViewById(R.id.btn_print);        //Import btn_print id
        btn_print.setOnClickListener(new Button.OnClickListener() {  //onClick Event ; print
            @Override
            public void onClick(View v) {                        //when icon click, operation method
                String text = "";
                text = edit_name.getText().toString();
                view_print.setText(text);
            }
        });
        btn_clear.setOnClickListener(new Button.OnClickListener() {  ////onClick Event ; clear
            @Override
            public void onClick(View v) {                        //when icon click, operation method
                edit_name.setText("");
                view_print.setText("");
            }
        });

    }
}