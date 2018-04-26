package com.example.bigle.lab32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    RadioGroup radioGender;
    RadioButton Male;
    RadioButton Female;
    CheckBox chkSMS;
    CheckBox chkEmail;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.nameEditText); // get textview id from XML
        radioGender=(RadioGroup)findViewById(R.id.radioGroup); // get radioGroup id from XML
        Male=(RadioButton)findViewById(R.id.man);  // get radioButton id from XML
        Female=(RadioButton)findViewById(R.id.woman);  // get radioButton id from XML
        chkSMS=(CheckBox)findViewById(R.id.SMS);  // get checkBox id from XML
        chkEmail=(CheckBox)findViewById(R.id.email);  // get checkBox id from XML
        button1=(Button)findViewById(R.id.btnRegister); //  // get Button id from XML
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name =editText.getText().toString();
                String gender ="";
                String check ="";
                int radioId = radioGender.getCheckedRadioButtonId();
                if(chkSMS.isChecked()) {
                    check = chkSMS.getText().toString();
                    chkSMS.setChecked(false);
                }
                if(chkEmail.isChecked()) {
                    check = chkEmail.getText().toString();
                    chkEmail.setChecked(false);
                }
                if(Male.getId()==radioId) {
                    gender = Male.getText().toString();
                    Male.setChecked(false);
                }
                if(Female.getId()==radioId) {
                    gender = Female.getText().toString();
                    Female.setChecked(false);
                }
                Intent intent=new Intent(MainActivity.this,NewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("gender",gender);
                bundle.putString("check",check);
                editText.setText("");
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });
    }
}