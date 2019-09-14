package com.example.mymvp.LoginMvp;

/**
 * description:
 * author: freed on 2019/9/14
 * email: 674919909@qq.com
 * version: 1.0
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();


}
