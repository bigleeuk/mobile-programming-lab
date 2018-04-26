package com.example.bigle.lab32;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NewActivity extends AppCompatActivity {

    TextView name;
    TextView gender;
    TextView check;
    Button backButton;
    @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_new);
         name=(TextView)findViewById(R.id.nameText); // get textview id from XML
         gender=(TextView)findViewById(R.id.genderText); // get textview id from XML
         check=(TextView)findViewById(R.id.checkText); // get textview id from XML
         backButton=(Button)findViewById(R.id.btnBack); // get button id from XML
         Intent intent=getIntent();
         Bundle bundle=intent.getExtras();
         name.setText(bundle.getString("name")); // input name text received from MainActivity to textview
         gender.setText(bundle.getString("gender")); // input gender text receive from MainActivity to textview
         check.setText(bundle.getString("check")); // input check text receive from MainActivity to textview
         backButton.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View view){
            finish(); // exit this activity
          }
     });
     }
 }
