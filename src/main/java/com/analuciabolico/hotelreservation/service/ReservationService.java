package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ReservationService implements IReservationService {
    private  static  final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    public TypeCustomerEnum getTypeCustomer(String input) {
        String type = input.substring(0, input.indexOf(":"));
        return TypeCustomerEnum.isTypeCustomer(type);
    }

    public List<LocalDate> getDates(String input) throws ParseException {
        List<LocalDate> dateList = new ArrayList<>();
        String dates = input.substring(input.indexOf(":") + 1);
        String[] arrayDates = null;

        arrayDates = (dates.contains(",")) ? dates.split(Pattern.quote(",")) : dates.split(Pattern.quote("|_|"));

        for(String date : arrayDates){
            Date dateConvert = new SimpleDateFormat("ddMMMyyyy").parse(date);
            LocalDate localDate = dateConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dateList.add(localDate);
        }
        return dateList;

    }
}
