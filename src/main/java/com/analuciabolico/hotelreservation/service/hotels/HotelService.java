package com.analuciabolico.hotelreservation.service.hotels;

import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import com.analuciabolico.hotelreservation.service.fees.IFeeService;
import com.analuciabolico.hotelreservation.service.reservations.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelService implements IHotelService {
    private IFeeService feeService;
    private IReservationService reservationService;

    @Autowired
    public HotelService(IFeeService feeService, IReservationService reservationService) {
        this.feeService = feeService;
        this.reservationService = reservationService;
    }

    public String getResults(String input) {
        try {
            if(input.contains(":")) {
                TypeCustomerEnum typeCustomer = this.reservationService.getTypeCustomer(input);
                List<LocalDate> dates = this.reservationService.getDates(input);
                return this.feeService.hotel(typeCustomer, dates).getName();
            }
            return "Invalid Input";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }
}
