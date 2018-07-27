package com.kudziadawid.advancedapplication.home;

import com.bluelinelabs.conductor.Controller;
import com.kudziadawid.advancedapplication.R;
import com.kudziadawid.advancedapplication.base.BaseActivity;
import com.kudziadawid.advancedapplication.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
