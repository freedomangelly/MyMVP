package com.example.mymvp.LoginMvp;

import android.os.Handler;
import android.text.TextUtils;

/**
 * description:
 * author: freed on 2019/9/14
 * email: 674919909@qq.com
 * version: 1.0
 */
public class LoginMethod{
    private LoginCallBack callBack;
    public LoginMethod(LoginCallBack callBack){
        this.callBack = callBack;
    }

    public void login(final String username, final String password){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(TextUtils.isEmpty(username)){
                    callBack.onUnsernameError();
                }else if (TextUtils.isEmpty(password)){
                    callBack.onPasswordError();
                }else{
                    callBack.onSuccess();
                }
            }
        },2000);
    }

}
