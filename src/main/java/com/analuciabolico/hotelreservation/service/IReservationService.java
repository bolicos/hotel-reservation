package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    TypeCustomerEnum getTypeCustomer(String input) throws Exception;
    List<LocalDate> getDates(String input) throws ParseException;
}
