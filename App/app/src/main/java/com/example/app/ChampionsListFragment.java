package com.example.app;

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

import com.example.app.api.Champion;

import java.util.Collection;
import java.util.List;


public class ChampionsListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChampionsListAdapter adapter;
    private Collection<Champion> champions;
    private boolean isGrid;

    public ChampionsListFragment() {
        // Required empty public constructor
    }

    public static ChampionsListFragment newInstance(Collection<Champion> champions, boolean isGrid) {
        ChampionsListFragment fragment = new ChampionsListFragment();
        fragment.champions = champions;
        fragment.isGrid = isGrid;
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
        adapter = new ChampionsListAdapter(champions, isGrid);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
