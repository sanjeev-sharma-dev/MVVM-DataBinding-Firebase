package com.mobilityrocks.databinding_android.datamodels;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobilityrocks.databinding_android.Utilities.Constants;
import com.mobilityrocks.databinding_android.Utilities.Utils;
import com.mobilityrocks.databinding_android.intefaces.RegsterCallBacks;

import java.util.HashMap;
import java.util.Map;

public class Register extends BaseObservable {
    String email;
    String username;
    String password;
    String confirm_password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyChange();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyChange();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyChange();
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
        notifyChange();
    }


    public boolean isEmailEmpty(){
        return TextUtils.isEmpty(getEmail());
    }

    public boolean isPaswordEmpty(){
        return TextUtils.isEmpty(getPassword());
    }

    public boolean isUsernameEmpty(){
        return TextUtils.isEmpty(getUsername());
    }

    public boolean isConfirmPasswordEmpty(){
        return TextUtils.isEmpty(getConfirm_password());
    }

    public boolean isPasswordMatch(){
        if (getPassword().equals(getConfirm_password())){
            return false;
        }
        return true;
    }

    public void firebaseRegisterResponse(final RegsterCallBacks regsterCallBacks, Activity activity) {

        if (Utils.getInstance().isNetworkConnected(activity)) {
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

            Utils.getInstance().pDialogShow(activity);
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                   Utils.getInstance().pDilaogHide();

                    if (task.isSuccessful()) {


                        Map<String, String> map = new HashMap<String, String>();
                        map.put(Constants.EMAIL, email);
                        map.put(Constants.USERNAME, username);

                        databaseReference.child(task.getResult().getUser().getUid()).setValue(map);

                        regsterCallBacks.onSucessFullRegistration();


                    } else {

                        regsterCallBacks.onFiledReistration(task.getException().getMessage());

                    }
                }
            });


        }else{
              regsterCallBacks.onNetworkConnectionFailure(false);
        }
    }

}
