package com.niki.mvpexample.app.Login;

/**
 * The interface Login view.
 */
interface LoginView {
    /**
     * Register user.
     */
    void registerUser();

    /**
     * Login user.
     */
    void loginUser();

    /**
     * Init app data.
     */
    void initAppData();

    /**
     * Show progress.
     */
    void showProgress();

    /**
     * Hide progress.
     */
    void hideProgress();

    /**
     * Sets username error.
     */
    void setUsernameError();

    /**
     * Sets password error.
     */
    void setPasswordError();

    /**
     * Navigate to home.
     */
    void navigateToHome();
}
