package com.example.kate.playerrank;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

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
        testGame.newRound();
        assertEquals(1, testGame.getRounds().size());
        assertEquals(1, testGame.getRounds().get(0).getRoundNumber());
        assertEquals(2, testGame.getRounds().get(0).getQuestionAthletes().size());
    }

    @Test
    public void canGetLatestRound() {
        testGame.newRound();
        testGame.newRound();
        testGame.newRound();
        assertEquals(3, testGame.getLatestRound().getRoundNumber());
        assertEquals(2, testGame.getLatestRound().getQuestionAthletes().size());
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

    @Test
    public void canGetPercentCorrect() {
        Round testRoundOne = new Round(12, testList, 1);
        Round testRoundTwo = new Round(13, testList, 1);
        Round testRoundThree = new Round(14, testList, 1);
        testGame.addRound(testRoundOne);
        testGame.addRound(testRoundTwo);
        testGame.addRound(testRoundThree);
        testRoundOne.checkAnswer(1);
        testRoundTwo.checkAnswer(15);
        testRoundThree.checkAnswer(1);
        assertEquals(66, testGame.percentCorrect());
    }

    @Test
    public void numberOfPlayersIncreasesWithPercentCorrect() {
        Round testRoundOne = new Round(12, testList, 1);
        Round testRoundTwo = new Round(13, testList, 1);
        Round testRoundThree = new Round(14, testList, 1);
        Round testRoundFour = new Round(15, testList, 1);
        Round testRoundFive = new Round(16, testList, 1);
        testRoundOne.checkAnswer(1);
        testRoundTwo.checkAnswer(1);
        testRoundThree.checkAnswer(1);
        testRoundFour.checkAnswer(1);
        testRoundFive.checkAnswer(12);
        testGame.addRound(testRoundOne);
        testGame.addRound(testRoundTwo);
        testGame.addRound(testRoundThree);
        testGame.addRound(testRoundFour);
        testGame.addRound(testRoundFive);
        assertEquals(5, testGame.countRounds());
        testGame.newRound();
        Round roundSix = testGame.getLatestRound();
        assertEquals(6, roundSix.getRoundNumber());
        assertEquals(2, roundSix.getQuestionAthletes().size());
        roundSix.checkAnswer(12);
        testGame.newRound();
        Round roundSeven = testGame.getLatestRound();
        assertEquals(7, roundSeven.getRoundNumber());
        assertEquals(3, roundSeven.getQuestionAthletes().size());
        testRoundFive.checkAnswer(1);
        testGame.newRound();
        Round roundEight = testGame.getLatestRound();
        assertEquals(8, roundEight.getRoundNumber());
        assertEquals(4, roundEight.getQuestionAthletes().size());
    }

    @Test
    public void canGetResults() {
        Round testRoundOne = new Round(12, testList, 1);
        Round testRoundTwo = new Round(13, testList, 1);
        Round testRoundThree = new Round(14, testList, 1);
        Round testRoundFour = new Round(15, testList, 1);
        Round testRoundFive = new Round(16, testList, 1);
        Round testRoundSix = new Round(17, testList, 1);
        testRoundOne.checkAnswer(1);
        testRoundTwo.checkAnswer(12);
        testRoundThree.checkAnswer(1);
        testRoundFour.checkAnswer(1);
        testRoundFive.checkAnswer(12);
        testRoundSix.checkAnswer(1);
        testGame.addRound(testRoundOne);
        testGame.addRound(testRoundTwo);
        testGame.addRound(testRoundThree);
        testGame.addRound(testRoundFour);
        testGame.addRound(testRoundFive);
        testGame.addRound(testRoundSix);
        HashMap<String, Integer> results = testGame.getResults();
        assertEquals(6, (int) results.get("number of rounds"));
        assertEquals(4, (int) results.get("number correct"));
        assertEquals(66, (int) results.get("percentage correct"));
    }
}
