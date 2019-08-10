/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 3:54 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 3:47 PM
 *
 */

package com.example.imagesearchapp.ui;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.fragment.app.FragmentTransaction;

import com.example.imagesearchapp.R;
import com.example.imagesearchapp.model.Hit;
import com.example.imagesearchapp.model.SearchResponse;
import com.example.imagesearchapp.ui.fragments.ImageDetailsFragment;
import com.example.imagesearchapp.ui.fragments.SearchFragment;
import com.example.imagesearchapp.ui.fragments.SearchResultFragment;

import java.util.List;

public class MainActivity extends BaseActivity {

    private List<Hit> itemList;
    private static final String SEARCH_FRAGMENT_TAG = "serach_results";
    private static final String IMG_DETAILS_FRAGMENT_TAG = "image_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, SearchFragment.newInstance());
        fragmentTransaction.commit();
    }


    public void fetchRepositories(String searchKeyWord) {
        if (!TextUtils.isEmpty(searchKeyWord)) {
            new FetchImagesTask().execute(searchKeyWord.toString());
        }
    }

    private class FetchImagesTask extends android.os.AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            SearchResponse searchResponse = serviceManager.fetchImages(params[0]);
            itemList = searchResponse.getHits();
            displaySearchResults(itemList);
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

    private void displaySearchResults(List<Hit> itemList) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        SearchResultFragment searchResultFragment = SearchResultFragment.newInstance(itemList);
        fragmentTransaction.replace(R.id.fragment_container, searchResultFragment).addToBackStack(SEARCH_FRAGMENT_TAG);
        fragmentTransaction.commit();
    }

    public void displayImageDetails(Hit imageItem) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ImageDetailsFragment imageDetailsFragment = ImageDetailsFragment.newInstance(imageItem);
        fragmentTransaction.replace(R.id.fragment_container, imageDetailsFragment).addToBackStack(IMG_DETAILS_FRAGMENT_TAG);
        fragmentTransaction.commit();
    }

    public void setTitle(String title){
        this.getSupportActionBar().setTitle(
                title);
    }
}
