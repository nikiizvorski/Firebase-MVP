package com.niki.mvpexample.app.details;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import javax.inject.Inject;

/**
 * The type Details iterator.
 */
class DetailsIteratorImpl implements DetailsIterator {

    /**
     * Instantiates a new Details iterator.
     */
    @Inject
    DetailsIteratorImpl() {}

    @Override
    public DatabaseReference getDB() {
        return FirebaseDatabase.getInstance().getReference().child("knigi");
    }

    @Override
    public void logOutTheUser() {
        FirebaseAuth.getInstance().signOut();
    }
}

