package me.pgb.a2021_03_29a_uitesting;

import android.os.Bundle;
import android.os.Parcel;

import org.junit.Test;

import me.pgb.a2021_03_29a_uitesting.models.RadioStation;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests_RadioStation {

    @Test
    public void radioStationTest0() {
        String linkInput = "http://example.com/abc";
        String nameInput = "Good music";
        RadioStation radioStation = new RadioStation(linkInput,nameInput);

        assertEquals("Name equal test",radioStation.getName(), nameInput);
        assertEquals("streamlink equal test", radioStation.getStreamLink(), linkInput);
    }

    @Test
    public void radioStationParcelTest_0() {
        String linkInput = "http://example.com/abc";
        String nameInput = "Good music";
        RadioStation radioStation_0 = new RadioStation(linkInput,nameInput);
        RadioStation radioStation_1 = null;

        try {
            radioStation_1 = (RadioStation) radioStation_0.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        assertEquals("Radio stations have same names", radioStation_0.getName(), radioStation_1.getName());
        assertNotEquals("Radio station objects differ", radioStation_0, radioStation_1);
    }

    @Test
    public void failingTest() {
        assertEquals("hello", "hello");
    }
}