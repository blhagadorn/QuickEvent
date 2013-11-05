package com.redhammerstudios.quickevent;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Bryant on 11/5/13.
 */
public class Toaster {

    public void makeToast(Context context, String toasttext){
        Toast t = new Toast(context);
        t.setText(toasttext);
        t.setDuration(3);
        t.show();
    }
    public void makeTimedToast(Context context, String toasttext, int seconds){
        Toast t = new Toast(context);
        t.setText(toasttext);
        t.setDuration(seconds);
        t.show();
    }
}