package com.example.mymvp.LoginMvp;

/**
 * description:
 * author: freed on 2019/9/14
 * email: 674919909@qq.com
 * version: 1.0
 */
public class LoginPresenter implements LoginCallBack,LoginMethodInterface {

    private LoginMethod loginMethod;
    private LoginView loginView;
    public LoginPresenter(LoginMethod loginMethod,LoginView loginView) {
       this.loginMethod = loginMethod;
       this.loginView = loginView;
    }

    @Override
    public void onUnsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }

    @Override
    public void login(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginMethod.login(username,password);
    }
}
