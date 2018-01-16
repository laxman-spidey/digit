package com.example.cgi.digit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cgi.digit.R;

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

}
