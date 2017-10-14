package com.meeshoassignment.ui.main;

/**
 * Created by root on 10/14/17.
 */

public class MainContract {
    interface View {
        void showMessage(String message);
        void openPrListActivity();
    }

    interface Presenter {
        void getPrClicked(String ownerName, String repoName);
    }
}
