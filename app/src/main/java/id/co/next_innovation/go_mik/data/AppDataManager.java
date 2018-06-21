/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.data;

import android.content.Context;

import id.co.next_innovation.go_mik.data.network.ApiHeader;
import id.co.next_innovation.go_mik.data.network.ApiHelper;
import id.co.next_innovation.go_mik.data.network.CategoryResponse;
import id.co.next_innovation.go_mik.data.network.ComicResponse;
import id.co.next_innovation.go_mik.data.network.EpisodeResponse;
import id.co.next_innovation.go_mik.data.prefs.PreferencesHelper;
import id.co.next_innovation.go_mik.data.db.DbHelper;
import id.co.next_innovation.go_mik.di.ApplicationContext;
import io.reactivex.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return null;
    }

    @Override
    public Observable<ComicResponse> fetchAllComics() {
        return mApiHelper.fetchAllComics();
    }

    @Override
    public Observable<ComicResponse> fetchComicsByCategory(int category_id) {
        return mApiHelper.fetchComicsByCategory(category_id);
    }

    @Override
    public Observable<CategoryResponse> fetchCategories() {
        return mApiHelper.fetchCategories();
    }

    @Override
    public Observable<EpisodeResponse> fetchAllEpisodes() {
        return mApiHelper.fetchAllEpisodes();
    }

    @Override
    public Observable<EpisodeResponse> fetchEpisodes(int comic_id) {
        return mApiHelper.fetchEpisodes(comic_id);
    }
}
