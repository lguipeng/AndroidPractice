package com.szu.androidpractice.ui.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.szu.androidpractice.ui.BaseActivity;

/**
 * Created by lgp on 2015/4/6.
 */
public abstract class BaseFragment extends Fragment{
    protected BaseActivity activity;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BaseActivity){
            this.activity = ((BaseActivity)activity);
        }
    }

    protected void hideSystemUI(){
        if (activity != null)
            activity.hideSystemUI();
    }

    protected void showSystemUI() {
        if (activity != null)
            activity.showSystemUI();
    }

    public void onSystemBarTintResume(){
        if (activity != null)
            activity.onSystemBarTintResume();
    }
}
