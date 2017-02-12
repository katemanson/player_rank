package com.example.kate.playerrank;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by admin on 12/02/2017.
 */

public class GameTest {

    Game testGame;

    @Before
    public void before() {
        testGame = new Game();
    }

    @Test
    public void canGetAthletes() {
        assertEquals(20, testGame.getCopyAthletes().size());
    }
}
