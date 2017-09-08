package com.logicturtle.hackathon.Activity;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

/**
 * Created by user on 14-Jun-17.
 */

public class MentorApp extends Application {

    public static Context sContext;
    public static MentorApp instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sContext = getApplicationContext();

    }

    public static Context getAppContext() {
        return sContext;
    }

    public static Context getAppInstance() {
        return instance;
    }

    public static boolean hasNetwork() {
        return instance.checkIfHasNetwork();
    }

    public boolean checkIfHasNetwork() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean hasGPS(Context context) {
        return instance.hasGPSDevice(context);
    }

    public boolean hasGPSDevice(Context context) {
        final LocationManager mgr = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (mgr == null) return false;
        final List<String> providers = mgr.getAllProviders();
        if (providers == null) return false;
        return providers.contains(LocationManager.GPS_PROVIDER);
    }


}
