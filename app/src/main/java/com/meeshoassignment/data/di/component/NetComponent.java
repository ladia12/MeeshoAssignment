package com.meeshoassignment.data.di.component;

import android.content.SharedPreferences;

import com.meeshoassignment.data.di.module.AppModule;
import com.meeshoassignment.data.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    // downstream components need these exposed with the return type
    // method name does not really matter
    Retrofit retrofit();
    SharedPreferences sharedPreferences();
}
