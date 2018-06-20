/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.ui.splash;

import id.co.next_innovation.go_mik.data.DataManager;
import id.co.next_innovation.go_mik.utils.rx.SchedulerProvider;
import id.co.next_innovation.go_mik.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter<V extends SplashView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
