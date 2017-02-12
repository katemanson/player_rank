package com.example.kate.playerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12/02/2017.
 */

public class Round {

    private int roundNumber;
    private List<Athlete> questionAthletes;
    private int answerAthleteId;
    private boolean guessCorrect;

    public Round(int roundNumber, ArrayList<Athlete> questionAthletes, int answerAthleteId) {
        this.roundNumber = roundNumber;
        this.questionAthletes = questionAthletes;
        this.answerAthleteId = answerAthleteId;
        this.guessCorrect = false;
    }

    public int getRoundNumber() {
        return this.roundNumber;
    }

    public ArrayList<Athlete> getQuestionAthletes() {
        return new ArrayList<>(this.questionAthletes);
    }

    public int getAnswerAthleteId() {
        return answerAthleteId;
    }

    public boolean getWhetherGuessCorrect() {
        return guessCorrect;
    }

    public void setWhetherGuessCorrect(boolean trueOrFalse) {
        this.guessCorrect = trueOrFalse;
    }

    public boolean checkAnswer(int answer) {
        if (answer == getAnswerAthleteId()) {
            setWhetherGuessCorrect(true);
            return true;
        }
        else return false;
    }
}
