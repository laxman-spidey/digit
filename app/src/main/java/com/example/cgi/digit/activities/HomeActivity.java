package com.example.cgi.digit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cgi.digit.R;
import com.example.cgi.digit.create.door.number.LocationPickActivity;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

/**
 * Created by balapuram on 1/16/2018.
 */

public class HomeActivity extends BaseActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void search(View view){
        Intent intent=new Intent(this,MapViewActivity.class);
        startActivity(intent);
    }

    public void createDoorNumber(View view){
        Intent intent=new Intent(getApplicationContext(), LocationPickActivity.class);
        startActivity(intent);

    }


}
