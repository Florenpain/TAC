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

import java.util.Collection;

public class FavorisListAdapter extends RecyclerView.Adapter<FavorisListAdapter.ViewHolder> {

    private Collection<ChampionEntity> champions;
    private boolean isGrid;
    private Context context;

    public FavorisListAdapter(Collection<ChampionEntity> champions, boolean isGrid, Context context) {
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
        ChampionEntity championEntity = (ChampionEntity) champions.toArray()[position];
        holder.bind(championEntity);
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

        public void bind(ChampionEntity championEntity) {
            nameTextView.setText(championEntity.getName());
            buttonAddFavorite.setText("delete from favorites");
            imageView.setImageResource(R.drawable.ic_launcher_background);
            Glide.with(itemView.getContext())
                    .load(urlDataDragon + championEntity.getImage())
                    .into(imageView);
            if (!isGrid) {
                titleTextView.setText(championEntity.getTitle());
                tagsTextView.setText(championEntity.getTags());
            }
            buttonAddFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                    MainActivity.getRepository().deleteChampion(championEntity);
                    // TODO: refresh the list

                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ChampionDetailsActivity.class);
                    intent.putExtra("championId", championEntity.getId());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}

