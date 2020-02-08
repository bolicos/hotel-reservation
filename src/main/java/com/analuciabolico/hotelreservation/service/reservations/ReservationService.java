package com.analuciabolico.hotelreservation.service.reservations;

import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import com.analuciabolico.hotelreservation.exception.HotelException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ReservationService implements IReservationService {

    public TypeCustomerEnum getTypeCustomer(String input) {
        try {
            String type = input.substring(0, input.indexOf(":"));
            return TypeCustomerEnum.isTypeCustomer(type);
        } catch (Exception exception) {
            throw new HotelException(exception.getMessage(), exception.getCause());
        }
    }

    public List<LocalDate> getDates(String input) {
        try {
            List<LocalDate> dateList = new ArrayList<>();
            String dates = input.substring(input.indexOf(":") + 1);
            String[] arrayDates;

            arrayDates = (dates.contains(",")) ? dates.split(Pattern.quote(",")) : dates.split(Pattern.quote("|_|"));

            for(String date : arrayDates){
                Date dateConvert = new SimpleDateFormat("ddMMMyyyy").parse(date);
                LocalDate localDate = new java.sql.Date(dateConvert.getTime()).toLocalDate();
                dateList.add(localDate);
            }
            return dateList;
        } catch (Exception exception) {
            throw new HotelException(exception.getMessage(), exception.getCause());
        }


    }
}
