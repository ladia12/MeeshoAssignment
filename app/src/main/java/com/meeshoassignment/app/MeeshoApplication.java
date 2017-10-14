package com.meeshoassignment.app;

import android.app.Application;

import com.meeshoassignment.data.di.component.DaggerNetComponent;
import com.meeshoassignment.data.di.component.NetComponent;
import com.meeshoassignment.data.di.module.AppModule;
import com.meeshoassignment.data.di.module.NetModule;

/**
 * Created by root on 10/14/17.
 */

public class MeeshoApplication extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://api.github.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
