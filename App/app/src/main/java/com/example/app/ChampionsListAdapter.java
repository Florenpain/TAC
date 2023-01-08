package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.app.api.Champion;

import java.util.Collection;
import java.util.List;

public class ChampionsListAdapter extends RecyclerView.Adapter<ChampionsListAdapter.ViewHolder> {

    private Collection<Champion> champions;
    private boolean isGrid;
    private Context context;
    private String urlDataDragon = "https://ddragon.leagueoflegends.com/cdn/12.23.1/img/champion/";

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
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Champion champion = (Champion) champions.toArray()[position];
        holder.bind(champion);
        Glide.with(context)
                .load(urlDataDragon + ((Champion) champions.toArray()[position]).getImage().getFull())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.champion_name);
            imageView = itemView.findViewById(R.id.champion_image);
        }

        public void bind(Champion champion) {
            nameTextView.setText(champion.getName());
            imageView.setImageResource(R.drawable.ic_launcher_background);
        }
    }
}

