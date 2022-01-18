package com.mcas2.interfacedesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageView landscapeLogin = findViewById(R.id.trees2);

        Glide.with(this)
                .load(R.drawable.trees2)
                //.load("https://sunbikes.es/wp-content/uploads/2018/02/Pico-del-Calamorro-vistas.jpg")
                //IMPORTANTE para cargar imágenes de internet
                //.transition(DrawableTransitionOptions.withCrossFade(400))
                .centerCrop()
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.yellow_forest)))
                //Para cuando no carga la imagen
                .into(landscapeLogin);
    }

    public void openAppBar(View view) {
        Intent intent = new Intent(SignUp.this, MainBAP.class);
        startActivity(intent);
    }
}