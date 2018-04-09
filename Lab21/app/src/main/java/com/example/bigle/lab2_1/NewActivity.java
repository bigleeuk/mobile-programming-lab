package com.example.bigle.lab2_1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
import java.nio.charset.Charset;

public class NewActivity extends AppCompatActivity {
    String text = "";                                   //set String text empty
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
         Intent passedIntent =  getIntent();

        Context context = getApplicationContext();
        if (passedIntent !=null){                   //If intent is not empty, get String to Intent
            String loginName = passedIntent.getStringExtra("name");
            String loginAge = passedIntent.getStringExtra("age");
            text = loginName+loginAge;
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();     //msg show
        }
        Button button0 = findViewById(R.id.button);
        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                finish();       //Back
            }
        });
    }
}
