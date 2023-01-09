package com.example.app;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.database.entity.ChampionEntity;

import java.util.List;


public class FavorisListFragment extends Fragment {

    private RecyclerView recyclerView;
    private FavorisListAdapter adapter;
    private List<ChampionEntity> champions;
    private boolean isGrid;
    private Context context;

    public FavorisListFragment() {
        // Required empty public constructor
    }

    public static FavorisListFragment newInstance(List<ChampionEntity> champions, boolean isGrid, Context context) {
        FavorisListFragment fragment = new FavorisListFragment();
        fragment.champions = champions;
        fragment.isGrid = isGrid;
        fragment.context = context;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        if (isGrid) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        adapter = new FavorisListAdapter(champions, isGrid, context);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
