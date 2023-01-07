package com.example.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.api.Champion;

import java.util.List;

public class ChampionsListAdapter extends RecyclerView.Adapter<ChampionsListAdapter.ViewHolder> {

    private List<Champion> champions;

    public ChampionsListAdapter(List<Champion> champions) {
        this.champions = champions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Champion champion = champions.get(position);
        holder.bind(champion);
    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nomChampion);
            imageView = itemView.findViewById(R.id.imageChampion);
        }

        public void bind(Champion champion) {
            nameTextView.setText(champion.getName());
            imageView.setImageResource(R.drawable.ic_launcher_background);
        }
    }
}

