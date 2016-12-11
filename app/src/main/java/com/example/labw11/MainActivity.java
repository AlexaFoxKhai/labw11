package com.example.labw11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    Paint p;
    Bitmap KarTinka;
    int width=0, height=0;
    float x, y;
    int touches = 0;
    Field field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        field = new Field(this);
        field.setOnTouchListener(this);
        setContentView(field);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            field.invalidate();
        }
        return true;
    }

    class Field extends View {

        public Field(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            width = w;
            height = h;
            super.onSizeChanged(w, h, oldw, oldh);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            KarTinka = BitmapFactory.decodeResource(getResources(), R.mipmap.ui);
            float bmpx = KarTinka.getWidth();
            float bmpy = KarTinka.getHeight();

            Rect R1=new Rect(698,2,930,346);
            Rect R2=new Rect(80,80,400,600);
            Rect R3=new Rect(2,450,150,600);
            Rect R4=new Rect(30,200,200,350);
            Rect R5=new Rect(1020,350,1100,450);
            Rect R6=new Rect(230,220,350,350);
            canvas.drawBitmap(KarTinka, R1, R2, p);
            canvas.drawBitmap(KarTinka, R3, R4, p);
            canvas.drawBitmap(KarTinka, R5, R6, p);
        }
    }

}
