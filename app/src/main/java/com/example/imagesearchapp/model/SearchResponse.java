/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 4:05 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 4:05 PM
 *
 */

package com.example.imagesearchapp.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResponse implements Parcelable
{

    @SerializedName("totalHits")
    @Expose
    public Integer totalHits;
    @SerializedName("hits")
    @Expose
    public List<Hit> hits = null;
    @SerializedName("total")
    @Expose
    public Integer total;
    public final static Creator<SearchResponse> CREATOR = new Creator<SearchResponse>() {

        public SearchResponse createFromParcel(Parcel in) {
            return new SearchResponse(in);
        }

        public SearchResponse[] newArray(int size) {
            return (new SearchResponse[size]);
        }

    }
    ;

    protected SearchResponse(Parcel in) {
        this.totalHits = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.hits, (com.example.imagesearchapp.model.Hit.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public SearchResponse() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalHits);
        dest.writeList(hits);
        dest.writeValue(total);
    }

    public int describeContents() {
        return  0;
    }

    public List<Hit> getHits() {
        return hits;
    }
}
