package com.analuciabolico.hotelreservation.enums;

public enum HotelEnum {
    LAKEWOOD("Lakewood", 3),
    BRIDGWOOD("Bridgewood", 4),
    RIDGEWOOD("Ridgewood", 5);

    private String name;
    private Integer rating;

    HotelEnum(String name, Integer rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Integer getRating() {
        return rating;
    }
}
