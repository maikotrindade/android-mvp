package com.maikotrindade.mvpandroid.view.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;

import com.maikotrindade.mvpandroid.R;
import com.maikotrindade.mvpandroid.presenter.MainPresenter;
import com.maikotrindade.mvpandroid.view.MainView;

/**
 * @author maiko.trindade
 * @since 11/06/2016
 */
public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainPresenter = new MainPresenter();
        mMainPresenter.attachView(this);
        mMainPresenter.setDefaultFragment();

        configureActionBar();
    }

    private void configureActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_action_users);
    }

    @Override
    public void changeFragment(Fragment nextFragment, int titleResourceId) {
        setTitle(getResources().getText(titleResourceId));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main_activity, nextFragment)
                .commit();
    }
}