package com.meeshoassignment.ui.prlist;

import com.meeshoassignment.data.di.ActivityScope;
import com.meeshoassignment.ui.main.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by root on 10/14/17.
 */

@Module
public class PrModule {
    private final PrContract.View mView;


    public PrModule(PrContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    PrContract.View providesPrContractView() {
        return mView;
    }
}
