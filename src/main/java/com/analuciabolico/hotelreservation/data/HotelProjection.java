package com.analuciabolico.hotelreservation.data;

import com.analuciabolico.hotelreservation.models.Hotels;

import java.util.ArrayList;
import java.util.List;

public class HotelProjection {
    Hotels hotelLakewood = new Hotels("Lakewood", 3, 80.00, 80.00, 110.00, 90.00);
    Hotels hotelBridgewood = new Hotels("Bridgewood", 4, 110.00, 50.00, 160.00, 60.00);
    Hotels hotelRidgewood = new Hotels("Ridgewood", 5, 110.00, 40.00, 220.00, 150.00);

    private List<Hotels> hotels = new ArrayList<>();

    public List<Hotels> getHotels() {
        hotels.add(hotelLakewood);
        hotels.add(hotelBridgewood);
        hotels.add(hotelRidgewood);
        return hotels;
    }
}
