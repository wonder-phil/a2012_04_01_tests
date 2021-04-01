package me.pgb.a2021_03_29a_uitesting;

import android.app.Activity;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
            scenario.moveToState(Lifecycle.State.DESTROYED);    // Moves the activity state to State.RESUMED.
            scenario.onActivity(activity -> {
                assertEquals("myButton not null", activity.myButton, null);
            });
        }
    }

    @Test
    public void testActivty_3() {
        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                Button myButton = activity.findViewById(R.id.basic_button);
                myButton.performClick();

                
                // Check the Logcat...
            });
        }
    }

    @Test
    public void testActivty_4() {
        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.moveToState(Lifecycle.State.RESUMED);    // Moves the activity state to State.RESUMED.
            scenario.onActivity(activity -> {
                //onView(withId(R.id.basic_button)).perform(click());
                scenario.getResult();
            });
        }
    }
}