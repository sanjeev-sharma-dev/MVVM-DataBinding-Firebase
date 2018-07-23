package com.mobilityrocks.databinding_android.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mobilityrocks.databinding_android.R;
import com.mobilityrocks.databinding_android.databinding.ActivityStartupBinding;

import java.io.File;
import java.io.IOException;

public class StartupActivity extends AppCompatActivity {



   ActivityStartupBinding activityStartupBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activityStartupBinding= DataBindingUtil.setContentView(this,R.layout.activity_startup);
       activityStartupBinding.setData(this);




    }

    public void login(View view){
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void register(View view){
        startActivity(new Intent(this,RegisterActivity.class));
    }





  /*  private static boolean isRooted() {
        return findBinary("su");
    }



    public static boolean findBinary(String binaryName) {
        boolean found = false;
        if (!found) {
            String[] places = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/",
                    "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (String where : places) {
                if ( new File( where + binaryName ).exists() ) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }*/


}
