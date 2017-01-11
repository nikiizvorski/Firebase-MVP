package com.niki.mvpexample.app.Login;
import dagger.Module;
import dagger.Provides;

/**
 * The type Login view module.
 */
@Module
public class LoginViewModule {

    private LoginView loginView;

    /**
     * Instantiates a new Login view module.
     *
     * @param loginView the login view
     */
    public LoginViewModule(LoginView loginView) {
        this.loginView = loginView;
    }

    /**
     * Provides main screen contract view login view.
     *
     * @return the login view
     */
    @Provides
    LoginView providesMainScreenContractView() {
        return loginView;
    }

    /**
     * Login interactor login interactor.
     *
     * @return the login interactor
     */
    @Provides
    LoginInteractor loginInteractor(){
        return new LoginInteractorImpl();
    }

    /**
     * Login presenter login presenter.
     *
     * @param loginInteractor the login interactor
     * @param loginView       the login view
     * @return the login presenter
     */
    @Provides
    LoginPresenter loginPresenter(LoginInteractor loginInteractor, LoginView loginView){
        return new LoginPresenterImpl(loginInteractor, loginView);
    }
}
