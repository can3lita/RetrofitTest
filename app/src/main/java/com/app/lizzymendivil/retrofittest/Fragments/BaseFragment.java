package com.app.lizzymendivil.retrofittest.Fragments;

import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.app.lizzymendivil.retrofittest.Utils.Constants;
import com.app.lizzymendivil.retrofittest.R;

/**
 * Created by Lizzy Mendivil on 3/4/2018.
 */

public class BaseFragment extends Fragment implements Constants {

    private ProgressDialog progress;

    protected void loadProgress() {
        progress = new ProgressDialog(getContext());
        progress.setMessage(getResources().getString(R.string.loading));
        progress.setCancelable(false);
    }

    protected void showToast(int resIdMessage) {
        showToast(getResources().getString(resIdMessage));
    }

    protected void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showToastError() {
        Toast.makeText(getContext(), R.string.default_error, Toast.LENGTH_LONG).show();
    }

    protected void showLoadingDialog(){
        if (progress != null){
            progress.show();
        } else {
            loadProgress();
            progress.show();
        }
    }

    protected void closeLoadingDialog() {
        if (progress == null)
            return;

        progress.dismiss();
    }

}
