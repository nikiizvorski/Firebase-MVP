package com.niki.mvpexample.app.Login;

import com.niki.mvpexample.app.util.CustomScope;
import dagger.Component;

/**
 * The interface Login view component.
 */
@CustomScope
@Component(modules = {LoginViewModule.class})
interface LoginViewComponent {
    /**
     * Inject.
     *
     * @param loginActivity the login activity
     */
    void inject(LoginActivity loginActivity);
}
