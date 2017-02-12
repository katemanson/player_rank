package com.example.kate.playerrank;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12/02/2017.
 */

public class Athletes {

    @SerializedName("sportspeople")
    private List<Athlete> list;

    public Athletes() {
        list = new ArrayList<>();
    }

    public Athletes(ArrayList<Athlete> athletes) {
        list = new ArrayList<>(athletes);
    }

    public ArrayList<Athlete> getCopyList() {
        return new ArrayList<>(this.list);
    }

}
