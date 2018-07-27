package com.kudziadawid.advancedapplication.test;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

import com.kudziadawid.advancedapplication.base.TestApplication;
import com.kudziadawid.advancedapplication.data.RepoRepository;
import com.kudziadawid.advancedapplication.data.TestRepoService;
import com.kudziadawid.advancedapplication.ui.TestScreenNavigator;

public class ControllerTestRule<T extends Activity> extends ActivityTestRule<T> {

    public final TestScreenNavigator screenNavigator;
    public final TestRepoService repoService;
    public final RepoRepository repoRepository;

    public ControllerTestRule(Class<T> activityClass) {
        super(activityClass, true, false);
        screenNavigator = TestApplication.getComponent().screenNavigator();
        repoService = TestApplication.getComponent().repoService();
        repoRepository = TestApplication.getComponent().repoRepository();
    }

    public void clearState() {
        repoService.clearErrorFlags();
        repoService.clearHoldFlags();
        repoRepository.clearCache();
    }
}
