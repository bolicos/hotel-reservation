package com.analuciabolico.hotelreservation.models;

import com.analuciabolico.hotelreservation.enums.HotelEnum;
import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;

public class Fee {
    private HotelEnum hotelEnum;
    private Double feeValue;
    private TypeCustomerEnum typeCustomerEnum;

    public Fee(HotelEnum hotelEnum, Double feeValue, TypeCustomerEnum typeCustomerEnum) {
        this.hotelEnum = hotelEnum;
        this.feeValue = feeValue;
        this.typeCustomerEnum = typeCustomerEnum;
    }

    public HotelEnum getHotelEnum() {
        return hotelEnum;
    }

    public Double getFeeValue() {
        return feeValue;
    }

    public TypeCustomerEnum getTypeCustomerEnum() {
        return typeCustomerEnum;
    }
}
