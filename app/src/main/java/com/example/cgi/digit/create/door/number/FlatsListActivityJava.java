package com.example.cgi.digit.create.door.number;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cgi.digit.R;
import com.example.cgi.digit.activities.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saikrupa on 1/21/2018.
 */

public class FlatsListActivityJava extends BaseActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    TextView textView;
    List<HouseDetailsModel> list;
    FlatsListAdapterJava adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_recyclarview_activity);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        fab=(FloatingActionButton)findViewById(R.id.fab);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addItemDecoration(new DividerItemDecoration());
        //setUpToolbarWithTitle("Flats List");
        list=new ArrayList<>();
        for(int i=0;i<10;i++){
            HouseDetailsModel singleData=new HouseDetailsModel();
            singleData.setHouseNumber(i+"");
            list.add(singleData);
        }
        fab.setOnClickListener(this);
        adapter=new FlatsListAdapterJava(list,FlatsListActivityJava.this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
