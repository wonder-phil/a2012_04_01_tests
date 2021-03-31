package me.pgb.a2021_03_29a_uitesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;


@RunWith(AndroidJUnit4.class)
public class InstrumentedTests_1 {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testActivity_0() {
        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                assertNotEquals("good button text", activity.getButtonText(),"Not a button");
            });
        }
    }

    @Test
    public void testActivity_1() {
        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.moveToState(Lifecycle.State.RESUMED);    // Moves the activity state to State.RESUMED.
            scenario.onActivity(activity -> {
                assertNotEquals("myButton not null", activity.myButton, null);
            });
        }
    }

    @Test
    public void testActivity_2() {
        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.moveToState(Lifecycle.State.CREATED);    // Moves the activity state to State.RESUMED.
            scenario.onActivity(activity -> {
                assertEquals("myButton not null", activity.myButton, null);
            });
        }
    }

}