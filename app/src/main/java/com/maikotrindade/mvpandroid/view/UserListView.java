package com.maikotrindade.mvpandroid.view;

import com.maikotrindade.mvpandroid.model.User;

import java.util.List;

/**
 * @author maiko.trindade
 * @since 11/06/2016
 */
public interface UserListView {

    void showProgress();

    void hideProgress();

    void updateUsers(List<User> users);
}