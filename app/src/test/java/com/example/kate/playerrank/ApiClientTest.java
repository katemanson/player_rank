package com.example.kate.playerrank;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by admin on 12/02/2017.
 */

public class ApiClientTest {

    String urlString;

    @Before
    public void before() {
        urlString = "https://gist.githubusercontent.com/joshheald/d26b89b0fbaf4e26cb423913ada21b83/raw/174a7ac0916919d4ae171adcfc0af78811b185f3/sportspeople.json";
    }

    @Test
    public void canGetJsonString() {
        assertEquals(true, ApiClient.getJsonString(urlString).length() > 0);
    }

    @Test
    public void canGetAthletesObject() {
        assertEquals(20, ApiClient.getAthletes(urlString).getCopyList().size());
    }
}
