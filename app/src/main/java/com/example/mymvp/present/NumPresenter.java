package com.example.mymvp.present;

import com.example.mymvp.IView;
import com.example.mymvp.ModelCallback;
import com.example.mymvp.NumModel;

/**
 * description:
 * author: freed on 2019/9/9
 * email: 674919909@qq.com
 * version: 1.0
 */
public class NumPresenter implements IPresent, ModelCallback {

    private NumModel numModel;
    private IView mView;

    public NumPresenter(IView mView) {
        this.mView = mView;
        numModel = new NumModel();
    }

    @Override
    public void onSuccess(int num) {
        mView.updateUI("success "+num);
    }

    @Override
    public void onFailed(String text) {
        mView.updateUI("failed");
    }

    @Override
    public void add() {
        numModel.add(this);
    }
}
