package com.mobilityrocks.databinding_android.viewmodels;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ProgressBar;

import com.mobilityrocks.databinding_android.intefaces.LoginCallbacks;
import com.mobilityrocks.databinding_android.Utilities.Utils;
import com.mobilityrocks.databinding_android.datamodels.Login;

public class LoginViewModel extends BaseObservable {
    Login login;
    LoginCallbacks loginCallbacks;
    Activity activity;
    ProgressBar progressBar;


    public LoginViewModel(LoginCallbacks loginCallbacks, Activity activity, ProgressBar progressBar) {
        login = new Login();
        this.loginCallbacks = loginCallbacks;
        this.activity = activity;
        this.progressBar=progressBar;

    }

    public void firebaseLoginCredentials() {

        if (login.isEmailEmpty()||!Utils.getInstance().isValidEmail(login.getEmail()))

            loginCallbacks.onNotValidEmail();

         else if (login.isPaswordEmpty() || login.getPassword().length() < 6) {

            loginCallbacks.onPasswordEmpty();

        } else {

            login.firebaseLoginResponse(progressBar,loginCallbacks, activity);

        }

    }


    public TextWatcher emailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                login.setEmail(editable.toString());



            }

        };
    }

    public TextWatcher passwordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                login.setPassword(editable.toString());

            }

        };
    }

}
