package com.maikotrindade.mvpandroid.presenter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maikotrindade.mvpandroid.R;
import com.maikotrindade.mvpandroid.model.User;

import java.util.List;

/**
 * Adapter responsible for handle a collection of {@link User}
 *
 * @author maiko.trindade
 * @since 11/06/2016
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<User> mUsers;

    public RecyclerViewAdapter(List<User> users) {
        mUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.recycler_view_user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = mUsers.get(position);

        holder.mNameTextView.setText(user.getName());
        holder.mSurnameTextView.setText(user.getSurname());
        holder.mEmailTextView.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mNameTextView;
        private TextView mSurnameTextView;
        private TextView mEmailTextView;


        public ViewHolder(View view) {
            super(view);
            mNameTextView = (TextView) view.findViewById(R.id.name_text_view);
            mSurnameTextView = (TextView) view.findViewById(R.id.surname_text_view);
            mEmailTextView = (TextView) view.findViewById(R.id.email_text_view);
        }
    }
}