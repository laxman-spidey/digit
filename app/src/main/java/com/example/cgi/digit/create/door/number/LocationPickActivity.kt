package com.example.cgi.digit.create.door.number

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

import com.example.cgi.digit.R
import com.example.cgi.digit.activities.BaseActivity
import com.example.cgi.digit.activities.HomeActivity
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlacePicker
import kotlinx.android.synthetic.main.activity_location_picker.*

/**
 * Created by Saikrupa on 1/20/2018.
 */

class LocationPickActivity : BaseActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {


    private var PLACE_PICKER_REQUEST = 1
    private var selectedProperty: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_picker)



        spnProp.onItemSelectedListener = this
        btnAddDetails.setOnClickListener(this);

    }


    fun locationPickUp(view: View) {
        val builder = PlacePicker.IntentBuilder()

        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST)
        } catch (e: GooglePlayServicesRepairableException) {
            e.printStackTrace()
        } catch (e: GooglePlayServicesNotAvailableException) {
            e.printStackTrace()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val place = PlacePicker.getPlace(data, this)
                val toastMsg = String.format("Place: %s", place.name)
                // Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
                address.setText(place.address)
            }
        }
    }
    override fun onClick(p0: View?) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        startActivity(Intent(this, FlatsListActivityJava::class.java))



    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {

        selectedProperty = adapterView.selectedItem.toString()
        assignDataToSpinner(selectedProperty)


    }

    private fun assignDataToSpinner(selectedProperty: String?) {


    }

    override fun onNothingSelected(adapterView: AdapterView<*>) {

    }
}
