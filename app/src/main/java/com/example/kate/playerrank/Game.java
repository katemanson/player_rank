package com.example.kate.playerrank;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by admin on 12/02/2017.
 */

public class Game {

    private Athletes athletes;

    private static final String URL_STRING = "https://gist.githubusercontent.com/joshheald/d26b89b0fbaf4e26cb423913ada21b83/raw/174a7ac0916919d4ae171adcfc0af78811b185f3/sportspeople.json";

    public Game() {
        this.athletes = ApiClient.getAthletesObject(URL_STRING);
    }

    public ArrayList<Athlete> getCopyAthletes() {
        return this.athletes.getCopyList();
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
            System.out.println("questionAthletes: " + questionAthletes.size());
            System.out.println("athletePool: " + athletePool.size());
        }

        return questionAthletes;
    }

    public ArrayList<Athlete> orderAthletesByPoints(ArrayList<Athlete> athleteList) {
        Collections.sort(athleteList);
        return athleteList;
    }


}
