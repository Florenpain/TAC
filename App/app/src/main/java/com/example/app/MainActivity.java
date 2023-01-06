package com.example.app;

import android.os.Bundle;

import com.example.Champion;
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

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.app.ui.main.SectionsPagerAdapter;
import com.example.app.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
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

        RiotService riotCalls = RiotCalls.getClient().create(RiotService.class);
        Call<List<Champion>> call = riotCalls.getChampions();

        call.enqueue(new Callback<List<Champion>>() {
            @Override
            public void onResponse(Call<List<Champion>> call, Response<List<Champion>> response) {
                if (response.isSuccessful()) {
                    Log.d("FB","on response");
                    displayListOfChampions(response.body());
                    viewPager2.setAdapter(new FragmentStateAdapter(MainActivity.this) {
                        @NonNull
                        @Override
                        public Fragment createFragment(int position) {
                            return  ItemFragment.newInstance( switchCompat.isChecked() ? 1 : 2 );
                        }

                        @Override
                        public int getItemCount() {
                            return 10;
                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<List<Champion>> call, Throwable t) {
                // Handle error
                Log.d("FB","on failure");
            }
        });
    }

    private void displayListOfChampions(List<Champion> champions) {
        // Do something with the champions
        StringBuilder sb = new StringBuilder();
        for (Champion champion : champions) {
            sb.append(champion.getName());
        }
        Log.d("Champions", sb.toString());
    }
}