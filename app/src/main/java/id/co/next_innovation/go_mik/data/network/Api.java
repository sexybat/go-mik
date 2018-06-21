package id.co.next_innovation.go_mik.data.network;

import android.util.Base64;

import javax.inject.Singleton;

@Singleton
public class Api {

    static {
        System.loadLibrary("native-lib");
    }

    public native String invokeBaseUrl();

    public String mBaseUrl() {
        return new String(Base64.decode(invokeBaseUrl(), Base64.DEFAULT));
    }

}
