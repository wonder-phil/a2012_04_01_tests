package me.pgb.a2021_03_29a_uitesting;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import me.pgb.a2021_03_29a_uitesting.models.RadioStation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTests_0 {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("me.pgb.a2021_03_29a_uitesting", appContext.getPackageName());
    }

    @Test
    public void parsableRadioStation_0() {
        String linkInput = "http://example.com/abc";
        String nameInput = "Good music";
        RadioStation radioStation_0 = new RadioStation(linkInput,nameInput);

        Bundle bundle_0 = new Bundle();
        bundle_0.putParcelable("myFavRadioStation", radioStation_0);

        Parcel parcel = Parcel.obtain();
        bundle_0.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        Bundle bundle_1 = parcel.readBundle();
        bundle_1.setClassLoader(RadioStation.class.getClassLoader());
        RadioStation radioStation_1 = bundle_1.getParcelable("myFavRadioStation");

        //Check that objects are not same and test that objects are equal
        assertFalse("Bundles the same", bundle_0 == bundle_1);
        assertFalse("RadioStations Not the same", radioStation_0 == radioStation_1);
    }

    @Test
    public void radioStationParcelTest_0() {
        String linkInput = "http://example.com/abc";
        String nameInput = "Good music";
        RadioStation radioStation_0 = new RadioStation(linkInput,nameInput);

        Bundle bundle_0 = new Bundle();
        bundle_0.putParcelable("myFavRadioStation", radioStation_0);

        Parcel parcel = Parcel.obtain();
        bundle_0.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        Bundle bundle_1 = parcel.readBundle();
        bundle_1.setClassLoader(RadioStation.class.getClassLoader());
        RadioStation radioStation_1 = bundle_1.getParcelable("myFavRadioStation");

        assertEquals("Radio stations have same names", radioStation_0.getName(), radioStation_1.getName());
    }

    @Test
    public void buttonTest() {
        onView(withId(R.id.basic_button)).perform(click());
    }


}