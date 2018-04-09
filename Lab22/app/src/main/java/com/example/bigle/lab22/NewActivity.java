package com.example.bigle.lab22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button gobtn;
    Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = findViewById(R.id.textview1);
        gobtn = findViewById(R.id.button1);
        backBtn = findViewById(R.id.button2);

        final Intent passedIntent = getIntent();
        final String passedUrl = passedIntent.getStringExtra("url");
        textView.setText(passedUrl);
        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!passedUrl.isEmpty()){       //if url is not empty, Activity start
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+passedUrl+"/")); //Go internet http;
                    startActivity(intent);
                }else{

                    Toast.makeText(getApplicationContext(),"주소를 다시 입력해주세요.",Toast.LENGTH_SHORT).show();     //msg

                }
            }
        });
       backBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {         //Back and print
               Toast.makeText(getApplicationContext(),"뒤로가기 버튼을 눌렀습니다..",Toast.LENGTH_SHORT).show();
               finish();
           }
       });
    }
}
