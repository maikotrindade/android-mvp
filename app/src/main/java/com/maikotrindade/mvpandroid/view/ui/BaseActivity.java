package com.maikotrindade.mvpandroid.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Architecture class that determines the common behavior of activities
 *
 * @author maiko.trindade
 * @since 11/06/2016
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}