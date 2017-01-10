package com.niki.mvpexample.app.Login;

import com.niki.mvpexample.app.util.CustomScope;
import dagger.Component;

@CustomScope
@Component(modules = {LoginViewModule.class})
interface LoginViewComponent {
    void inject(LoginActivity loginActivity);
}
