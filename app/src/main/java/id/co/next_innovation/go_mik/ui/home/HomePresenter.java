/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.ui.home;

import com.androidnetworking.error.ANError;

import java.util.List;

import id.co.next_innovation.go_mik.data.DataManager;
import id.co.next_innovation.go_mik.data.db.entity.Category;
import id.co.next_innovation.go_mik.utils.AppLogger;
import id.co.next_innovation.go_mik.utils.rx.SchedulerProvider;
import id.co.next_innovation.go_mik.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class HomePresenter<V extends HomeView> extends BasePresenter<V> implements HomeMvpPresenter<V> {

    @Inject
    public HomePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadCategory() {
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager().fetchCategories()
                .observeOn(getSchedulerProvider().ui())
                .subscribeOn(getSchedulerProvider().io())
                .subscribe(categoryResponse -> {
                    if (categoryResponse.getData().getCategories()!=null) {
                        List<Category> categories = categoryResponse.getData().getCategories();
                        for (int i = 0; i < categories.size(); i++) {
                            getMvpView().addTab(categories.get(i));
                            AppLogger.e("CATTTT SIZE "+ categories.size());
                        }
                    }

                    getMvpView().hideLoading();
                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();

                    // handle the error here
                    if (throwable instanceof ANError) {
                        ANError anError = (ANError) throwable;
                        handleApiError(anError);
                    }
//                    if (!isViewAttached()) return;
//                    getMvpView().hideLoading();
//
//                    if (throwable instanceof ANError) {
//                        ANError anError = (ANError) throwable;
//                        handleApiError(anError);
//                    }
                }));
    }
}
