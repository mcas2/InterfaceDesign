package com.mcas2.interfacedesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    private WebView myWebVisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView mainContext = (TextView) findViewById(R.id.textTap);
        //registerForContextMenu(myWebVisor);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeExample);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        myWebVisor = (WebView) findViewById(R.id.myWebVisor);

        myWebVisor.getSettings().setBuiltInZoomControls(true);
        myWebVisor.loadUrl("https://thispersondoesnotexist.com");

    }

    protected SwipeRefreshLayout.OnRefreshListener
        mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Look at this not existent person", Toast.LENGTH_LONG);
            toast0.show();

            swipeLayout.setRefreshing(false);
            myWebVisor.reload();
        }
    };

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