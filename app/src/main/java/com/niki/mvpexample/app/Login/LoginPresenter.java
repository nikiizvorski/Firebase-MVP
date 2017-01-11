package com.niki.mvpexample.app.Login;

import com.google.firebase.auth.FirebaseAuth;

/**
 * The interface Login presenter.
 */
interface LoginPresenter {
    /**
     * Validate credentials.
     *
     * @param username the username
     * @param password the password
     */
    void validateCredentials(String username, String password);

    /**
     * On destroy.
     */
    void onDestroy();

    /**
     * Register the user.
     *
     * @param trim  the trim
     * @param trim1 the trim 1
     */
    void registerTheUser(String trim, String trim1);

    /**
     * Gets auth listener.
     *
     * @return the auth listener
     */
    FirebaseAuth.AuthStateListener getAuthListener();
}
