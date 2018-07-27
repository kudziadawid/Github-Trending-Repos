package com.kudziadawid.advancedapplication.base;

import android.support.test.InstrumentationRegistry;

public class TestApplication extends MyApplication {

    @Override
    protected ApplicationComponent initComponent() {
        //we need to return dagger application component instead of test dagger application component
        return DaggerTestApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static TestApplicationComponent getComponent() {
        return (TestApplicationComponent)
                ((TestApplication) InstrumentationRegistry.getTargetContext().getApplicationContext()).component;
    }
}
