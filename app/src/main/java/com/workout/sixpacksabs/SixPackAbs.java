package com.workout.sixpacksabs;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.workout.sixpacksabs.helper.AppConstant;


/**
 * Created by AdnanAli on 3/9/2018.
 */

public class SixPackAbs extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppConstant.mContext = getApplicationContext();
        MultiDex.install(this);
        Stetho.initializeWithDefaults(this);
    }

}
