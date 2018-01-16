package com.example.cgi.digit.activities;

import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;

import com.example.cgi.digit.R;


/**
 * Created by laxman on 17/2/17.
 */

public class ProgressDialog extends android.app.ProgressDialog {
    private ProgressDialog(Context context) {
        super(context);
    }

    private ProgressDialog(Context context, int theme) {
        super(context, theme);
    }
    private static ProgressDialog progressDialog;

    private static ProgressDialog getSingleton(Context context)
    {
        if(progressDialog != null) {
            return progressDialog;
        }
        else
        {

            progressDialog = new ProgressDialog(context, R.style.ProgressDialog);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            WindowManager.LayoutParams wlmp = progressDialog.getWindow().getAttributes();
            wlmp.gravity = Gravity.CENTER_HORIZONTAL;
            progressDialog.getWindow().setAttributes(wlmp);
            progressDialog.setInverseBackgroundForced(true);
            return progressDialog;
        }

    }
    public static void setProgressVisible(Context context, boolean visible)
    {
        setProgressVisible(context,visible,"Loading..");
    }
    public static void setProgressVisible(Context context, boolean visible, String msg)
    {
        if(visible)
        {
            progressDialog = getSingleton(context);
//            progressDialog.setMessage(msg);
//            progressDialog.setProgressStyle(android.support.v7.appcompat.R.style.);
//            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            progressDialog.show();
//            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            progressDialog.setInverseBackgroundForced(true);
            try {
                progressDialog.show();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            if(progressDialog != null)
            {
                try {
                    progressDialog.hide();
                    progressDialog.dismiss();
                    progressDialog= null;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }

    }
    public static void show(Context context)
    {
        setProgressVisible(context,true,"Loading..");
    }

    public static void show(Context context, String msg)
    {
        setProgressVisible(context,true,msg);
    }


    public static void hideIt()
    {
        if(progressDialog != null)
        {
            setProgressVisible(progressDialog.getContext(),false);
        }
    }
    public static void hide(Context context)
    {
        setProgressVisible(context,false);
    }


}