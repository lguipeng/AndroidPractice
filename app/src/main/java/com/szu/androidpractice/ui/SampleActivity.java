package com.szu.androidpractice.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.szu.androidpractice.R;
import com.szu.androidpractice.ui.fragments.BaseFragment;
import com.szu.androidpractice.ui.fragments.HideToolbarOnScrollFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lgp on 2015/4/6.
 */
public class SampleActivity extends BaseActivity{
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    private BaseFragment mFragment;
    private int mClickPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parseBundle(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ButterKnife.inject(this);
        initToolbar();
        initFragment();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public Toolbar getToolbar() {
        return toolbar;
    }

    private void initToolbar(){
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(getColor(android.R.color.white));
    }

    private void parseBundle(Bundle bundle){
        if (bundle != null){
            mClickPosition = bundle.getInt(MainActivity.ITEM_CLICK_KEY);
        }
    }

    private void initFragment(){
        switch (mClickPosition){
            case 0:
                mFragment = HideToolbarOnScrollFragment.newInstance(null);
                break;
            default:
                break;
        }
        if (mFragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, mFragment).commit();
        }
    }
}
