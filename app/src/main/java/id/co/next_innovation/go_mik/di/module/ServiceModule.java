/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.di.module;

import android.app.Service;

import dagger.Module;

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }
}