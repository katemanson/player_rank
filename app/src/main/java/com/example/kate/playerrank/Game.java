package com.example.kate.playerrank;

import android.util.Log;

import java.util.ArrayList;

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


}
