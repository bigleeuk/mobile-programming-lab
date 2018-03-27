package com.example.bigle.lab11;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;                                         //Create image object
    ImageView imageView2;                                        //Create image object2

    int imageIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.red);           //Import imagewidget id
        imageView2 = (ImageView) findViewById(R.id.blue);

    }
    public void onButton1Clicked(View v) {
        changeImage();
    }       //Create onButton1Clicked method

    private void changeImage() {                                  //Create changeImage method
        if (imageIndex == 0) {
            imageView.setVisibility(View.VISIBLE);                //Show selected image file
            imageView2.setVisibility(View.INVISIBLE);             //show selected image file

            imageIndex = 1;
        } else if (imageIndex == 1) {
            imageView2.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.INVISIBLE);

            imageIndex = 0;
        }
    }
}
