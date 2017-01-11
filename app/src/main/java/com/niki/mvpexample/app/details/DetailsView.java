package com.niki.mvpexample.app.details;

import com.google.firebase.database.DatabaseReference;

/**
 * The interface Details view.
 */
interface DetailsView {
    /**
     * Init app data.
     */
    void initAppData();

    /**
     * Sets list items.
     *
     * @param databaseReference the database reference
     */
    void setListItems(DatabaseReference databaseReference);

    /**
     * Take user to login.
     */
    void takeUserToLogin();

    /**
     * Showmsg.
     *
     * @param msg the msg
     */
    void showmsg(String msg);
}
