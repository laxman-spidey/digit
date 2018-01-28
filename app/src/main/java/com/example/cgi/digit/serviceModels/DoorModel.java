package com.example.cgi.digit.serviceModels;

import android.content.Context;

import com.example.cgi.digit.models.House;

/**
 * Created by laxman on 28/01/18.
 */

public abstract class DoorModel extends BaseModel {
    public Context context;

    public DoorModel(Context context) {
        super(context);
    }

    public static DoorModel getInstance(Context context) {
        return new com.example.cgi.digit.firebaseModels.DoorModel(context);
    }

    public abstract void insert(House house, OnResponseReceivedListener listener);
}
