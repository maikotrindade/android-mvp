package com.maikotrindade.mvpandroid.presenter;

/**
 * Architecture class that determines the common behavior of presenters
 *
 * @author maiko.trindade
 * @since 11/06/2016
 */
public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();

}