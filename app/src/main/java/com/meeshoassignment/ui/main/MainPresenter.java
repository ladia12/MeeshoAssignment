package com.meeshoassignment.ui.main;

import com.meeshoassignment.data.prefs.PrefsManager;
import com.meeshoassignment.utils.StringUtils;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by root on 10/14/17.
 */

public class MainPresenter implements MainContract.Presenter {

    public Retrofit retrofit;
    PrefsManager prefsManager;
    MainContract.View mView;

    @Inject
    public MainPresenter(Retrofit retrofit, PrefsManager prefsManager, MainContract.View mView) {
        this.retrofit = retrofit;
        this.prefsManager = prefsManager;
        this.mView = mView;
    }

    @Override
    public void getPrClicked(String ownerName, String repoName) {
        if(StringUtils.isNullOrEmpty(ownerName)) {
            mView.showMessage("Please enter an owner name");
            return;
        }
        if(StringUtils.isNullOrEmpty(repoName)) {
            mView.showMessage("Please enter a repo name");
            return;
        }
        prefsManager.setOwnerName(ownerName);
        prefsManager.setRepoName(repoName);
        mView.openPrListActivity();

    }
}
