package com.example.bigle.lab42;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    //variable Animation,button and etc...
    LinearLayout page,page2;
    Animation tLeft;
    Animation tRight;
    Button button;
    Button button1;
    boolean isPageOpen = false;
    @Override
    //onCreate method ; Create Construct page,Slide
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page2 = (LinearLayout)findViewById(R.id.page2);
        page = (LinearLayout)findViewById(R.id.page);
        SlidingAnimationListener listener =new SlidingAnimationListener();
        SlidingAnimationListener listener1 =new SlidingAnimationListener();
        tLeft = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        tRight = AnimationUtils.loadAnimation(this,R.anim.translate_right);
        tLeft.setAnimationListener(listener);
        tRight.setAnimationListener(listener1);
        button =(Button)findViewById(R.id.button1);
        //Button click Event
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //When button is clicked , page slide action execute
                if(isPageOpen){
                    page.startAnimation(tRight);

                }
                else{
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(tLeft);
                }
            }
        });

    }
    //SlidingAnimationListener
    class SlidingAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {


        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //When Event is occur, Set View Visible Or Invisible, and Change Button text
            if(isPageOpen){
                page.setVisibility(View.INVISIBLE);
                button.setText("open page");
                isPageOpen = false;
            }else{
                button.setText("close page");
                isPageOpen = true;
            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
