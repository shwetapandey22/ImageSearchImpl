/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 3:51 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 3:50 PM
 *
 */

package com.example.imagesearchapp.manager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    @Provides
    @Singleton
    static ServiceManager provideServiceManager(){
        return new ServiceManager();
    }

}
