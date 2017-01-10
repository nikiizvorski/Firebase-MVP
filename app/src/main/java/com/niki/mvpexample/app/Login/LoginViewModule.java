package com.niki.mvpexample.app.Login;
import dagger.Module;
import dagger.Provides;

@Module
public class LoginViewModule {

    private LoginView loginView;

    public LoginViewModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    LoginView providesMainScreenContractView() {
        return loginView;
    }

    @Provides
    LoginInteractor loginInteractor(){
        return new LoginInteractorImpl();
    }

    @Provides
    LoginPresenter loginPresenter(LoginInteractor loginInteractor, LoginView loginView){
        return new LoginPresenterImpl(loginInteractor, loginView);
    }
}
