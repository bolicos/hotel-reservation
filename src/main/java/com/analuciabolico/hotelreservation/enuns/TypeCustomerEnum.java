package com.analuciabolico.hotelreservation.enuns;

public enum TypeCustomerEnum {
    REGULAR("Regular"), REWARD("Reward");

    private String type;

    TypeCustomerEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
