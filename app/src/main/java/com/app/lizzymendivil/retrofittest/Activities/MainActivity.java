package com.app.lizzymendivil.retrofittest.Activities;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.app.lizzymendivil.retrofittest.Fragments.PostFragment;
import com.app.lizzymendivil.retrofittest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    PostFragment postFragment;
    //@BindView(R.id.recycler_retrofit)
    //FrameLayout fragmentContainer;
    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*ButterKnife.bind(this);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        String name = getIntent().getStringExtra("name");*/

        postFragment = new PostFragment();
        loadFragment(postFragment, R.id.fragment_container);
        //loadFragment(postFragment, R.id.recycler_retrofit); aqui no se si usar el recyvler_retrofit o el fragment container
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    /*@Override
    public void onBackPressed() {
        //TODO: onBack
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Toast.makeText(MainActivity.this, "Boton atras", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
    }*/
}
