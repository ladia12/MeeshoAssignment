package com.meeshoassignment.ui.main;

import com.meeshoassignment.data.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by root on 10/14/17.
 */

@Module
public class MainModule {
    private final MainContract.View mView;


    public MainModule(MainContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    MainContract.View providesAuthContractView() {
        return mView;
    }
}
