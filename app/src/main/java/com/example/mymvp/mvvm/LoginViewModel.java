package com.example.mymvp.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymvp.LoginMvp.LoginCallBack;
import com.example.mymvp.LoginMvp.LoginMethod;
import com.example.mymvp.LoginMvp.LoginMethodInterface;

/**
 * description:
 * author: freed on 2019/9/14
 * email: 674919909@qq.com
 * version: 1.0
 */
public class LoginViewModel extends ViewModel implements LoginCallBack, LoginMethodInterface {
    private LoginMethod loginMethod;

    private MutableLiveData<Integer> loginResult = new MutableLiveData<>();

    public LoginViewModel() {
        this.loginMethod = new LoginMethod(this);
    }

    public MutableLiveData<Integer> getLoginResult() {
        return loginResult;
    }

    @Override
    public void onUnsernameError() {
        loginResult.setValue(1);
        loginResult.setValue(4);
    }

    @Override
    public void onPasswordError() {
        loginResult.setValue(2);
        loginResult.setValue(4);
    }

    @Override
    public void onSuccess() {
        loginResult.setValue(0);
    }

    @Override
    public void login(String username, String password) {
        loginResult.setValue(3);
        loginMethod.login(username,password);
    }

}
