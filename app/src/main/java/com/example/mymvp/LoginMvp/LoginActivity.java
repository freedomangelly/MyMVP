package com.example.mymvp.LoginMvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.mymvp.MainActivity;
import com.example.mymvp.R;
import com.example.mymvp.mvvm.LoginViewModel;
import com.example.mymvp.mvvm.LoginViewModelFactory;

/**
 * description:
 * author: freed on 2019/9/14
 * email: 674919909@qq.com
 * version: 1.0
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = findViewById(R.id.progress);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
        presenter = new LoginPresenter(this);
//        viewModel= ViewModelProviders.of(this).get(LoginViewModel.class);
        viewModel= ViewModelProviders.of(this,new LoginViewModelFactory()).get(LoginViewModel.class);
        viewModel.getLoginResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                switch (integer){
                    case 0:
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        break;
                    case 1:
                        username.setError(getString(R.string.username_error));
                        break;
                    case 2:
                        password.setError(getString(R.string.password_error));
                        break;
                    case 3:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        progressBar.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

    public void Login() {
        viewModel.login(username.getText().toString().trim(), password.getText().toString().trim());
//        presenter.login(username.getText().toString().trim(), password.getText().toString().trim());
    }
}
