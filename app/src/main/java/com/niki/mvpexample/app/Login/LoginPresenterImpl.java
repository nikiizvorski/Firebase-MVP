package com.niki.mvpexample.app.Login;

import com.google.firebase.auth.FirebaseAuth;
import javax.inject.Inject;

class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    @Inject LoginView loginView;
    @Inject LoginInteractor loginInteractor;

    @Inject
    LoginPresenterImpl(LoginInteractor loginInteractor, LoginView loginView) {
        this.loginInteractor = loginInteractor;
        this.loginView = loginView;
    }

    @Override public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        if(username != null && !username.isEmpty()){
            if(password != null && !password.isEmpty()){
                loginInteractor.login(username, password, this, loginView);
            } else loginView.setPasswordError();
        } else loginView.setUsernameError();
    }

    @Override
    public void registerTheUser(String trim, String trim1) {
        if(loginView != null){
            loginView.showProgress();
        }

        if(trim != null && !trim.isEmpty()){
            if(trim1 != null && !trim1.isEmpty()){
                loginInteractor.registerUser(trim, trim1, this, loginView);
            } else loginView.setPasswordError();
        } else loginView.setUsernameError();
    }

    @Override
    public FirebaseAuth.AuthStateListener getAuthListener() {
        return loginInteractor.authListener(this);
    }

    @Override public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }
}
