package com.example.cgi.digit.activities;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.cgi.digit.R;
import com.example.cgi.digit.fragments.LoaderDialogFragment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Venu on 10/04/2017.
 */
public class BaseActivity extends AppCompatActivity {

    public BaseActivity mActivity;
    private LoaderDialogFragment mLoader;
    private BroadcastReceiver mLogoutReceiver; // Receiver to close the activity

    boolean isOutPut = false;
    public static boolean isGet = false;
    public boolean isLeadAuditor = false;
    public static boolean isApproved = false;
    public static boolean isEdit = false;
    public static String calcID = "";


    //For Image
    final int SELECT_FILE = 1;
    private File imageFile;
    protected Uri savedpath;
    protected Bitmap bitmap;
    private String timeStamp;
    private boolean isPhotoTaken, isFromGallery;
    private boolean isCropDone = false;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        //registerLogoutBroadCast();
    }

    @Override
    protected void onDestroy() {
        if (mLogoutReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(mLogoutReceiver);
        }
        super.onDestroy();
    }

    //Display loader when every perform long run operation
    protected void showLoader() {
        if (mLoader == null || mLoader.isHidden()) {
            mLoader = new LoaderDialogFragment();
            mLoader.show(getFragmentManager(), LoaderDialogFragment.TAG);
        }
    }

    //hide loader if any loader existed on screen
    protected void hideLoader() {
        if (mLoader != null && !mLoader.isHidden()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        mLoader.dismiss();
                        mLoader = null;
                    }catch (IllegalStateException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * Register the Logout Broadcast receiver. A broadcast is received when
     * clicking on sign-out(in Settings).
     */
  /*  private void registerLogoutBroadCast() {
        // Instantiate a receiver.
        mLogoutReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                finish();
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(CommonUIConstants.ACTION_LOGOUT_BROADCAST);
        LocalBroadcastManager.getInstance(this).registerReceiver(mLogoutReceiver, filter);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void setUpToolbarWithTitle(String title) {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(title);
        mToolbar.setTitleTextAppearance(this, R.style.MyToolbarTitleApperance);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00aef1")));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public Context getContext()
    {
        return this;
    }

}
