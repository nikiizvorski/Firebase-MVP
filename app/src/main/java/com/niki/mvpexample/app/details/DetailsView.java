package com.niki.mvpexample.app.details;

import com.google.firebase.database.DatabaseReference;

interface DetailsView {
    void initAppData();
    void setListItems(DatabaseReference databaseReference);
    void takeUserToLogin();
    void showmsg(String msg);
}
