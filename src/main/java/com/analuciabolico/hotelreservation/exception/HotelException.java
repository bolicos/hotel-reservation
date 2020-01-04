package com.analuciabolico.hotelreservation.exception;

public class HotelException extends RuntimeException {
    static final long serialVersionUID = -2322333333245766939L;

    public HotelException(String message, Throwable cause) {
        super(message, cause);
    }
}
