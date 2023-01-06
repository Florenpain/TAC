package com.example.app;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.Champion;
import com.example.app.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.app.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private List<Champion> liste_champions;

    public MyItemRecyclerViewAdapter(List<Champion> items) {
        liste_champions = items;
    }

    public void setChampionsList(List<Champion> liste_champions) {
        this.liste_champions = liste_champions;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.name.setText(liste_champions.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (liste_champions != null) {
            return liste_champions.size();
        }
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name ;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + name.getText() + "'";
        }
    }

    public class PlaceholderItem {
        public final String id;
        public final String content;
        public final String details;

        public PlaceholderItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}