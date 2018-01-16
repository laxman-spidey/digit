package com.example.cgi.digit.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.cgi.digit.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import kotlinx.android.synthetic.main.content_signin.*


class SigninActivity : AppCompatActivity() {

    private val TAG: String = "SigninActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
//        setSupportActionBar(toolbar)

        //set dummy data
        inputEmail.setText("mittu.thefire@gmail.com")
        inputPassword.setText("password")

        buttonSignin.setOnClickListener({ view ->
            createUser(inputEmail.text.toString(), inputPassword.text.toString())
            ProgressDialog.show(getContext())
        })
    }

    private var mAuth: FirebaseAuth? = null
    override fun onStart() {
        super.onStart()
        mAuth = FirebaseAuth.getInstance()
    }

    fun validate() {

    }

    fun createUser(email: String, password: String) {
        mAuth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, { task ->
                    if (task.isSuccessful) {
                        ProgressDialog.hide(getContext())
                        val user = mAuth!!.currentUser
                        startActivity(Intent(this,HomeActivity::class.java))
                        Toast.makeText(getContext(), "login success", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.i(TAG, task.exception.toString())
                        if (task.exception is FirebaseAuthUserCollisionException) {
                            signin(email, password)
                        } else {
                            Toast.makeText(getContext(), "login failed", Toast.LENGTH_SHORT).show()
                        }

                    }

                    // ...
                })
    }

    fun signin(email: String, password: String) {
        Log.i(TAG, "Singing in")
        mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, { task ->
                    ProgressDialog.hide(getContext())
                    if (task.isSuccessful) {
                        val user = mAuth!!.currentUser
                        openNextActivity()
                        Toast.makeText(getContext(), "login success", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(getContext(), "login failed", Toast.LENGTH_SHORT).show()

                    }
                })
    }

    fun askForName() {

    }

    fun openNextActivity() {
        startActivity(Intent(this,HomeActivity::class.java))
    }

    fun getContext(): Context {
        return this
    }


}
