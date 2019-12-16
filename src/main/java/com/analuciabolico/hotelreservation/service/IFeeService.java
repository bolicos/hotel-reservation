package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.HotelEnum;
import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;

import java.time.LocalDate;
import java.util.List;

public interface IFeeService {
    HotelEnum hotel(TypeCustomerEnum typeCustomer, List<LocalDate> dates);
}
