package com.meeshoassignment.ui.main;

import com.meeshoassignment.data.di.ActivityScope;
import com.meeshoassignment.data.di.component.NetComponent;

import javax.inject.Inject;

import dagger.Component;

@ActivityScope
@Component(dependencies = NetComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
