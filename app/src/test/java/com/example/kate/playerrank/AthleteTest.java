package com.example.kate.playerrank;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by admin on 12/02/2017.
 */

public class AthleteTest {

    Athlete testAthlete;

    @Before
    public void before() {
        testAthlete = new Athlete(20, "Test", "Athlete", "Test Athlete", 38.9604938271605, "http://www.testaddress.com");
    }

    @Test
    public void canGetId() {
        assertEquals(20, testAthlete.getId());
    }

    @Test
    public void canGetFirstName() {
        assertEquals("Test", testAthlete.getFirstName());
    }

    @Test
    public void canGetLastName() {
        assertEquals("Athlete", testAthlete.getLastName());
    }

    @Test
    public void canGetFullName() {
        assertEquals("Test Athlete", testAthlete.getFullName());
    }

    @Test
    public void canGetPoints() {
        assertEquals(38.9604938271605, testAthlete.getPoints(), 0.0000000000001);
    }

    @Test
    public void canGetPicUrl() {
        assertEquals("http://www.testaddress.com", testAthlete.getPicUrl());
    }
}
