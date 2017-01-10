package com.niki.mvpexample.app.Login;

import com.google.firebase.auth.FirebaseAuth;

interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
    }

    FirebaseAuth.AuthStateListener authListener(OnLoginFinishedListener listener);
    void registerUser(String trim, String trim1, OnLoginFinishedListener listener, LoginView view);
    void login(String username, String password, OnLoginFinishedListener listener, LoginView view);

}
