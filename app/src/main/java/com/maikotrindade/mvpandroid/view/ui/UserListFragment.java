package com.maikotrindade.mvpandroid.view.ui;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maikotrindade.mvpandroid.R;
import com.maikotrindade.mvpandroid.model.User;
import com.maikotrindade.mvpandroid.presenter.UserListPresenter;
import com.maikotrindade.mvpandroid.presenter.adapter.RecyclerViewAdapter;
import com.maikotrindade.mvpandroid.view.UserListView;

import java.util.List;

/**
 * @author maiko.trindade
 * @since 11/06/2016
 */
public class UserListFragment extends Fragment implements UserListView {

    private View mRootView;
    private UserListPresenter mUserListPresenter;
    private static UserListFragment sFragmentInstance;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private ProgressDialog mProgressDialog;

    public static UserListFragment newInstance() {
        if (sFragmentInstance == null) {
            sFragmentInstance = new UserListFragment();
        }
        return sFragmentInstance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_user_list, container, false);

        configureRecyclerView();
        mUserListPresenter = new UserListPresenter();
        mUserListPresenter.attachView(this);
        mUserListPresenter.generateFooContent();
        return mRootView;
    }

    private void configureRecyclerView() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.users_recycler_view);
        final LinearLayoutManager layoutManager =
                new LinearLayoutManager(mRootView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void showProgress() {
        mProgressDialog = new ProgressDialog(mRootView.getContext());
        mProgressDialog = ProgressDialog.show(mRootView.getContext(),
                getString(R.string.progress_title), getString(R.string.progress_msg), true);
    }

    @Override
    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void updateUsers(List<User> users) {
        mRecyclerViewAdapter = new RecyclerViewAdapter(users);
        mRecyclerViewAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

}
