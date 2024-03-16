package com.example.online_pharmcy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    ImageView  img_title, image;
    ExplosionField  explosionField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        findViews();
        handler();
    }
//     this method is used to find and associate views in the application page.
    private void findViews(){
        img_title = findViewById(R.id.img_title);
        image = findViewById(R.id.image);
    }
//    In short, this piece of code is used to create an explosion and perform a page change operation in an Android application.
    private void handler(){
        explosionField = ExplosionField.attach2Window(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                explosionField.explode(img_title);
                explosionField.explode(image);
            }
        },2500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, 4000);
    }
}