package com.meeshoassignment.ui.base;

import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by root on 9/12/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseUIUpdateListener {

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(Throwable error) {
        error.printStackTrace();
    }
}
