package com.mcas2.interfacedesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.mcas2.interfacedesign.R;
import com.mcas2.interfacedesign.databinding.ActivityMainBnBinding;
import com.mcas2.interfacedesign.ui.main.SectionsPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainBN extends AppCompatActivity {

    private ActivityMainBnBinding binding;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //el adaptador coloca las Pages -los fragmentos con las diferentes vistas- dentro de la vista padre Viewpager del xml
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);

        BottomNavigationView mybottomNavView = findViewById(R.id.bottom_navigation);

        mybottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.heart:
                        item.setChecked(true);
                        Toast.makeText(com.mcas2.interfacedesign.MainBN.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(mybottomNavView,item.getItemId());
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.search:
                        item.setChecked(true);
                        Toast.makeText(com.mcas2.interfacedesign.MainBN.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(mybottomNavView,item.getItemId());
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.sad:
                        item.setChecked(true);
                        Toast.makeText(com.mcas2.interfacedesign.MainBN.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(mybottomNavView,item.getItemId());
                        viewPager.setCurrentItem(2);

                        break;
                    case R.id.booticon:
                        item.setChecked(true);
                        Toast.makeText(com.mcas2.interfacedesign.MainBN.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(mybottomNavView,item.getItemId());
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });


//        here we listen to viewpager moves and set navigations items checked or not

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);

                else
                    mybottomNavView.getMenu().getItem(0).setChecked(false);

                mybottomNavView.getMenu().getItem(position).setChecked(true);
                removeBadge(mybottomNavView,mybottomNavView.getMenu().getItem(position).getItemId());
                prevMenuItem = mybottomNavView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //removing badges
    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }

}