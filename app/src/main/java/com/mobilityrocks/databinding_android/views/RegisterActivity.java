package com.mobilityrocks.databinding_android.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mobilityrocks.databinding_android.R;
import com.mobilityrocks.databinding_android.Utilities.Utils;
import com.mobilityrocks.databinding_android.databinding.ActivityRegisterBinding;
import com.mobilityrocks.databinding_android.intefaces.RegsterCallBacks;
import com.mobilityrocks.databinding_android.viewmodels.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity implements RegsterCallBacks {

    ActivityRegisterBinding activityRegisterBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        activityRegisterBinding.setRegisterViewModel(new RegisterViewModel(this, this));
        activityRegisterBinding.toolbar.setTitle("Create Account");
        activityRegisterBinding.toolbar.setNavigationIcon(R.drawable.ic_back_white);
        setSupportActionBar(activityRegisterBinding.toolbar);
        activityRegisterBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.exit_animation_enter_from_right, R.anim.exit_animation_leave_to_right);
    }

    @Override
    public void onvalidEmail() {
        activityRegisterBinding.inputLayoutEmail.setError("You must be enter Valid email");
    }

    @Override
    public void onEmpyUserName() {
        activityRegisterBinding.inputLayoutUsername.setError("You must be enter Username");
    }

    @Override
    public void onEmptyPassword() {
        activityRegisterBinding.inputLayoutPassword.setError("You must be enter Password");
    }

    @Override
    public void onConfirmPasswordMatch() {
        activityRegisterBinding.inputLayoutConfirmPassword.setError("Your Password doesn't match");
    }

    @Override
    public void onEmptyConfirmPassword() {
        activityRegisterBinding.inputLayoutConfirmPassword.setError("You must be enter valid confirm password");
    }

    @Override
    public void onSucessFullRegistration() {

        overridePendingTransition(R.anim.animation_enter_from_right, R.anim.animation_leave_out_to_left);
        startActivity(new Intent(this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        finish();

    }

    @Override
    public void onFiledReistration(String result) {
        activityRegisterBinding.errorMessageTV.setText(result);
    }

    @Override
    public void onNetworkConnectionFailure(boolean isConnected) {
        Utils.getInstance().showSnack(isConnected,activityRegisterBinding.container);
    }

    public void navigateToLoginScreen(View view){
       onBackPressed();
    }
}
