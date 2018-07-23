package com.mobilityrocks.databinding_android.Utilities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kaopiz.kprogresshud.KProgressHUD;

public class Utils {

    private static KProgressHUD pDialog;


    private static Utils sInstance;

    public static Utils getInstance() {
        if (sInstance == null) {
            sInstance = new Utils();
        }
        return sInstance;
    }

    public  boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    // Showing the status in Snackbar
    public void showSnack(boolean isConnected,View container) {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.parseColor("#006400");
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.RED;
        }
        Snackbar snackbar = Snackbar
                .make(container, message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        sbView.setBackgroundColor(color);
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    public void pDialogShow(Activity context) {
        pDialog = KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setBackgroundColor(Color.parseColor("#04F7F5F5"))
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.6f)
                .show();
    }

    public void pDilaogHide() {
        pDialog.dismiss();
    }


}
