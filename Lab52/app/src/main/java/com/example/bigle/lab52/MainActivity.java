package com.example.bigle.lab52;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText inputText;
    TextView numText;
    TextView resultText;
    int num,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn =  findViewById(R.id.button);
        inputText =  findViewById(R.id.edittext);
        numText =  findViewById(R.id.textView1);
        resultText =  findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new CountDownTask().execute(); //create AsyncTask
            }
        });
    }
//   initialize TextViews and store the input data
    private class CountDownTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            result=1;
            numText.setText("");
            resultText.setText("");
            num=Integer.parseInt(inputText.getText().toString());
        }


//  perform factorial calculation
        @Override
        protected Void doInBackground(Void... params) {
            for (int i = num; i >= 1; i--) {
                try {
                    result*=i;
                    Thread.sleep(500);
                    publishProgress(i);
                } catch (Exception e) {
                }
            }
            return null;
        }
//   appending Function : the number to TextView
        @Override
        protected void onProgressUpdate(Integer... values) {
            numText.append(Integer.toString(values[0].intValue())+" ");
        }

//  When finishing, print result
        @Override
        protected void onPostExecute(Void aVoid) {
            resultText.setText("= "+result);
        }
    }
}