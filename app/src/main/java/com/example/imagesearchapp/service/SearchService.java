/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 3:53 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 3:47 PM
 *
 */

package com.example.imagesearchapp.service;
import com.example.imagesearchapp.model.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchService {

    @GET(".")
    Call<SearchResponse> fetchImages(@Query("key") String key, @Query("q") String searchKeyWord, @Query("image_type") String criteria);
}
