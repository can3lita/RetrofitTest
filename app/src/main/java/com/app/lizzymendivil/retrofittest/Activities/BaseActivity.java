package com.app.lizzymendivil.retrofittest.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.app.lizzymendivil.retrofittest.R;
import com.app.lizzymendivil.retrofittest.Utils.Constants;

/**
 * Created by Lizzy Mendivil on 3/5/2018.
 */

public class BaseActivity extends AppCompatActivity implements Constants {
    private ProgressDialog progressDialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

   /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }*/

    protected void loadProgress(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);
    }

    protected void showToast(int resIdMessage){
        showToast(getResources().getString(resIdMessage));
    }

    protected void  showToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    protected void showLoadingDialog(){
        if (progressDialog != null){
            progressDialog.show();
        } else {
            loadProgress();
            progressDialog.show();
        }
    }

    protected void closeLoadingDialog(){
        if (progressDialog == null)
            return;

        progressDialog.dismiss();
    }

    public void loadFragment(Fragment fragment, @IdRes int containerView) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(containerView, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }
}
