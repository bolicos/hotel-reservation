package com.analuciabolico.hotelreservation.models;

import com.analuciabolico.hotelreservation.enums.HotelEnum;
import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;

public class Fee {
    private HotelEnum hotelEnum;
    private Double fee;
    private TypeCustomerEnum typeCustomerEnum;

    public Fee(HotelEnum hotelEnum, Double fee, TypeCustomerEnum typeCustomerEnum) {
        this.hotelEnum = hotelEnum;
        this.fee = fee;
        this.typeCustomerEnum = typeCustomerEnum;
    }

    public HotelEnum getHotelEnum() {
        return hotelEnum;
    }

    public Double getFee() {
        return fee;
    }

    public TypeCustomerEnum getTypeCustomerEnum() {
        return typeCustomerEnum;
    }
}
