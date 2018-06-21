/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.di.module;

import android.app.Application;
import android.content.Context;

import id.co.next_innovation.go_mik.data.AppDataManager;
import id.co.next_innovation.go_mik.data.DataManager;
import id.co.next_innovation.go_mik.data.db.AppDbHelper;
import id.co.next_innovation.go_mik.data.db.DbHelper;
import id.co.next_innovation.go_mik.data.network.Api;
import id.co.next_innovation.go_mik.data.network.ApiHeader;
import id.co.next_innovation.go_mik.data.network.ApiHelper;
import id.co.next_innovation.go_mik.data.network.AppApiHelper;
import id.co.next_innovation.go_mik.data.prefs.AppPreferencesHelper;
import id.co.next_innovation.go_mik.data.prefs.PreferencesHelper;
import id.co.next_innovation.go_mik.di.DatabaseInfo;
import id.co.next_innovation.go_mik.utils.AppConstants;
import id.co.next_innovation.go_mik.BuildConfig;
import id.co.next_innovation.go_mik.R;
import id.co.next_innovation.go_mik.di.ApiInfo;
import id.co.next_innovation.go_mik.di.ApplicationContext;
import id.co.next_innovation.go_mik.di.PreferenceInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    Api provideApi() {
        return new Api();
    }

    @Provides
    @Singleton
    ApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                        DbHelper dbHelper) {
        return new ApiHeader();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
