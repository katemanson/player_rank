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
        assertEquals("Joe Johnson", testList.get(0).getFullName());
        assertEquals("Stephen Curry", testList.get(1).getFullName());
        assertEquals("Hassan Whiteside", testList.get(2).getFullName());
        testGame.orderAthletesByPoints(testList);
        assertEquals(3, testList.size());
        assertEquals("Joe Johnson", testList.get(0).getFullName());
        assertEquals("Hassan Whiteside", testList.get(1).getFullName());
        assertEquals("Stephen Curry", testList.get(2).getFullName());
    }

    @Test
    public void canGetRounds() {
        assertEquals(0, testGame.getRounds().size());
    }

    @Test
    public void canSetUpNewRound() {
        testGame.newRound(3);
        assertEquals(1, testGame.getRounds().size());
        assertEquals(1, testGame.getRounds().get(0).getRoundNumber());
        assertEquals(3, testGame.getRounds().get(0).getQuestionAthletes().size());
    }

    @Test
    public void correctAnswerRecordedInRounds() {
        Round testRound = new Round(12, testList, 1);
        testGame.addRound(testRound);
        assertEquals(1, testGame.getRounds().size());
        assertEquals(12, testGame.getRounds().get(0).getRoundNumber());
        assertEquals(3, testGame.getRounds().get(0).getQuestionAthletes().size());
        assertEquals(1, testGame.getRounds().get(0).getAnswerAthleteId());
        assertEquals(false, testGame.getRounds().get(0).getWhetherGuessCorrect());
        testRound.checkAnswer(-39);
        assertEquals(false, testGame.getRounds().get(0).getWhetherGuessCorrect());
        testRound.checkAnswer(1);
        assertEquals(true, testGame.getRounds().get(0).getWhetherGuessCorrect());
    }
}
