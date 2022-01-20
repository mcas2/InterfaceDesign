package com.mcas2.interfacedesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    private WebView myWebVisor;
    private Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView mainContext = (TextView) findViewById(R.id.textTap);


        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeExample);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        myWebVisor = (WebView) findViewById(R.id.myWebVisor);
        registerForContextMenu(myWebVisor);

        myWebVisor.getSettings().setBuiltInZoomControls(true);
        myWebVisor.loadUrl("https://thisartworkdoesnotexist.com/");
    }

    protected SwipeRefreshLayout.OnRefreshListener
        mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Soy una obra de arte autogenerada.", Toast.LENGTH_LONG);
            toast0.show();

            swipeLayout.setRefreshing(false);
            myWebVisor.reload();
        }
    };

    public void showAlertDialogButtonClicked(MainActivity mainActivity) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("Alerta");
        builder.setMessage("¿Adónde quieres ir?");
        builder.setIcon(R.drawable.ic_sadface);
        builder.setCancelable(false);

        builder.setPositiveButton("Log in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("No hacer nada", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.setNeutralButton("¿Quién sabe?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//Gestiona las acciones sobre los botones
        int id = item.getItemId();
        if (id == R.id.search_appbar) {
            Toast toast = Toast.makeText(this, "Busca en otro momento", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.fav_appbar) {
            Toast toast = Toast.makeText(this, "¡Me gusta esta obra!", Toast.LENGTH_LONG);
            toast.show();
        }

        if (id == R.id.open_bab) {
            Intent intent = new Intent(MainActivity.this, MainBAB.class);
            startActivity(intent);
        }

        if (id == R.id.open_bn) {
            Intent intent = new Intent(MainActivity.this, MainBN.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    } //Este menú es contextual para pulsar y que aparezca.

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
                        .make(mLayaut, "Atención: descarga en curso.", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar snackbar_undo = Snackbar.make(mLayaut,
                                        "Descarga cancelada.", Snackbar.LENGTH_LONG);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //Este menú aparece arriba.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }
}