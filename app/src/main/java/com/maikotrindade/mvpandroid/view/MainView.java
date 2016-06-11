package com.maikotrindade.mvpandroid.view;

import android.support.v4.app.Fragment;

/**
 * @author maiko.trindade
 * @since 11/06/2016
 */
public interface MainView {

    void changeFragment(Fragment nextFragment, int titleResourceId);

}