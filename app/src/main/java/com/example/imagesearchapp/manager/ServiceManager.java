/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 3:51 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 3:47 PM
 *
 */

package com.example.imagesearchapp.manager;

import android.util.Log;

import com.example.imagesearchapp.model.SearchResponse;
import com.example.imagesearchapp.service.SearchService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceManager {

    private static final String BASE_URL = "https://pixabay.com/api/";
    private static  final String API_KEY = "13271750-04e4dc1b82c103a4be4a869ec";
    private static  final String SEARCH_CRITERIA = "photo";
    protected Retrofit retrofit;
    public ServiceManager() {
        getRetrofitInstance();
    }

    public  Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    public SearchResponse fetchImages(String searchKeyword){

        try {

            SearchService service = retrofit.create(SearchService.class);
            Call<SearchResponse> call = service.fetchImages(API_KEY, searchKeyword, SEARCH_CRITERIA);
            Response<SearchResponse> searchResponse = call.execute();
            return searchResponse.body();

        }catch (Exception ex){
            Log.e("ERROR","error fetching data");
        }
        return null;
    }

}
