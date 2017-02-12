package com.example.kate.playerrank;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Created by admin on 12/02/2017.
 */

public class AthletesTest {

    Athlete testAthleteOne;
    Athlete testAthleteTwo;
    Athlete testAthleteThree;
    ArrayList<Athlete> testList;

    @Before
    public void before() {
        testAthleteOne = new Athlete(1, "Stephen", "Curry", "Stephen Curry", 47.94303797468354, "https://d17odppiik753x.cloudfront.net/playerimages/nba/9524.png");
        testAthleteTwo = new Athlete(4, "Hassan", "Whiteside", "Hassan Whiteside", 35.75342465753425, "https://d17odppiik753x.cloudfront.net/playerimages/nba/12363.png");
        testAthleteThree = new Athlete(17, "Joe", "Johnson", "Joe Johnson", 22.103703703703705, "https://d17odppiik753x.cloudfront.net/playerimages/nba/9447.png");
        testList = new ArrayList<>();
        testList.add(testAthleteThree);
        testList.add(testAthleteOne);
        testList.add(testAthleteTwo);
    }

    @Test
    public void canInitiateWithEmptyList() {
        Athletes testAthletes = new Athletes();
        assertEquals(0, testAthletes.getCopyList().size());
    }

    @Test
    public void canInitiateWithList() {
        Athletes testAthletes = new Athletes(testList);
        assertEquals(3, testAthletes.getCopyList().size());
    }
}

