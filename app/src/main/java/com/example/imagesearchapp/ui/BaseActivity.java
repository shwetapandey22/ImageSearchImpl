/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 3:54 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 3:47 PM
 *
 */

package com.example.imagesearchapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imagesearchapp.application.DaggerDiComponent;
import com.example.imagesearchapp.manager.ServiceManager;

import javax.inject.Inject;


public class BaseActivity extends AppCompatActivity {

    @Inject
    ServiceManager serviceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerDiComponent.create().inject(this);
    }
}
