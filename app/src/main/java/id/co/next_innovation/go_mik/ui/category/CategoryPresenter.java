package id.co.next_innovation.go_mik.ui.category;

import com.androidnetworking.error.ANError;
import com.google.gson.Gson;

import javax.inject.Inject;

import id.co.next_innovation.go_mik.data.DataManager;
import id.co.next_innovation.go_mik.data.network.CategoryResponse;
import id.co.next_innovation.go_mik.ui.base.BasePresenter;
import id.co.next_innovation.go_mik.utils.AppLogger;
import id.co.next_innovation.go_mik.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class CategoryPresenter<V extends CategoryView> extends BasePresenter<V> implements CategoryMvpPresenter<V> {

    @Inject
    public CategoryPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadComicsByCategory(int category_id) {
//        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager().fetchComicsByCategory(category_id)
                .observeOn(getSchedulerProvider().ui())
                .subscribeOn(getSchedulerProvider().io())
                .subscribe(comicResponse -> {
                    getMvpView().hideLoading();
//                    AppLogger.e("CAT PRESENTER"+new Gson().toJson(comicResponse.getData().getComics()));

//                    if (comicResponse.getData().getComics()!=null) {
                        getMvpView().showComics(comicResponse.getData().getComics());
//                    }

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