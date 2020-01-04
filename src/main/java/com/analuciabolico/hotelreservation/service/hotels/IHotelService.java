package com.analuciabolico.hotelreservation.service.hotels;

import com.analuciabolico.hotelreservation.exception.HotelException;

public interface IHotelService {
    String getResults(String input) throws HotelException;
}
