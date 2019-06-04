package com.example.android.connect;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;


public class Ball extends View {
    public static ballparams par[]=new ballparams[42];
    Paint mpaint,lightpaint;
    int mpadding;
    int m=0;
     static float x;static float y;
      float r,d;
    private int ballColor = Color.BLUE;
    public int getBallColor() {
        return ballColor;
    }
    public void setBallColor(int ballColor) {
        this.ballColor = ballColor;
    }


 /*  public float checkrow(float s)
   { for(int k=0;k<7;k++)
   {

   }

   }*/
    public float getradius()
    {return r;}

    // Ball constructor.
    public Ball(Context context) {
        super(context);
        mpaint=new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setStyle(Paint.Style.FILL);
        mpaint.setColor(Color.parseColor("#d81b60"));
        mpadding=100;
        lightpaint=new Paint();
        lightpaint.setColor(Color.parseColor("#880e4f"));
        lightpaint.setStyle(Paint.Style.FILL);
        lightpaint.setAntiAlias(true);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        r=pxFromDp(context,20);
        d=pxFromDp(context,5);
        r = pxFromDp(context, 20);
       /* p1=new Point((int)pxFromDp(context,16),(int)pxFromDp(context,100));
         Point p2=new Point ((int)pxFromDp(context,270),(int)pxFromDp(context,100));
        Point p4=new Point ((int)pxFromDp(context,16),(int)pxFromDp(context,300));
        Point p3=new Point ((int)pxFromDp(context,270),(int)pxFromDp(context,300));
      */
        }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
          canvas.drawRect(
                getLeft() + (getRight() - getLeft()) / 12,
                getTop() ,
                getRight() - (getRight() - getLeft()) / 12,
                getBottom() - (getBottom() - getTop()) / 3, mpaint);

        x=getLeft() + (getRight() - getLeft()) / 12+(2*r);

        y= getTop()+r+d;
        for( int j=0;j<=6;j++)
      {for(int k=0;k<=5;k++)
      { canvas.drawCircle(x,y,r,lightpaint);
       par[m].xposition=x;
       par[m].yposition=y;
       par[m].columnno=k;m++;
          x=x+(2*r)+d;
      }
        x=getLeft() + (getRight() - getLeft()) / 12+(2*r);y=y+(2*r)+d;
      }



    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }


}