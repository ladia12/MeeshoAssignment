package com.meeshoassignment.data.retrofit;

import java.util.ArrayList;

/**
 * Created by root on 10/14/17.
 */

public class PullRequestResponse {
    private ArrayList<PullRequest> pullRequests;

    public ArrayList<PullRequest> getPullRequests() {
        return pullRequests;
    }

    public void setPullRequests(ArrayList<PullRequest> pullRequests) {
        this.pullRequests = pullRequests;
    }

}
