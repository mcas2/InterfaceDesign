package com.mcas2.interfacedesign;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView landscapeLogin = findViewById(R.id.trees1);

        Glide.with(this)
                .load(R.drawable.trees1)
                //.load("https://sunbikes.es/wp-content/uploads/2018/02/Pico-del-Calamorro-vistas.jpg")
                //IMPORTANTE para cargar imágenes de internet
                //.transition(DrawableTransitionOptions.withCrossFade(400))
                .centerCrop()
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.yellow_forest)))
                //Para cuando no carga la imagen
                .into(landscapeLogin);
    }

    public void openMain (View v) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openSignUp (View v) {
        Intent intent = new Intent(LoginActivity.this, SignUp.class);
        startActivity(intent);
    }
}