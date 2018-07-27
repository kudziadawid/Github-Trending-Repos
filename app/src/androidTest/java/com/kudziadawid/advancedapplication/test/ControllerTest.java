package com.kudziadawid.advancedapplication.test;

import android.content.Intent;

import com.bluelinelabs.conductor.Controller;
import com.kudziadawid.advancedapplication.data.RepoRepository;
import com.kudziadawid.advancedapplication.data.TestRepoService;
import com.kudziadawid.advancedapplication.home.MainActivity;
import com.kudziadawid.advancedapplication.ui.TestScreenNavigator;

import org.junit.Rule;

public abstract class ControllerTest {

    @Rule
    public ControllerTestRule<MainActivity> testRule = new ControllerTestRule<>(MainActivity.class);

    protected TestRepoService repoService = testRule.repoService;
    protected RepoRepository repoRepository = testRule.repoRepository;
    protected TestScreenNavigator screenNavigator = testRule.screenNavigator;

    public ControllerTest() {
        screenNavigator.overrideInitialController(controllerToLaunch());
    }

    protected abstract Controller controllerToLaunch();

    protected void launch() {
        launch(null);
    }

    protected void launch(Intent intent) {
        testRule.launchActivity(intent);
    }
}