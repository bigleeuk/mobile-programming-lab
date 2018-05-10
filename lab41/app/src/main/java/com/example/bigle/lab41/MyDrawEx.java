package com.example.bigle.lab41;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyDrawEx extends View {
    float Xcoor;        //x coordination
    float Ycoor;        //y coordination
    int color= Color.BLUE;
    ArrayList<Point> points = new ArrayList<Point>();       //store x, y coordination.
    public MyDrawEx(Context c){
        super(c);
    }
    public MyDrawEx(Context c, AttributeSet a){
        super(c,a);
    }
    // class point : store information x,y coordination, check, color
    class Point{
        float x;
        float y;
        boolean check;
        int color;
        public Point(float x,float y,boolean check, int color){
            this.x=x;
            this.y=y;
            this.check=check;
            this.color=color;
        }
    }
    // Draw function with Paint
    @Override
    protected  void onDraw(Canvas canvas){
        Paint p  = new Paint(Paint.ANTI_ALIAS_FLAG);
      //  Path path  = new Path();
        p.setStrokeWidth(15);
        //Draw line with canvas.drawline , using x,y coordination
        for(int i=1 ; i<points.size() ; i++)
        {
            p.setColor(points.get(i).color);
            if(!points.get(i).check)
                continue;
            //Line draw to point x and y
            canvas.drawLine(points.get(i-1).x,points.get(i-1).y,points.get(i).x,points.get(i).y,p);
        }

    }
    public boolean onTouchEvent(MotionEvent event){
            //receive point x and y
            Xcoor=event.getX();
            Ycoor=event.getY();
            //when event occur, According to MotionEvent
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                points.add(new Point(Xcoor,Ycoor,false , color));
            case MotionEvent.ACTION_MOVE :
                points.add(new Point(Xcoor,Ycoor,true , color));
                break;
            case MotionEvent.ACTION_UP :
                break;
        }
        //Draw is continue, Consider before draw
        invalidate();
        return true;
    }

}
