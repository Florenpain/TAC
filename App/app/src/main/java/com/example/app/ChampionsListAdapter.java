package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.api.Champion;
import com.example.app.database.entity.ChampionEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChampionsListAdapter extends RecyclerView.Adapter<ChampionsListAdapter.ViewHolder> {

    private Collection<Champion> champions;
    private boolean isGrid;
    private Context context;

    public ChampionsListAdapter(Collection<Champion> champions, boolean isGrid, Context context) {
        this.champions = champions;
        this.isGrid = isGrid;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (isGrid) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item2, parent, false);
            return new ViewHolder(view, isGrid);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
            return new ViewHolder(view, isGrid);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Champion champion = (Champion) champions.toArray()[position];
        holder.bind(champion);
    }

    @Override
    public int getItemCount() {
        if (champions != null) {
            return champions.size();
        } else {
            return 0;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameTextView;
        private TextView titleTextView;
        private TextView tagsTextView;
        private boolean isGrid;
        private Button buttonAddFavorite;
        private String urlDataDragon = "https://ddragon.leagueoflegends.com/cdn/12.23.1/img/champion/";

        public ViewHolder(@NonNull View itemView, boolean isGrid) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.champion_name);
            imageView = itemView.findViewById(R.id.champion_image);
            titleTextView = itemView.findViewById(R.id.champion_title);
            tagsTextView = itemView.findViewById(R.id.champion_tags);
            buttonAddFavorite = itemView.findViewById(R.id.add_favorite_button);
        }

        public void bind(Champion champion) {
            nameTextView.setText(champion.getName());
            imageView.setImageResource(R.drawable.ic_launcher_background);
            Glide.with(itemView.getContext())
                    .load(urlDataDragon + champion.getImage().getFull())
                    .into(imageView);
            if (!isGrid) {
                titleTextView.setText(champion.getTitle());
                if (champion.getTags().size() > 1) {
                    tagsTextView.setText(champion.getTags().get(0) + " / " + champion.getTags().get(1));
                } else {
                    tagsTextView.setText(champion.getTags().get(0));
                }
            }
            // Gestion du clic sur 'add to favorites'
            buttonAddFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<ChampionEntity> favoris = MainActivity.getFavoris();
                    List<String> idList = new ArrayList<>();

                    // On récupère la liste des id des champions de la liste favoris
                    for (ChampionEntity championEntity : favoris) {
                        idList.add(championEntity.getId());
                    }
                    ChampionEntity championEntity = new ChampionEntity(champion.getId() ,champion.getName(), champion.getTitle(), champion.getImage().getFull(), champion.getTags().toString());
                    System.out.println("championEntity :" + championEntity);

                    // Si le champion n'est pas déjà dans la liste des favoris
                    if (idList.contains(championEntity.getId())) {
                        Toast.makeText(v.getContext(), "Champion déjà dans les favoris", Toast.LENGTH_SHORT).show();
                    } else {
                        MainActivity.getViewModel().addChampion(championEntity);
                        Toast.makeText(v.getContext(), "Champion ajouté aux favoris", Toast.LENGTH_SHORT).show();

                    }
                }
            });

            // Gestion du clic sur un champion ( ouverture de la page détails )
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ChampionDetailsActivity.class);
                    intent.putExtra("championId", champion.getId());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}

