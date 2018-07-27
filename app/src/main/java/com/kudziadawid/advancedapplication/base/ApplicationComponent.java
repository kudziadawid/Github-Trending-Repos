package com.kudziadawid.advancedapplication.base;

import com.kudziadawid.advancedapplication.data.RepoServiceModule;
import com.kudziadawid.advancedapplication.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class,
})

public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
