/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.di.component;

import android.app.Application;
import android.content.Context;

import id.co.next_innovation.go_mik.GoMiK;
import id.co.next_innovation.go_mik.data.DataManager;
import id.co.next_innovation.go_mik.service.SyncService;
import id.co.next_innovation.go_mik.di.ApplicationContext;
import id.co.next_innovation.go_mik.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(GoMiK app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
