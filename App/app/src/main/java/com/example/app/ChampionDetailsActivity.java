package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.app.api.Champion;
import com.example.app.api.ChampionDetails;
import com.example.app.api.DataDragon;
import com.example.app.api.DataDragonDetails;
import com.example.app.ui.main.ChampionDetailsFragment;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;

public class ChampionDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Récupération de l'intent envoyé par l'activité précédente
        Intent intent = getIntent();

        // Récupération des données de l'intent
        String championId = intent.getStringExtra("championId");

        Single<DataDragonDetails> mDataDragonDetails = RiotCalls.getInstance().getMyApi().getChampion( championId )
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .timeout(10, java.util.concurrent.TimeUnit.SECONDS);

        ChampionDetails mChampion = mDataDragonDetails.blockingGet().getData().get(championId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Affiche le bouton retour
        getSupportActionBar().setTitle( mChampion.getName());  // Affiche le nom du champion

        TextView textViewName = findViewById(R.id.name);
        textViewName.setText(mChampion.getName());

        TextView textViewTitle = findViewById(R.id.title);
        textViewTitle.setText(mChampion.getTitle());

        TextView textViewTags = findViewById(R.id.tags);
        if (mChampion.getTags().size() > 1) {
            textViewTags.setText(mChampion.getTags().get(0) + " / " + mChampion.getTags().get(1));
        } else {
            textViewTags.setText(mChampion.getTags().get(0));
        }

        TextView textViewLore = findViewById(R.id.lore);
        textViewLore.setText(mChampion.getLore());

        ImageView imageView = findViewById(R.id.image);
        Glide.with(this)
                .load("https://ddragon.leagueoflegends.com/cdn/12.23.1/img/champion/" +mChampion.getImage().getFull())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);

        ImageView imageViewPassive = findViewById(R.id.passive);
        Glide.with(this)
                .load("https://ddragon.leagueoflegends.com/cdn/12.23.1/img/passive/" +mChampion.getPassive().getImage().getFull())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageViewPassive);
        imageViewPassive.setContentDescription(mChampion.getPassive().getDescription());

        ImageView imageViewSpell1 = findViewById(R.id.spell1);
        Glide.with(this)
                .load("https://ddragon.leagueoflegends.com/cdn/12.23.1/img/spell/" +mChampion.getSpells().get(0).getImage().getFull())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageViewSpell1);
        imageViewSpell1.setContentDescription(mChampion.getSpells().get(0).getDescription());

        ImageView imageViewSpell2 = findViewById(R.id.spell2);
        Glide.with(this)
                .load("https://ddragon.leagueoflegends.com/cdn/12.23.1/img/spell/" +mChampion.getSpells().get(1).getImage().getFull())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageViewSpell2);
        imageViewSpell2.setContentDescription(mChampion.getSpells().get(1).getDescription());

        ImageView imageViewSpell3 = findViewById(R.id.spell3);
        Glide.with(this)
                .load("https://ddragon.leagueoflegends.com/cdn/12.23.1/img/spell/" +mChampion.getSpells().get(2).getImage().getFull())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageViewSpell3);
        imageViewSpell3.setContentDescription(mChampion.getSpells().get(2).getDescription());

        ImageView imageViewSpell4 = findViewById(R.id.spell4);
        Glide.with(this)
                .load("https://ddragon.leagueoflegends.com/cdn/12.23.1/img/spell/" +mChampion.getSpells().get(3).getImage().getFull())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageViewSpell4);
        imageViewSpell4.setContentDescription(mChampion.getSpells().get(3).getDescription());

        TextView textViewSpell1 = findViewById(R.id.spell1_name);
        textViewSpell1.setText(mChampion.getSpells().get(0).getName());

        TextView textViewSpell2 = findViewById(R.id.spell2_name);
        textViewSpell2.setText(mChampion.getSpells().get(1).getName());

        TextView textViewSpell3 = findViewById(R.id.spell3_name);
        textViewSpell3.setText(mChampion.getSpells().get(2).getName());

        TextView textViewSpell4 = findViewById(R.id.spell4_name);
        textViewSpell4.setText(mChampion.getSpells().get(3).getName());

        TextView textViewPassive = findViewById(R.id.passive_name);
        textViewPassive.setText(mChampion.getPassive().getName());
    }

    // Définir une fonction qui permet de retourner à l'activité précédente
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}