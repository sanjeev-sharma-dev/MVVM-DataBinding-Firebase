package com.mobilityrocks.databinding_android.viewmodels;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ProgressBar;

import com.mobilityrocks.databinding_android.Utilities.Utils;
import com.mobilityrocks.databinding_android.datamodels.Login;
import com.mobilityrocks.databinding_android.datamodels.Register;
import com.mobilityrocks.databinding_android.intefaces.LoginCallbacks;
import com.mobilityrocks.databinding_android.intefaces.RegsterCallBacks;

public class RegisterViewModel extends BaseObservable {

    Register register;
    RegsterCallBacks regsterCallBacks;
    Activity activity;

    public RegisterViewModel(RegsterCallBacks regsterCallBacks,Activity activity) {
        register = new Register();
        this.regsterCallBacks=regsterCallBacks;
        this.activity=activity;

    }

    public void firebaseRegisterCredentials(){
        if (register.isEmailEmpty()||!Utils.getInstance().isValidEmail(register.getEmail())) {
            regsterCallBacks.onvalidEmail();
        }else if (register.isUsernameEmpty()){
            regsterCallBacks.onEmpyUserName();
        }else if (register.isPaswordEmpty()||register.getPassword().length()<6){
            regsterCallBacks.onEmptyPassword();
        }else if (register.isConfirmPasswordEmpty()){
            regsterCallBacks.onEmptyConfirmPassword();
        }else if (register.isPasswordMatch()){
           regsterCallBacks.onConfirmPasswordMatch();
        }else{
           register.firebaseRegisterResponse(regsterCallBacks,activity);
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

                register.setEmail(editable.toString());



            }

        };
    }

    public TextWatcher usernameTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                register.setUsername(editable.toString());



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

                register.setPassword(editable.toString());



            }

        };
    }
    public TextWatcher confirmPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                register.setConfirm_password(editable.toString());



            }

        };
    }

}
