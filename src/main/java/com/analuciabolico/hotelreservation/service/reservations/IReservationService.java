package com.analuciabolico.hotelreservation.service.reservations;

import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    TypeCustomerEnum getTypeCustomer(String input);
    List<LocalDate> getDates(String input);
}
