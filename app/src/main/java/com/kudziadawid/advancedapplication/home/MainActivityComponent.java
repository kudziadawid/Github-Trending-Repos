package com.kudziadawid.advancedapplication.home;

import com.kudziadawid.advancedapplication.di.ActivityScope;
import com.kudziadawid.advancedapplication.ui.ActivityViewInterceptor;
import com.kudziadawid.advancedapplication.ui.ActivityViewInterceptorModule;
import com.kudziadawid.advancedapplication.ui.NavigationModule;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class,
        ActivityViewInterceptorModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

        @Override
        public void seedInstance(MainActivity instance) {   //overrides seedinstance method to avoid memory leak

        }
    }
}
