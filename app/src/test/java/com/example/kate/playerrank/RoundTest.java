package com.example.kate.playerrank;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by admin on 12/02/2017.
 */

public class RoundTest {

    Athlete testAthleteOne;
    Athlete testAthleteTwo;
    Athlete testAthleteThree;
    ArrayList<Athlete> testList;
    Round testRound;

    @Before
    public void before() {
        testAthleteOne = new Athlete(1, "Stephen", "Curry", "Stephen Curry", 47.94303797468354, "https://d17odppiik753x.cloudfront.net/playerimages/nba/9524.png");
        testAthleteTwo = new Athlete(4, "Hassan", "Whiteside", "Hassan Whiteside", 35.75342465753425, "https://d17odppiik753x.cloudfront.net/playerimages/nba/12363.png");
        testAthleteThree = new Athlete(17, "Joe", "Johnson", "Joe Johnson", 22.103703703703705, "https://d17odppiik753x.cloudfront.net/playerimages/nba/9447.png");
        testList = new ArrayList<>();
        testList.add(testAthleteThree);
        testList.add(testAthleteOne);
        testList.add(testAthleteTwo);
        testRound = new Round(6, testList, 1);
    }

    @Test
    public void canGetRoundNumber() {
        assertEquals(6, testRound.getRoundNumber());
    }

    @Test
    public void canGetQuestionAthletes() {
        assertEquals(3, testRound.getQuestionAthletes().size());
    }

    @Test
    public void canGetAnswerAthleteId() {
        assertEquals(1, testRound.getAnswerAthleteId());
    }

    @Test
    public void canGetWhetherGuessCorrect() {
        assertEquals(false, testRound.getWhetherGuessCorrect());
    }

    @Test
    public void canSetWhetherGuessCorrect() {
        testRound.setWhetherGuessCorrect(true);
        assertEquals(true, testRound.getWhetherGuessCorrect());
        testRound.setWhetherGuessCorrect(false);
        assertEquals(false, testRound.getWhetherGuessCorrect());
    }

    @Test
    public void canCheckAnswer() {
        assertEquals(false, testRound.checkAnswer(17));
        assertEquals(false, testRound.getWhetherGuessCorrect());
        assertEquals(false, testRound.checkAnswer(4));
        assertEquals(false, testRound.getWhetherGuessCorrect());
        assertEquals(false, testRound.checkAnswer(12));
        assertEquals(false, testRound.getWhetherGuessCorrect());
        assertEquals(false, testRound.checkAnswer(-12));
        assertEquals(false, testRound.getWhetherGuessCorrect());
        assertEquals(true, testRound.checkAnswer(1));
        assertEquals(true, testRound.getWhetherGuessCorrect());
    }

}
