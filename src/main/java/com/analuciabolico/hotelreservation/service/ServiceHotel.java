package com.analuciabolico.hotelreservation.service;

import java.util.ArrayList;
import java.util.List;

public class ServiceHotel {

    public String response(String input) {
        if(input.contains(":") && input.contains(",")) {
            List<String> response = transformString(input);
            String dates = checkDates(input);
            return checkHotel(input);
        }
        return "Invalid Input";
    }

    private List<String> transformString(String input) {
        String typeCustomer = input.substring(0, input.indexOf(":"));
        String dates = input.substring(input.indexOf(":") + 1);
        List list = new ArrayList<String>();
        boolean iterator = false;

        list.add(typeCustomer);
        while (iterator) {

        }

        return list;

    }

    private String checkHotel(String input) {
        return null;
    }

    private String checkDates(String input) {
        return null;
    }
}
