package com.meeshoassignment.ui.main;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.meeshoassignment.R;
import com.meeshoassignment.app.MeeshoApplication;
import com.meeshoassignment.ui.prlist.PrListActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.repo_name) EditText mRepoName;
    @BindView(R.id.owner_name) EditText mOwnerName;

    @Inject MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerMainComponent.builder()
                .netComponent(((MeeshoApplication) getApplicationContext()).getNetComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);
    }

    @OnClick(R.id.get_pr_button) public void getList(View view) {
        mainPresenter.getPrClicked(mOwnerName.getText().toString(), mRepoName.getText().toString());
    }

    @Override
    public void showMessage(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void openPrListActivity() {
        Intent intent = new Intent(this, PrListActivity.class);
        startActivity(intent);
    }
}
