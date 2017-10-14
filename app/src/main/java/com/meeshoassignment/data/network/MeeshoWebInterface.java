package com.meeshoassignment.data.network;

import com.meeshoassignment.data.retrofit.PullRequest;
import com.meeshoassignment.data.retrofit.PullRequestResponse;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by root on 9/11/17.
 */

public interface MeeshoWebInterface {
    @GET("/repos/{owner}/{repo}/pulls")
    Observable<List<PullRequest>> getPullRequests(@Path("owner") String owner,
                                                  @Path("repo") String repo);

}

