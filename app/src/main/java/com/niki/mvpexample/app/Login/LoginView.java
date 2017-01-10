package com.niki.mvpexample.app.Login;

interface LoginView {
    void initAppData();

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
