/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.data.network;

import android.util.Base64;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;
    private Api mApi;

    @Inject
    public AppApiHelper(ApiHeader apiHeader, Api api) {
        mApiHeader = apiHeader;
        mApi = api;
    }

    @Override
    public ApiHeader getApiHeader() {
        return null;
    }

    @Override
    public Observable<ComicResponse> fetchAllComics() {
        return Rx2AndroidNetworking.get(mApi.mBaseUrl() + "comics")
                .build()
                .getObjectObservable(ComicResponse.class);
    }

    @Override
    public Observable<ComicResponse> fetchComicsByCategory(int category_id) {
        return Rx2AndroidNetworking.get(mApi.mBaseUrl() + "comics_by_category/"+category_id)
                .build()
                .getObjectObservable(ComicResponse.class);
    }

    @Override
    public Observable<CategoryResponse> fetchCategories() {
        return Rx2AndroidNetworking.get(mApi.mBaseUrl() + "categories")
                .build()
                .getObjectObservable(CategoryResponse.class);
    }

    @Override
    public Observable<EpisodeResponse> fetchAllEpisodes() {
        return Rx2AndroidNetworking.get(mApi.mBaseUrl() + "episodes")
                .build()
                .getObjectObservable(EpisodeResponse.class);
    }

    @Override
    public Observable<EpisodeResponse> fetchEpisodes(int comic_id) {
        return Rx2AndroidNetworking.get(mApi.mBaseUrl() + "episodes_by_comic/"+comic_id)
                .build()
                .getObjectObservable(EpisodeResponse.class);
    }
}
