package com.meeshoassignment.ui.prlist;

import com.meeshoassignment.data.network.MeeshoWebInterface;
import com.meeshoassignment.data.prefs.PrefsManager;
import com.meeshoassignment.ui.base.BasePresenter;
import com.meeshoassignment.ui.base.UIUpdateListener;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 10/14/17.
 */

public class PrPresenter extends BasePresenter<UIUpdateListener> implements PrContract.Presenter {
    public Retrofit retrofit;
    PrefsManager prefsManager;
    PrContract.View mView;

    @Inject
    public PrPresenter(Retrofit retrofit, PrefsManager prefsManager, PrContract.View mView) {
        this.retrofit = retrofit;
        this.prefsManager = prefsManager;
        this.mView = mView;
    }

    @Override
    public void getPrList() {
        final UIUpdateListener listener = getUiUpdateListener();
        Subscription prListSubscription = retrofit.create(MeeshoWebInterface.class).getPullRequests(prefsManager.getOwnerName(), prefsManager.getRepoName())
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread())
                .subscribe(getSubscriber(listener));
        queueSubscriptionForRemoval(prListSubscription);
    }
}
