package com.niki.mvpexample.app.details;

import android.widget.AdapterView;

interface DetailsPresenter {
    void createItemsForAdapterRequest();

    void onDestroy();

    void leaveTheApp();

    void setOnItemClicked(int position, AdapterView<?> parent);
}
