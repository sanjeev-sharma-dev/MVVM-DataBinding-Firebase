package com.mobilityrocks.databinding_android.pojos;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mobilityrocks.databinding_android.intefaces.LoginCallbacks;

import org.w3c.dom.Text;

public class Login extends BaseObservable {

    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyChange();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyChange();
    }

    public boolean isEmailEmpty(){
        return TextUtils.isEmpty(getEmail());
    }

    public boolean isPaswordEmpty(){
        return TextUtils.isEmpty(getPassword());
    }


    public void firebaseLoginResponse(final ProgressBar progressBar, final LoginCallbacks loginCallbacks, Activity activity){

        FirebaseAuth  firebaseAuth=FirebaseAuth.getInstance();

        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(getEmail(), getPassword())
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressBar.setVisibility(View.GONE);

                        if (task.isSuccessful()) {

                            loginCallbacks.onLoginSucess("Login Success");

                        }else {

                            loginCallbacks.onLoginFailure(task.getException().getMessage());

                        }
                    }
                });



    }

}
