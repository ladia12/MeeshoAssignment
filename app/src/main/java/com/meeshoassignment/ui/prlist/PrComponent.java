package com.meeshoassignment.ui.prlist;

import com.meeshoassignment.data.di.ActivityScope;
import com.meeshoassignment.data.di.component.NetComponent;
import com.meeshoassignment.ui.main.MainActivity;
import com.meeshoassignment.ui.main.MainModule;

import dagger.Component;

/**
 * Created by root on 10/14/17.
 */

@ActivityScope
@Component(dependencies = NetComponent.class, modules = PrModule.class)
public interface PrComponent {
    void inject(PrListActivity prListActivity);
}
