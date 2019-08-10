
/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 10:26 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 3:50 PM
 *
 */

package com.example.imagesearchapp.application;

import com.example.imagesearchapp.manager.AppModule;
import com.example.imagesearchapp.ui.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface DiComponent {

    void inject(BaseActivity activity);
}
