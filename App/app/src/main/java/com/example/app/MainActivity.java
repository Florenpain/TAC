package com.example.app;

import android.os.Bundle;

import com.example.app.api.Champion;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private TabLayout mTabLayout;
    private FragmentStateAdapter mAdapter;
    private SwitchCompat mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewPager2);
        mTabLayout = findViewById(R.id.tabLayout);
        mSwitch = findViewById(R.id.switch1);

        mAdapter = new ChampionPagerAdapter(this, false);

        mViewPager.setAdapter(mAdapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Champions");
                    break;

                case 1:
                    tab.setText("Favoris");
                    break;

                default:
                    tab.setText("Champions");
                    break;

            }
        });
        tabLayoutMediator.attach();

        mSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mAdapter = new ChampionPagerAdapter(this, true);
            } else {
                mAdapter = new ChampionPagerAdapter(this, false);
            }
            mViewPager.setAdapter(mAdapter);
        });

    }

    private static class ChampionPagerAdapter extends FragmentStateAdapter {

        private List<Champion> champions = new ArrayList<>();
        private List<Champion> favoris = new ArrayList<>();
        private boolean isGrid;

        public ChampionPagerAdapter(AppCompatActivity activity, boolean isGrid) {

            super(activity);
            this.isGrid = isGrid;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return ChampionsListFragment.newInstance(champions, isGrid);
                case 1:
                    return ChampionsListFragment.newInstance(favoris, isGrid);
                default:
                    throw new IllegalArgumentException("Invalid position: " + position);
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}