/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.service;

import android.app.Service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import id.co.next_innovation.go_mik.GoMiK;
import id.co.next_innovation.go_mik.data.DataManager;
import id.co.next_innovation.go_mik.di.component.DaggerServiceComponent;
import id.co.next_innovation.go_mik.di.component.ServiceComponent;
import id.co.next_innovation.go_mik.utils.AppLogger;

import javax.inject.Inject;

public class SyncService extends Service {

    private static final String TAG = "SyncService";

    @Inject
    DataManager mDataManager;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncService.class);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SyncService.class);
        context.startService(starter);
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, SyncService.class));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceComponent component = DaggerServiceComponent.builder()
                .applicationComponent(((GoMiK) getApplication()).getComponent())
                .build();
        component.inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppLogger.d(TAG, "SyncService started");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        AppLogger.d(TAG, "SyncService stopped");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
