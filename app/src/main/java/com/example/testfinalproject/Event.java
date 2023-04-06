package com.example.testfinalproject;

import androidx.annotation.NonNull;

import java.io.Serializable;


public class Event {
    private String valNameOfTheCompetition;
    private String valDistance;
    private String valСategory;
    private String valResult;

    public Event(String valNameOfTheCompetition, String valDistance, String valСategory, String valResult) {
        this.valNameOfTheCompetition = valNameOfTheCompetition;
        this.valDistance = valDistance;
        this.valСategory = valСategory;
        this.valResult = valResult;
    }

    public String getValNameOfTheCompetition() {
        return valNameOfTheCompetition;
    }

    public String getValDistance() {
        return valDistance;
    }

    public String getValСategory() {
        return valСategory;
    }

    public String getValResult() {
        return valResult;
    }

    public void setValNameOfTheCompetition(String valNameOfTheCompetition) {
        this.valNameOfTheCompetition = valNameOfTheCompetition;
    }

    public void setValDistance(String valDistance) {
        this.valDistance = valDistance;
    }

    public void setValСategory(String valСategory) {
        this.valСategory = valСategory;
    }

    public void setValResult(String valResult) {
        this.valResult = valResult;
    }
//    @NonNull
//    @Override
//    public String toString() {
//        return "NameOfTheCompetition: " + valNameOfTheCompetition
//                + "\n" + "Distance: " + valDistance
//                + "\n" +"valСategory"+ valСategory
//                + "\n" +"valResult"+ valResult;
//    }
}