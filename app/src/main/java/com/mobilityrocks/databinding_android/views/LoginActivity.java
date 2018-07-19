package com.mobilityrocks.databinding_android.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mobilityrocks.databinding_android.intefaces.LoginCallbacks;
import com.mobilityrocks.databinding_android.R;
import com.mobilityrocks.databinding_android.databinding.ActivityLoginBinding;
import com.mobilityrocks.databinding_android.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements LoginCallbacks {

    ActivityLoginBinding mActivityLoginBindng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityLoginBindng= DataBindingUtil.setContentView(this, R.layout.activity_login);
        mActivityLoginBindng.setLoginViewModel(new LoginViewModel(this,this,mActivityLoginBindng.progress));


    }


    @Override
    public void onNotValidEmail() {
        Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordEmpty() {
        Toast.makeText(this, "Please enter valid password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSucess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }


}
