/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 10:25 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 10:25 PM
 *
 */

package com.example.imagesearchapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.imagesearchapp.R;
import com.example.imagesearchapp.model.Hit;
import com.example.imagesearchapp.ui.MainActivity;


public class ImageDetailsFragment extends Fragment {
    private static String IMAGE_OBJECT = "imageDetails";
    private static  String TITLE = "Image Details";

    public static ImageDetailsFragment newInstance(Hit item)
    {
        ImageDetailsFragment imageDetailsFragment = new ImageDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(IMAGE_OBJECT, item);
		imageDetailsFragment.setArguments(bundle);
        return imageDetailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setTitle(TITLE);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        Hit imageObj = bundle.getParcelable(IMAGE_OBJECT);
        TextView imageOwner = view.findViewById(R.id.image_owner);
        TextView likes = view.findViewById(R.id.likes);
        TextView comments = view.findViewById(R.id.comments);
        TextView favorites = view.findViewById(R.id.favorites);
        TextView downloads = view.findViewById(R.id.downloads);

        imageOwner.setText(getResources().getString(R.string.username,imageObj.getUser()));
        likes.setText(getResources().getString(R.string.likes, String.valueOf(imageObj.getLikes())));
        favorites.setText(getResources().getString(R.string.favorites, String.valueOf(imageObj.getFavorites())));
        downloads.setText(getResources().getString(R.string.downloads, String.valueOf(imageObj.getDownloads())));
        comments.setText(getResources().getString(R.string.comments, String.valueOf(imageObj.getComments())));

    }
}
