package xyz.sahildave.cleartax;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by sahil on 9/7/16.
 */
public class ClearTaxApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
