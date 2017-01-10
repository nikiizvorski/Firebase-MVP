package com.niki.mvpexample.app.Login;

import com.google.firebase.auth.FirebaseAuth;

interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();

    void registerTheUser(String trim, String trim1);

    FirebaseAuth.AuthStateListener getAuthListener();
}
