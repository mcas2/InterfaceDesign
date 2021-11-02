package com.mcas2.interfacedesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openApp(true);

        ImageView boot = findViewById(R.id.splash_boot);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        boot.startAnimation(myanim);
    }

    //Esto sirve para realizar la transición después de 2000 milisegundos

    public void openApp (boolean locationPermission){
         new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent intent = new Intent(Splash_Screen.this, LoginActivity.class);
                 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                 startActivity(intent);
             }
         }, 2000);
    }
}