package com.example.bigle.lab61;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

public class MainActivity extends AppCompatActivity {
    private String mypath;
    private EditText txtdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mypath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File directory = new File(mypath + "\n");
        directory.mkdir();
        Button button1 = findViewById(R.id.buttonWritefile);
        Button button2 = findViewById(R.id.buttonClearfile);
        Button button3 = findViewById(R.id.buttonReadfile);
        Button button4 = findViewById(R.id.buttonFinish);
        txtdata = findViewById(R.id.txtData);
        txtdata.setHint("Enter some lines of data here..");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    File myFile =  new File(directory,"mysdfile.txt");
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(
                            new FileOutputStream(myFile));
                    myOutWriter.append(txtdata.getText());
                    myOutWriter.close();
                    Toast.makeText(getApplicationContext(),"Done write SD  : mysdfile.txt",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                BufferedReader myReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(directory,"mysdfile.txt")
                                )
                        )
                );
                String DataRow;
                String Buffer ="";
                while  ((DataRow =myReader.readLine()) != null){
                    Buffer+=DataRow +"\n";
                }
                txtdata.setText(Buffer);
                myReader.close();
                Toast.makeText(getApplicationContext(),"Done read Sd mysdfile.txt",Toast.LENGTH_SHORT).show();

            }catch(Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdata.setText("");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
