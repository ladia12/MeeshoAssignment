package com.meeshoassignment.ui.base;

/**
 * Created by root on 9/12/17.
 */

public interface BaseUIUpdateListener {
    void showLoading();

    void hideLoading();

    void showError(Throwable error);
}
