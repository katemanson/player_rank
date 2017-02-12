package com.example.kate.playerrank;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by admin on 12/02/2017.
 */

public class GameTest {

    Game testGame;
    Athlete testAthleteOne;
    Athlete testAthleteTwo;
    Athlete testAthleteThree;
    ArrayList<Athlete> testList;

    @Before
    public void before() {
        testGame = new Game();
        testAthleteOne = new Athlete(1, "Stephen", "Curry", "Stephen Curry", 47.94303797468354, "https://d17odppiik753x.cloudfront.net/playerimages/nba/9524.png");
        testAthleteTwo = new Athlete(4, "Hassan", "Whiteside", "Hassan Whiteside", 35.75342465753425, "https://d17odppiik753x.cloudfront.net/playerimages/nba/12363.png");
        testAthleteThree = new Athlete(17, "Joe", "Johnson", "Joe Johnson", 22.103703703703705, "https://d17odppiik753x.cloudfront.net/playerimages/nba/9447.png");
        testList = new ArrayList<>();
        testList.add(testAthleteThree);
        testList.add(testAthleteOne);
        testList.add(testAthleteTwo);
    }

    @Test
    public void canGetCopyAthletes() {
        assertEquals(20, testGame.getCopyAthletes().size());
    }

    @Test
    public void canGetQuestionAthletes() {
        assertEquals(3, testGame.getQuestionAthletes(3).size());
    }

    @Test
    public void canOrderAthletesByPoints() {
        testGame.orderAthletesByPoints(testList);
        assertEquals(3, testList.size());
        assertEquals("Joe Johnson", testList.get(0).getFullName());
        assertEquals("Hassan Whiteside", testList.get(1).getFullName());
        assertEquals("Stephen Curry", testList.get(2).getFullName());
    }
}
