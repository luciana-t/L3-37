package com.luciana.l3_37;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView L337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L337 = (ImageView) findViewById(R.id.iml337);
    }

    private int fieldImgXY[] = new int[2];

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        L337.getLocationOnScreen(fieldImgXY);
        Log.i("ZERO", "fieldImage lockation on screen: " + xyString(fieldImgXY[0], fieldImgXY[1]));
//        String text = "L3-37 location on screen: " + xyString(fieldImgXY[0], fieldImgXY[1]);
//        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public String xyString(int x, int y){
        return "X:" + String.valueOf(x) + " Y:" + String.valueOf(y);
    }

    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.i("PRIMEIRO", "touch event - down");
//            Toast.makeText(this,"touch event = down", Toast.LENGTH_LONG).show();

            int eventX = (int) event.getX();
            int eventY = (int) event.getY();
            Log.i("SEGUNDO", "event (x, y) = " + xyString(eventX, eventY));
//            Toast.makeText(this,"event (x,y) = " + xyString(eventX, eventY), Toast.LENGTH_LONG).show();

            int xOnField = eventX - fieldImgXY[0];
            int yOnField = eventY - fieldImgXY[1];
            Log.i("TERCEIRO", "on field (x, y) = " + xyString(xOnField, yOnField));
//            Toast.makeText(this, "on field (x, y) = " +xyString(xOnField, yOnField), Toast.LENGTH_LONG).show();

            Log.i("TAMANHO", "X: " + L337.getWidth() + " Y: " + L337.getHeight());

            if (xOnField < 0 || yOnField < 0 || xOnField > L337.getWidth() || yOnField > L337.getHeight()){
                Log.i("FORA", "o click foi feito fora da imagem");
            }
            else{
                Log.i("DENTRO", "o click foi feito dentro da imagem");
            }
            if (xOnField >= 190 && xOnField <= 304 && yOnField >= 18 && yOnField <= 90){
                Toast.makeText(this, "Você clicou na cabeça" , Toast.LENGTH_LONG).show();
            }
//x 190 a 304
//y 18 a 80
        }


        return super.onTouchEvent(event);
    }


}
