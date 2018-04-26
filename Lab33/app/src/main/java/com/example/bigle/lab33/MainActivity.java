package com.example.bigle.lab33;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Fragment1 fragment1;
    Fragment2 fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();
    }
    public void init() {
        btn1 = findViewById(R.id.tab1); // get button id from XML
        btn2 = findViewById(R.id.tab2); // get button id from XML
        fragment1 = new Fragment1(); // create new fragment
        fragment2 = new Fragment2(); // create new fragment
    }
    public void setListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit(); // visible fragment1
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit(); // visible fragment2
            }
        });
    }
}
