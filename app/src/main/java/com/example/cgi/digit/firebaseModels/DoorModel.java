package com.example.cgi.digit.firebaseModels;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.cgi.digit.models.House;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by laxman on 28/01/18.
 */

public class DoorModel extends com.example.cgi.digit.serviceModels.DoorModel {
    public DoorModel(Context context) {
        super(context);
    }

    @Override
    public void insert(House house, final OnResponseReceivedListener listener) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().push();
        reference.setValue(house).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    listener.onResponseReceived(null);
                } else {
                    listener.onError(null);
                }
            }
        });
    }


}
