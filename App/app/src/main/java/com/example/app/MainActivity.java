package com.example.app;

import android.content.Context;
import android.os.Bundle;

import com.example.app.api.Champion;
import com.example.app.api.DataDragon;
import com.example.app.database.Repository;
import com.example.app.database.entity.ChampionEntity;
import com.example.app.ui.main.MainViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Collection;
import java.util.List;

import io.reactivex.Single;

import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private ChampionPagerAdapter mAdapter;
    private TabLayout mtabLayout;
    private SwitchCompat mSwitch;
    private Collection<Champion> mChampions;
    private static List<ChampionEntity> mFavoris;
    private Context context;
    private static Repository mRepository;
    private static MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext() ;

        // On récupère les champions depuis l'API
        Single<DataDragon> mDataDragon = RiotCalls.getInstance().getMyApi().getChampions()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .timeout(10, java.util.concurrent.TimeUnit.SECONDS);
        mChampions = mDataDragon.blockingGet().getData().values();

        // On récupère les champions favoris depuis la base de données
        mRepository = new Repository(this.getApplication());
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.getChampions().observe(this, new Observer<List<ChampionEntity>>() {
            @Override
            public void onChanged(List<ChampionEntity> championEntities) {
                mFavoris = championEntities;
                mAdapter.setFavoris(championEntities);
            }
        });

        // On transmet les informations au PageViewer2 pour afficher les champions
        mViewPager = findViewById(R.id.viewPager2);
        mAdapter = new ChampionPagerAdapter(this, false, mChampions, mFavoris, context);
        mViewPager.setAdapter(mAdapter);

        // On associe les onglets au ViewPager2
        mtabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(mtabLayout, mViewPager,
                (tab, position) -> tab.setText(mAdapter.getPageTitle(position))
        ).attach();

        // On récupère le bouton switch pour modifier l'affichage des champions (Grille ou Liste)
        mSwitch = findViewById(R.id.switch1);
        mSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mAdapter.setGrid(true);
            } else {
                mAdapter.setGrid(false);
            }
            mViewPager.setAdapter(mAdapter);
        });
    }

    private static class ChampionPagerAdapter extends FragmentStateAdapter {

        private Collection<Champion> champions;
        private List<ChampionEntity> favoris;
        private boolean isGrid;
        private Context context;

        public ChampionPagerAdapter(AppCompatActivity activity, boolean isGrid, Collection<Champion> champions, List<ChampionEntity> favoris, Context context) {
            super(activity);
            this.isGrid = isGrid;
            this.champions = champions;
            this.favoris = favoris;
            this.context = context;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    //Toast.makeText(context, "Champions", Toast.LENGTH_SHORT).show();
                    return ChampionsListFragment.newInstance(champions, isGrid, context);
                case 1:
                    //Toast.makeText(context, "Favoris", Toast.LENGTH_SHORT).show();
                    return FavorisListFragment.newInstance(favoris, isGrid, context);
                default:
                    throw new IllegalArgumentException("Invalid position: " + position);
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Champions";
                case 1:
                    return "Favoris";
                default:
                    throw new IllegalArgumentException("Invalid position: " + position);
            }
        }

        public void setGrid(boolean isGrid) {
            this.isGrid = isGrid;
        }

        public void setFavoris(List<ChampionEntity> favoris) {
            this.favoris = favoris;
        }
    }

    public static Repository getRepository() {
        return mRepository;
    }

    public static List<ChampionEntity> getFavoris() {
        return mFavoris;
    }

    public static MainViewModel getViewModel() {
        return mViewModel;
    }

}