package com.kudziadawid.advancedapplication.ui;

import com.kudziadawid.advancedapplication.ui.ScreenNavigator;
import com.kudziadawid.advancedapplication.ui.TestScreenNavigator;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TestNavigationModule {

    @Binds
    abstract ScreenNavigator bindScreenNavigator(TestScreenNavigator screenNavigator);
}
