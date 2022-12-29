package com.example.app;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.app.ui.main.SectionsPagerAdapter;
import com.example.app.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return  ItemFragment.newInstance( 2 );
            }

            @Override
            public int getItemCount() {
                return 10;
            }
        });



        SwitchCompat switchCompat = findViewById(R.id.switch1);
        switchCompat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            viewPager2.setAdapter(new FragmentStateAdapter(this) {
                @NonNull
                @Override
                public Fragment createFragment(int position) {
                    return  ItemFragment.newInstance( isChecked ? 1 : 2 );
                }

                @Override
                public int getItemCount() {
                    return 10;
                }
            });
        });


    }
}