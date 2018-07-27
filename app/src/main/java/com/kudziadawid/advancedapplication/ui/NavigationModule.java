package com.kudziadawid.advancedapplication.ui;

import com.kudziadawid.advancedapplication.di.ActivityScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigationModule {

    @Binds
    @ActivityScope
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
