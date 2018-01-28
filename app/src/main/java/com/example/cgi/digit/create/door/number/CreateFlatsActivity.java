package com.example.cgi.digit.create.door.number;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cgi.digit.R;
import com.example.cgi.digit.activities.BaseActivity;
import com.example.cgi.digit.models.House;
import com.example.cgi.digit.serviceModels.BaseModel;
import com.example.cgi.digit.serviceModels.DoorModel;

/**
 * Created by Saikrupa on 1/28/2018.
 */

public class CreateFlatsActivity extends BaseActivity {


    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_flats);
        button = findViewById(R.id.btnCreateDoorNumber);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddButtonClicked();
            }
        });
    }

    protected void onAddButtonClicked()
    {
        DoorModel.getInstance(getContext()).insert(House.getDummyHouse(), new BaseModel.OnResponseReceivedListener() {
            @Override
            public void onResponseReceived(Object object) {
                Toast.makeText(getContext(), "inserted successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Object object) {
                Toast.makeText(getContext(), "failed to insert", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
