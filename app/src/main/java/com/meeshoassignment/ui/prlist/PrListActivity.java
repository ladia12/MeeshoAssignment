package com.meeshoassignment.ui.prlist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.meeshoassignment.R;
import com.meeshoassignment.app.MeeshoApplication;
import com.meeshoassignment.data.retrofit.PullRequest;
import com.meeshoassignment.data.retrofit.PullRequestResponse;
import com.meeshoassignment.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrListActivity extends BaseActivity implements PrContract.View {

    @Inject PrPresenter prPresenter;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.progress) View progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr_list);
        ButterKnife.bind(this);
        DaggerPrComponent.builder()
                .netComponent(((MeeshoApplication) getApplicationContext()).getNetComponent())
                .prModule(new PrModule(this))
                .build().inject(this);
        prPresenter.bindView(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        progress.setVisibility(View.VISIBLE);
        prPresenter.getPrList();
    }

    @Override
    public void showContent(Object items) {
        progress.setVisibility(View.GONE);
        ArrayList<PullRequest> pullRequests = (ArrayList<PullRequest>) items;
        PrListAdapter adpater = new PrListAdapter(pullRequests, this);
        mRecyclerView.setAdapter(adpater);
    }

    @Override
    public void showError(Throwable error) {
        error.printStackTrace();
        progress.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        prPresenter.unbindView(this);
        super.onDestroy();

    }
}
