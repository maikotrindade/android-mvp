package com.maikotrindade.mvpandroid.presenter;

import android.os.Handler;

import com.maikotrindade.mvpandroid.model.User;
import com.maikotrindade.mvpandroid.view.UserListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maiko.trindade
 * @since 11/06/2016
 */
public class UserListPresenter implements BasePresenter<UserListView> {

    private UserListView mUserListView;

    private static final int LOADING_PROGRESS_TIME = 5 * 1000;

    /**
     * It simulates 'gathering info' from somewhere, typical foo data
     */
    public void generateFooContent() {
        mUserListView.showProgress();

        final List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User("User Name # " + i, "User Surname " + i, "username@email.com");
            users.add(user);
        }

        /**
         * it's a simple delay to display the progress dialog
         */
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mUserListView.updateUsers(users);
                mUserListView.hideProgress();
            }
        }, LOADING_PROGRESS_TIME);
    }

    @Override
    public void attachView(UserListView view) {
        mUserListView = view;
    }

    @Override
    public void detachView() {
        mUserListView = null;
    }
}
