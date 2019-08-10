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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.imagesearchapp.R;
import com.example.imagesearchapp.ui.MainActivity;

public class SearchFragment extends Fragment {
	private static  String TITLE = "Image Search";

    public static SearchFragment newInstance()
    {
        SearchFragment searchFragment = new SearchFragment();
        return searchFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		((MainActivity) getActivity()).setTitle(TITLE);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText searchKey = view.findViewById(R.id.search_key);
        Button submitBtn = view.findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable searchKeyWord = searchKey.getText();
                if (!TextUtils.isEmpty(searchKeyWord)) {
                    ((MainActivity)getActivity()).fetchRepositories(searchKeyWord.toString());
                }
            }
        });
    }
}