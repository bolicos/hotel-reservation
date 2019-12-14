package com.analuciabolico.hotelreservation.enuns;

import com.analuciabolico.hotelreservation.models.Fee;

public enum HotelEnum {

    LAKEWOOD("Lakewood", 3, new Fee(80.00, 80.00, 110.00, 90.00)),
    BRIDGWOOD("Bridgewood", 4, new Fee(110.00, 50.00, 160.00, 60.00)),
    RIDGEWOOD("Ridgewood", 5, new Fee(110.00, 40.00, 220.00, 150.00));

    private String name;
    private Integer rating;
    private Fee fee;

    HotelEnum(String name, Integer rating, Fee fee) {
        this.name = name;
        this.rating = rating;
        this.fee = fee;
    }
}
