package com.mobilityrocks.databinding_android.intefaces;

public interface RegsterCallBacks {

    void onvalidEmail();

    void onEmpyUserName();

    void onEmptyPassword();

    void onConfirmPasswordMatch();

    void onEmptyConfirmPassword();

    void onSucessFullRegistration();

    void onFiledReistration(String result);

    void onNetworkConnectionFailure(boolean isConnected);

}
