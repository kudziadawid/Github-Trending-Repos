package com.kudziadawid.advancedapplication.home;

import com.bluelinelabs.conductor.Controller;
import com.kudziadawid.advancedapplication.data.TrendingReposResponse;
import com.kudziadawid.advancedapplication.details.RepoDetailsComponent;
import com.kudziadawid.advancedapplication.details.RepoDetailsController;
import com.kudziadawid.advancedapplication.di.ControllerKey;
import com.kudziadawid.advancedapplication.trending.TrendingReposComponent;
import com.kudziadawid.advancedapplication.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingReposComponent.class,
        RepoDetailsComponent.class,
})
public abstract class TestScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(RepoDetailsController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindRepoDetailsInjector(RepoDetailsComponent.Builder builder);

}
