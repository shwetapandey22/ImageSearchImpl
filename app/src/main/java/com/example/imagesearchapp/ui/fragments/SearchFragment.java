/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 10:28 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 5:30 PM
 *
 */

package com.example.imagesearchapp.ui.fragments;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.imagesearchapp.R;
import com.example.imagesearchapp.events.Bus;
import com.example.imagesearchapp.events.SearchResultReceivedEvent;
import com.example.imagesearchapp.ui.MainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SearchFragment extends Fragment {
	private static  String TITLE = "Picture Viewer";
    private ProgressBar progressBar;

    public static SearchFragment newInstance()
    {
        SearchFragment searchFragment = new SearchFragment();
        return searchFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		((MainActivity) getActivity()).setTitle(TITLE);
        Bus.getBus().register(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final SearchView searchView = view.findViewById(R.id.search_key);
        progressBar = view.findViewById(R.id.progressBar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Do whatever you need when text changes.
                // This will be fired every time you input any character.
                return false;
            }
        });
        Button submitBtn = view.findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               search(String.valueOf(searchView.getQuery()));
            }
        });
    }

    public void search(String searchKeyWord){
        if (!TextUtils.isEmpty(searchKeyWord)) {
            progressBar.setVisibility(View.VISIBLE);
            ((MainActivity)getActivity()).fetchRepositories(searchKeyWord);
        }
    }

   @Subscribe
    public void onEvent( SearchResultReceivedEvent searchResultReceivedEvent){
        System.out.println("-----HELLO----");
       progressBar.setVisibility(View.GONE);
   }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Bus.getBus().unregister(this);

    }
}
