package com.mcas2.interfacedesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainContext = (TextView) findViewById(R.id.textTap);
        registerForContextMenu(mainContext);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.copy_context:
                Toast toast = Toast.makeText(this, "Copiado", Toast.LENGTH_LONG);
                toast.show();
                return true;
            case R.id.download_context:

                ConstraintLayout mLayaut = findViewById(R.id.activity_main_constraint);

                Snackbar snackbar = Snackbar
                        .make(mLayaut, "Ten cuidado que estás descargando", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar snackbar_undo = Snackbar.make(mLayaut,
                                        "Deshecho", Snackbar.LENGTH_LONG);
                                snackbar_undo.show();
                            }
                        });

                snackbar.show();

                //Toast toast2 = Toast.makeText(this, "Descargando...", Toast.LENGTH_LONG);
                //toast2.show();
                //return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}