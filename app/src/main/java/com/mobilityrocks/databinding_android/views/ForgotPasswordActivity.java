package com.mobilityrocks.databinding_android.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mobilityrocks.databinding_android.R;
import com.mobilityrocks.databinding_android.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {
ActivityForgotPasswordBinding activityForgotPasswordBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        activityForgotPasswordBinding= DataBindingUtil.setContentView(this,R.layout.activity_forgot_password);
        activityForgotPasswordBinding.setData(this);


    }

    public void navgatetoLogin(View view){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.exit_animation_enter_from_right,R.anim.exit_animation_leave_to_right);
    }
}
