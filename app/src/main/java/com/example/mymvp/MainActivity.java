package com.example.mymvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mymvp.present.IPresent;
import com.example.mymvp.present.NumPresenter;

public class MainActivity extends AppCompatActivity implements IView{

    private TextView mTextView;
    private Button mButton;
    private IPresent mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.tv_show);
        mButton = findViewById(R.id.btn_add);

        mPresent = new NumPresenter(this);//初始化一个Present

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresent.add();//交给Present去处理
            }
        });
    }

    @Override
    public void updateUI(String text) {//实现IView接口里面的更新UI的方法
        mTextView.setText(text);
    }
}
