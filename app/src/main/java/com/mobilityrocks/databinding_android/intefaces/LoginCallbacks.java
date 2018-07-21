package com.mobilityrocks.databinding_android.intefaces;

public interface LoginCallbacks {


    void onNotValidEmail();
    void  onPasswordEmpty();
    void onLoginSucess(String result);
    void onLoginFailure(String result);


}
