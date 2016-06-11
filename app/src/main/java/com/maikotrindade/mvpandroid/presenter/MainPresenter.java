package com.maikotrindade.mvpandroid.presenter;

import com.maikotrindade.mvpandroid.R;
import com.maikotrindade.mvpandroid.view.MainView;
import com.maikotrindade.mvpandroid.view.ui.MainActivity;
import com.maikotrindade.mvpandroid.view.ui.UserListFragment;

/**
 * Presenter layer of {@link MainActivity}
 *
 * @author maiko.trindade
 * @since 11/06/2016
 */
public class MainPresenter implements BasePresenter<MainView> {

    private MainView mMainView;

    public void setDefaultFragment() {
        mMainView.changeFragment(UserListFragment.newInstance(), R.string.user_list);
    }

    @Override
    public void attachView(MainView view) {
        mMainView = view;
    }

    @Override
    public void detachView() {
        mMainView = null;
    }
}
