package com.example.kate.playerrank;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 12/02/2017.
 */

public class Athlete implements Comparable<Athlete> {

    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("full_name")
    private String fullName;
    private double points;
    @SerializedName("profile_picture_url")
    private String picUrl;

    public Athlete(int id, String firstName, String lastName, String fullName, double points, String picUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.points = points;
        this.picUrl = picUrl;
    }

    public int getId() { return this.id; }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public double getPoints() {
        return this.points;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int compareTo(Athlete anotherAthlete) {
        double pointsDiff = this.getPoints() - anotherAthlete.getPoints();
        if (pointsDiff > 0) return 1;
        if (pointsDiff < 0) return -1;
        else return 0;
    }
}
