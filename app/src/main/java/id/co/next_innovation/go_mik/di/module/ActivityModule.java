/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.di.module;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import id.co.next_innovation.go_mik.ui.home.HomeMvpPresenter;
import id.co.next_innovation.go_mik.ui.home.HomePresenter;
import id.co.next_innovation.go_mik.ui.splash.SplashMvpPresenter;
import id.co.next_innovation.go_mik.ui.splash.SplashPresenter;
import id.co.next_innovation.go_mik.utils.rx.AppSchedulerProvider;
import id.co.next_innovation.go_mik.utils.rx.SchedulerProvider;
import id.co.next_innovation.go_mik.di.ActivityContext;
import id.co.next_innovation.go_mik.ui.home.HomeView;
import id.co.next_innovation.go_mik.ui.splash.SplashView;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    SplashMvpPresenter<SplashView> provideSplashPresenter(
            SplashPresenter<SplashView> presenter) {
        return presenter;
    }

    @Provides
    HomeMvpPresenter<HomeView> provideHomePresenter(
            HomePresenter<HomeView> presenter) {
        return presenter;
    }
}
