package com.example.bigle.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Age;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.editText1);            //reference name ;edittext1
        Age = findViewById(R.id.editText2);             //reference age ;edittext2
        button1 =(Button)findViewById(R.id.button);     //reference button1

        button1.setOnClickListener(new  View.OnClickListener(){     //add click listener
            @Override
            public void onClick(View view){
                String username = Name.getText().toString();        //name is stored, In String username
                String userage = Age.getText().toString();          //age is stored, In String userage
                Intent intent = new Intent(getApplicationContext(),NewActivity.class);  //contain imformation and send object
                intent.putExtra("name",username);            //name push value to NewActivity
                intent.putExtra("age",userage);              //age push value to NewActivity
                startActivity(intent);
                Name.setText("");                                   //empty ; name
                Age.setText("");                                    //empty ; name

            }
        });
    }

}
