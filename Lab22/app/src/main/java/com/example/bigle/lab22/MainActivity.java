package com.example.bigle.lab22;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url= (EditText)findViewById(R.id.edittext1);                //Reference
        nextBtn = (Button)findViewById(R.id.button1);
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                String myUrl = Url.getText().toString();       //Store String
                Intent intent = new Intent(getApplicationContext(),NewActivity.class);  //intent set make object
                intent.putExtra("url",myUrl);           //send url variable
                startActivity(intent);
                Url.setText("");                               //empty text
            }
        });
    }
}
