package com.kudziadawid.advancedapplication.details;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.bluelinelabs.conductor.Controller;
import com.kudziadawid.advancedapplication.R;
import com.kudziadawid.advancedapplication.data.TestRepoService;
import com.kudziadawid.advancedapplication.test.ControllerTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RepoDetailsControllerTest extends ControllerTest {

    @Before
    public void setUp() {
        testRule.clearState();
    }

    @Test
    public void repoDetailsSuccess() {
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyName("RxJava")
                .verifyDescription("RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.")
                .verifyCreatedDate("sty 08, 2013")
                .verifyUpdatedDate("paź 06, 2017");
    }

    @Test
    public void repoDetailsError() {
        repoService.setErrorFlags(TestRepoService.FLAG_GET_REPO);
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContentVisibility(ViewMatchers.Visibility.GONE)
                .verifyErrorText(R.string.api_error_single_repo);
    }

    @Test
    public void contributorsSuccess() {
        launch();
        RepoDetailsRobot.init()
                .verifyContributorsLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorsErrorVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorShown("benjchristensen");
    }

    @Test
    public void contributorsError() {
        repoService.setErrorFlags(TestRepoService.FLAG_GET_CONTRIBUTORS);
        launch();
        RepoDetailsRobot.init()
                .verifyContributorsLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorsErrorText(R.string.api_error_contributors);
    }

    @Test
    public void repoSuccessContributorsError() {
        repoService.setErrorFlags(TestRepoService.FLAG_GET_CONTRIBUTORS);
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorsLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorsErrorText(R.string.api_error_contributors)
                .verifyErrorVisibility(ViewMatchers.Visibility.GONE);
    }

    @Test
    public void loadingRepo() {
        repoService.setHoldFlags(TestRepoService.FLAG_GET_REPO);
        launch();
        RepoDetailsRobot.init().verifyLoadingVisibility(ViewMatchers.Visibility.VISIBLE);
    }

    @Override
    protected Controller controllerToLaunch() {
        return RepoDetailsController.newInstance("ReactiveX", "RxJava");
    }
}
