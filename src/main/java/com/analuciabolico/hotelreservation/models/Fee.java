package com.analuciabolico.hotelreservation.models;

public class Fee {
    private Double weekDaysRatesReward;
    private Double weekEndRatesReward;
    private Double weekDaysRatesRegular;
    private Double weekEndRatesRegular;

    public Fee(Double weekDaysRatesReward, Double weekEndRatesReward, Double weekDaysRatesRegular, Double weekEndRatesRegular) {
        this.weekDaysRatesReward = weekDaysRatesReward;
        this.weekEndRatesReward = weekEndRatesReward;
        this.weekDaysRatesRegular = weekDaysRatesRegular;
        this.weekEndRatesRegular = weekEndRatesRegular;
    }
}
