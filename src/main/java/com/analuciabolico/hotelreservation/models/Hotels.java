package com.analuciabolico.hotelreservation.models;

public class Hotels {
    private String name;
    private int rating;
    private double weekDaysRatesReward;
    private double weekEndRatesReward;
    private double weekDaysRatesRegular;
    private double weekEndRatesRegular;

    public Hotels(String name, int rating, double weekDaysRatesReward, double weekEndRatesReward, double weekDaysRatesRegular, double weekEndRatesRegular) {
        this.name = name;
        this.rating = rating;
        this.weekDaysRatesReward = weekDaysRatesReward;
        this.weekEndRatesReward = weekEndRatesReward;
        this.weekDaysRatesRegular = weekDaysRatesRegular;
        this.weekEndRatesRegular = weekEndRatesRegular;
    }




}
