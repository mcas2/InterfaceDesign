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
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openApp(true);

        //ANIMACIÓN
        ImageView boot = findViewById(R.id.splash_boot);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.gradient_colour);
        boot.startAnimation(myanim);



        //FONDO
        ImageView fondo = findViewById(R.id.backgroundSplash);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1580436541340-36b8d0c60bae?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=388&q=80")
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .into(fondo);

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
         }, 3000);
    }
}
