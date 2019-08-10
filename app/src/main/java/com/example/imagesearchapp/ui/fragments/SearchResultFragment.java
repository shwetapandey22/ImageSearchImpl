/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 4:50 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 3:47 PM
 *
 */

package com.example.imagesearchapp.ui.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagesearchapp.R;
import com.example.imagesearchapp.model.Hit;
import com.example.imagesearchapp.ui.MainActivity;
import com.example.imagesearchapp.ui.adapter.SearchResultAdapter;

import java.util.ArrayList;
import java.util.List;


public class SearchResultFragment extends Fragment {
    private List<Hit> searchResults;
    private SearchResultAdapter searchResultAdapter;
    private RecyclerView recyclerView;
    private static final String SEARCH_RESULTS = "results";
    private static final String TITLE = "Search Results";


    public static SearchResultFragment newInstance(List<Hit> itemList){
        SearchResultFragment searchResultFragment = new SearchResultFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(SEARCH_RESULTS, (ArrayList<? extends Parcelable>) itemList);
        searchResultFragment.setArguments(bundle);
        return searchResultFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        searchResults = bundle.getParcelableArrayList(SEARCH_RESULTS);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setTitle(TITLE);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_result, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        searchResultAdapter = new SearchResultAdapter(getContext(), searchResults, new SearchResultAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Hit item) {
                ((MainActivity)getActivity()).displayImageDetails(item);
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(searchResultAdapter);
        searchResultAdapter.notifyDataSetChanged();
    }
}
