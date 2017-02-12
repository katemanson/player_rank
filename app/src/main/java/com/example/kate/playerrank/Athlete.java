package com.example.kate.playerrank;

/**
 * Created by admin on 12/02/2017.
 */

public class Athlete {

    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private double points;
    private String picUrl;

    public Athlete(int id, String firstName, String lastName, String fullName, double points, String picUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.points = points;
        this.picUrl = picUrl;
    }

    public int getId() {
        return this.id;
    }

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
}
