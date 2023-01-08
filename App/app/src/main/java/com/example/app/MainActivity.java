package com.example.app;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.app.api.Champion;
import com.example.app.api.DataDragon;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private FragmentStateAdapter mAdapter;
    private SwitchCompat mSwitch;
    private Collection<Champion> mChampions;
    private Collection<Champion> mFavoris;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();
        Single<DataDragon> mDataDragon = RiotCalls.getInstance().getMyApi().getChampions()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .timeout(10, java.util.concurrent.TimeUnit.SECONDS);
        mChampions = mDataDragon.blockingGet().getData().values();

        mFavoris = new ArrayList<>();

        mViewPager = findViewById(R.id.viewPager2);
        mAdapter = new ChampionPagerAdapter(this, false, mChampions, mFavoris);
        mViewPager.setAdapter(mAdapter);

        mSwitch = findViewById(R.id.switch1);
        mSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mAdapter = new ChampionPagerAdapter(this, true, mChampions, mFavoris);
            } else {
                mAdapter = new ChampionPagerAdapter(this, false, mChampions, mFavoris);
            }
            mViewPager.setAdapter(mAdapter);
        });


        // Afficher les 10 premiers champions dans la console
        /*
        Iterator it = mChampions.iterator();
        for (int i = 0; i < 10; i++) {
            Champion champion = (Champion) it.next();
            System.out.println(champion.getName() + champion.getTitle() + champion.getBlurb() + champion.getTags());
        }
        */
    }

    private static class ChampionPagerAdapter extends FragmentStateAdapter {

        private Collection<Champion> champions;
        private Collection<Champion> favoris;
        private boolean isGrid;

        public ChampionPagerAdapter(AppCompatActivity activity, boolean isGrid, Collection<Champion> champions, Collection<Champion> favoris) {
            super(activity);
            this.isGrid = isGrid;
            this.champions = champions;
            this.favoris = favoris;
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