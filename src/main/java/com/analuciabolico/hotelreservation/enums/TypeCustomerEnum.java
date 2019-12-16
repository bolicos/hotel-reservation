package com.analuciabolico.hotelreservation.enums;

public enum TypeCustomerEnum {
    REGULAR("Regular"), REWARD("Rewards");

    private String type;

    TypeCustomerEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static TypeCustomerEnum isTypeCustomer(String type) {
        for (TypeCustomerEnum typeCustomerEnum: values()) {
            if (typeCustomerEnum.type.equals(type)) return typeCustomerEnum;
        }
        if (type.isBlank()) type = null;
        throw new IllegalArgumentException("\nError:\nType of customer not exists -> " + type);
    }
}
