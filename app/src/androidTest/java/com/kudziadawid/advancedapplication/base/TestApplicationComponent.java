package com.kudziadawid.advancedapplication.base;

import com.kudziadawid.advancedapplication.data.RepoRepository;
import com.kudziadawid.advancedapplication.data.TestRepoService;
import com.kudziadawid.advancedapplication.data.TestRepoServiceModule;
import com.kudziadawid.advancedapplication.networking.ServiceModule;
import com.kudziadawid.advancedapplication.ui.TestActivityViewInterceptorModule;
import com.kudziadawid.advancedapplication.ui.TestNavigationModule;
import com.kudziadawid.advancedapplication.trending.TrendingReposControllerTest;
import com.kudziadawid.advancedapplication.ui.TestScreenNavigator;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        TestNavigationModule.class,
        TestActivityViewInterceptorModule.class,
})
public interface TestApplicationComponent extends ApplicationComponent {

    void inject(TrendingReposControllerTest trendingReposControllerTest);

    TestScreenNavigator screenNavigator();

    TestRepoService repoService();

    RepoRepository repoRepository();
}
