package com.mobilityrocks.databinding_android.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
       mActivityLoginBindng.inputLayoutEmail.setError("You need to enter valid email");
        mActivityLoginBindng.failedMessageTV.setText("");
    }

    @Override
    public void onPasswordEmpty() {
        mActivityLoginBindng.inputLayoutPassword.setError("You need to enter valid password");
        mActivityLoginBindng.failedMessageTV.setText("");
    }

    @Override
    public void onLoginSucess(String result) {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
        mActivityLoginBindng.inputLayoutEmail.setError(null);
        mActivityLoginBindng.inputLayoutPassword.setError(null);
        mActivityLoginBindng.failedMessageTV.setText("");
    }

    @Override
    public void onLoginFailure(String result) {
        mActivityLoginBindng.inputLayoutEmail.setError(null);
        mActivityLoginBindng.inputLayoutPassword.setError(null);
        mActivityLoginBindng.failedMessageTV.setText(result);
        mActivityLoginBindng.inputEmail.setText("");
        mActivityLoginBindng.inputPassword.setText("");



    }

    public void navigateToRegisterScreen(View view){
        overridePendingTransition(R.anim.animation_enter_from_right,R.anim.animation_leave_out_to_left);
        startActivity(new Intent(this,RegisterActivity.class));
    }




}
