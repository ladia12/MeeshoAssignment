package com.meeshoassignment.ui.prlist;

import com.meeshoassignment.ui.base.UIUpdateListener;

/**
 * Created by root on 10/14/17.
 */

public interface PrContract {
    interface View extends UIUpdateListener {

    }

    interface Presenter {
        void getPrList();
    }
}
