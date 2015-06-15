package com.example.activity;

import com.example.BuildConfig;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowSQLiteConnection;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class DeckardActivityTest {

    @Test
    public void testSomething() throws Exception {
       assertTrue(Robolectric.buildActivity(DeckardActivity.class).create().get() != null);
      //  Activity activity = Robolectric.setupActivity(DeckardActivity.class);

       // assertTrue(activity.getTitle().toString().equals("Consult"));
       MainController.getUserDaoInstance(ShadowApplication.getInstance().getApplicationContext());
        MainController.addRecent(1);

    }
    @After
    public void tearDown() {

        //shadowApplication.resetResources();

        ShadowSQLiteConnection.reset();
    }
    @Test
    public void add() throws Exception {
        assertTrue(Robolectric.buildActivity(DeckardActivity.class).create().get() != null);
        //  Activity activity = Robolectric.setupActivity(DeckardActivity.class);

        // assertTrue(activity.getTitle().toString().equals("Consult"));
        MainController.getUserDaoInstance(ShadowApplication.getInstance().getApplicationContext());
        MainController.addRecent(3);

    }


}
