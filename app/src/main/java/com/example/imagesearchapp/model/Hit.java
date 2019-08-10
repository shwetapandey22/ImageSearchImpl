/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 4:05 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 4:05 PM
 *
 */

package com.example.imagesearchapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit implements Parcelable
{

    @SerializedName("largeImageURL")
    @Expose
    public String largeImageURL;
    @SerializedName("webformatHeight")
    @Expose
    public Integer webformatHeight;
    @SerializedName("webformatWidth")
    @Expose
    public Integer webformatWidth;
    @SerializedName("likes")
    @Expose
    public Integer likes;
    @SerializedName("imageWidth")
    @Expose
    public Integer imageWidth;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("views")
    @Expose
    public Integer views;
    @SerializedName("comments")
    @Expose
    public Integer comments;
    @SerializedName("pageURL")
    @Expose
    public String pageURL;
    @SerializedName("imageHeight")
    @Expose
    public Integer imageHeight;
    @SerializedName("webformatURL")
    @Expose
    public String webformatURL;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("previewHeight")
    @Expose
    public Integer previewHeight;
    @SerializedName("tags")
    @Expose
    public String tags;
    @SerializedName("downloads")
    @Expose
    public Integer downloads;
    @SerializedName("user")
    @Expose
    public String user;
    @SerializedName("favorites")
    @Expose
    public Integer favorites;
    @SerializedName("imageSize")
    @Expose
    public Integer imageSize;
    @SerializedName("previewWidth")
    @Expose
    public Integer previewWidth;
    @SerializedName("userImageURL")
    @Expose
    public String userImageURL;
    @SerializedName("previewURL")
    @Expose
    public String previewURL;
    public final static Creator<Hit> CREATOR = new Creator<Hit>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Hit createFromParcel(Parcel in) {
            return new Hit(in);
        }

        public Hit[] newArray(int size) {
            return (new Hit[size]);
        }

    }
    ;

    protected Hit(Parcel in) {
        this.largeImageURL = ((String) in.readValue((String.class.getClassLoader())));
        this.webformatHeight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.webformatWidth = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.likes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.imageWidth = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.views = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.comments = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pageURL = ((String) in.readValue((String.class.getClassLoader())));
        this.imageHeight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.webformatURL = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.previewHeight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.tags = ((String) in.readValue((String.class.getClassLoader())));
        this.downloads = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.user = ((String) in.readValue((String.class.getClassLoader())));
        this.favorites = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.imageSize = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.previewWidth = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userImageURL = ((String) in.readValue((String.class.getClassLoader())));
        this.previewURL = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Hit() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(largeImageURL);
        dest.writeValue(webformatHeight);
        dest.writeValue(webformatWidth);
        dest.writeValue(likes);
        dest.writeValue(imageWidth);
        dest.writeValue(id);
        dest.writeValue(userId);
        dest.writeValue(views);
        dest.writeValue(comments);
        dest.writeValue(pageURL);
        dest.writeValue(imageHeight);
        dest.writeValue(webformatURL);
        dest.writeValue(type);
        dest.writeValue(previewHeight);
        dest.writeValue(tags);
        dest.writeValue(downloads);
        dest.writeValue(user);
        dest.writeValue(favorites);
        dest.writeValue(imageSize);
        dest.writeValue(previewWidth);
        dest.writeValue(userImageURL);
        dest.writeValue(previewURL);
    }

    public int describeContents() {
        return  0;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getViews() {
        return views;
    }

    public Integer getComments() {
        return comments;
    }

    public String getPageURL() {
        return pageURL;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public String getUser() {
        return user;
    }

    public Integer getFavorites() {
        return favorites;
    }
}
