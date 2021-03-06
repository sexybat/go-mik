package id.co.next_innovation.go_mik;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import id.co.next_innovation.go_mik.data.DataManager;
import id.co.next_innovation.go_mik.di.component.ApplicationComponent;
import id.co.next_innovation.go_mik.di.component.DaggerApplicationComponent;
import id.co.next_innovation.go_mik.di.module.ApplicationModule;
import id.co.next_innovation.go_mik.utils.AppLogger;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class GoMiK extends Application {

    @Inject
    DataManager mDataManager;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
