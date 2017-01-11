package com.niki.mvpexample.app.details;

import com.google.firebase.database.DatabaseReference;

/**
 * The interface Details iterator.
 */
interface DetailsIterator {
    /**
     * Gets db.
     *
     * @return the db
     */
    DatabaseReference getDB();

    /**
     * Log out the user.
     */
    void logOutTheUser();
}
