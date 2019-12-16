package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Service
public class HotelService implements IHotelService {
    IFeeService feeService;
    IReservationService reservationService;

    @Autowired
    public HotelService(IFeeService feeService, IReservationService reservationService) {
        this.feeService = feeService;
        this.reservationService = reservationService;
    }

    public String getResults(String input) throws Exception {
        try {
            if(input.contains(":") && input.contains(",")) {
                TypeCustomerEnum typeCustomer = this.reservationService.getTypeCustomer(input);
                List<LocalDate> dates = this.reservationService.getDates(input);
                return this.feeService.hotel(typeCustomer, dates).getName();
            }
            return "Invalid Input";
        } catch (ParseException | IllegalArgumentException exception) {
            return exception.getMessage();
        }
    }


}
