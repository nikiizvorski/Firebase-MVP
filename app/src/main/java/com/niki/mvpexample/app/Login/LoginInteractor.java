package com.niki.mvpexample.app.Login;

import com.google.firebase.auth.FirebaseAuth;

/**
 * The interface Login interactor.
 */
interface LoginInteractor {

    /**
     * The interface On login finished listener.
     */
    interface OnLoginFinishedListener {
        /**
         * On username error.
         */
        void onUsernameError();

        /**
         * On password error.
         */
        void onPasswordError();

        /**
         * On success.
         */
        void onSuccess();
    }

    /**
     * Auth listener firebase auth . auth state listener.
     *
     * @param listener the listener
     * @return the firebase auth . auth state listener
     */
    FirebaseAuth.AuthStateListener authListener(OnLoginFinishedListener listener);

    /**
     * Register user.
     *
     * @param trim     the trim
     * @param trim1    the trim 1
     * @param listener the listener
     * @param view     the view
     */
    void registerUser(String trim, String trim1, OnLoginFinishedListener listener, LoginView view);

    /**
     * Login.
     *
     * @param username the username
     * @param password the password
     * @param listener the listener
     * @param view     the view
     */
    void login(String username, String password, OnLoginFinishedListener listener, LoginView view);

}
