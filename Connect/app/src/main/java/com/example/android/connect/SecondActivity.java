package com.example.android.connect;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    LinearLayout layout;float toballx,tobally;
    int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=(LinearLayout)findViewById(R.id.layout);
        final Ball ballview = new Ball(this);
        layout.addView(ballview);
View.OnTouchListener onTouchListener=new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                 for(int i=0;i<42;i++)
                 {if (checkinside(event.getX(), event.getY(),Ball.par[i].getxposition(),Ball.par[i].getyposition(),ballview.getradius())) {
                    Toast.makeText(getApplicationContext(), "Works fine", Toast.LENGTH_SHORT).show();

                }}
                return true;
        }
        return false; }
    };
        ballview.setOnTouchListener(onTouchListener);

    }

    private boolean checkinside(float x, float y, float CenterX, float CenterY, float Radius) {
        double dx = (x - CenterX)*(x-CenterX);
        double dy = (y - CenterY)*(y-CenterY);

        if ((dx + dy) < Radius*Radius) {
            toballx = CenterX;
            tobally=CenterY;
            return true;
                 }
     else {
            return false;
        }
    }
}

