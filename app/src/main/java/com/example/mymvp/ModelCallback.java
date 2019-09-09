package com.example.mymvp;

/**
 * description:
 * author: freed on 2019/9/9
 * email: 674919909@qq.com
 * version: 1.0
 */
public interface ModelCallback {
    void onSuccess(int num);

    void onFailed(String text);
}
