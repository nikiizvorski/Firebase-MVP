package com.niki.mvpexample.app.details;

import com.google.firebase.database.DatabaseReference;

interface DetailsIterator {
    DatabaseReference getDB();
    void logOutTheUser();
}
