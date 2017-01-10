package com.niki.mvpexample.app.details;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import javax.inject.Inject;

class DetailsIteratorImpl implements DetailsIterator {

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

