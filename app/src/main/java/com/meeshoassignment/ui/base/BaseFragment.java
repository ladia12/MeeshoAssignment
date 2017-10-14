package com.meeshoassignment.ui.base;

import android.content.Context;
import android.support.v4.app.Fragment;


/**
 * Created by root on 9/12/17.
 */

public abstract class BaseFragment extends Fragment implements BaseUIUpdateListener {

    private BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(Throwable error) {

    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }
}
