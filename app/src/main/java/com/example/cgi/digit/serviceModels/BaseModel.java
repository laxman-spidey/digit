package com.example.cgi.digit.serviceModels;

import android.content.Context;

/**
 * Created by laxman on 03-09-2017.
 */

public abstract class BaseModel {
    public Context context;
    public BaseModel(Context context)
    {
        setContext(context);
    }
    public interface OnResponseReceivedListener
    {
        void onResponseReceived(Object object);
        void onError(Object object);
    }

    public static OnResponseReceivedListener getDummyResponseReceivedListener() {
        return new OnResponseReceivedListener() {
            @Override
            public void onResponseReceived(Object object) {

            }

            @Override
            public void onError(Object object) {

            }
        };
    }
    public Context getContext()
    {
        if (context == null)
        {
            throw new RuntimeException("Context is null, send context before getting it.");
        }
        return context;
    }
    public void setContext(Context context)
    {
        this.context = context;
    }
}