package com.example.kate.playerrank;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 12/02/2017.
 */

public class Game {

    private Athletes athletes;
    private List<Round> rounds;

    private static final String URL_STRING = "https://gist.githubusercontent.com/joshheald/d26b89b0fbaf4e26cb423913ada21b83/raw/174a7ac0916919d4ae171adcfc0af78811b185f3/sportspeople.json";

    public Game() {
        this.athletes = ApiClient.getAthletesObject(URL_STRING);
        this.rounds = new ArrayList<>();
    }
    public ArrayList<Athlete> getCopyAthletes() {
        return this.athletes.getCopyList();
    }

    public ArrayList<Round> getRounds() {
        return new ArrayList<>(this.rounds);
    }

    public void addRound(Round newRound) {
        this.rounds.add(newRound);
    }

    public int getRandomAthleteIndex(ArrayList<Athlete> athleteList) {
        Random randomThing = new Random();
        int listSize = athleteList.size();
        int index = randomThing.nextInt(listSize);
        return index;
    }

    public Athlete removeRandomAthlete(ArrayList<Athlete> athleteList) {
        return athleteList.remove(getRandomAthleteIndex(athleteList));
    }

    public ArrayList<Athlete> getQuestionAthletes(int numberOfAthletes) {
        ArrayList<Athlete> questionAthletes = new ArrayList<>();
        ArrayList<Athlete> athletePool = getCopyAthletes();

        for (int i = 0; i < numberOfAthletes; i++) {
            Athlete questionAthlete = removeRandomAthlete(athletePool);
            questionAthletes.add(questionAthlete);
        }

        return questionAthletes;
    }

    public ArrayList<Athlete> orderAthletesByPoints(ArrayList<Athlete> athleteList) {
        Collections.sort(athleteList);
        return athleteList;
    }

    public void newRound(int numberOfAthletes) {
        ArrayList<Athlete> questionAthletes = getQuestionAthletes(numberOfAthletes);

        ArrayList<Athlete> copyQuestion = new ArrayList<>(questionAthletes);
        Collections.sort(copyQuestion);
        int answerAthleteId = copyQuestion.get(copyQuestion.size() - 1).getId();

        int newRoundNumber = this.rounds.size() + 1;

        Round newRound = new Round(newRoundNumber, questionAthletes, answerAthleteId);
        addRound(newRound);
        System.out.println("Round: " + newRound.getRoundNumber());
        System.out.println("First athlete: " + newRound.getQuestionAthletes().get(0).getFullName() + " " + newRound.getQuestionAthletes().get(0).getPoints());
        System.out.println("Second athlete: " + newRound.getQuestionAthletes().get(1).getFullName() + " "  + newRound.getQuestionAthletes().get(1).getPoints());
        System.out.println("Third athlete: " + newRound.getQuestionAthletes().get(2).getFullName() + " "  + newRound.getQuestionAthletes().get(2).getPoints());
        System.out.println("Answer id: " + newRound.getAnswerAthleteId());
        System.out.println("Guess correct: " + newRound.getWhetherGuessCorrect());
    }


}
