package com.niki.mvpexample.app.details;

import android.widget.AdapterView;

/**
 * The interface Details presenter.
 */
interface DetailsPresenter {
    /**
     * Create items for adapter request.
     */
    void createItemsForAdapterRequest();

    /**
     * On destroy.
     */
    void onDestroy();

    /**
     * Leave the app.
     */
    void leaveTheApp();

    /**
     * Sets on item clicked.
     *
     * @param position the position
     * @param parent   the parent
     */
    void setOnItemClicked(int position, AdapterView<?> parent);
}
