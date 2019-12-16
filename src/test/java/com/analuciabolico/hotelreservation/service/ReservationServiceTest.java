package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @InjectMocks
    ReservationService reservationService;

    String input;
    String inputSingularDate;
    String inputIllegal;
    String inputParse;
    List<LocalDate> dates = new ArrayList<>();
    List<LocalDate> date = new ArrayList<>();

    @BeforeEach
    public void setup() {
        input = "Regular: 16Dez2019(mon), 17Dez2019(tues)";
        inputSingularDate = "Regular: 16Dez2019(mon)";
        inputIllegal = "Illegal: 16Dez2019(mon), 17Dez2019(tues)";
        inputParse = "Regular: 16Dez2019(mon), 17Dec2019(tues)";
        dates.add(LocalDate.of(2019, 12, 16));
        dates.add(LocalDate.of(2019, 12, 17));
        date.add(LocalDate.of(2019, 12, 16));
    }

    @Test
    public void getTypeCustomerTest() {
        TypeCustomerEnum response = reservationService.getTypeCustomer(input);
        assertEquals(TypeCustomerEnum.REGULAR, response);
    }

    @Test
    public void getTypeCustomerThrowIllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            reservationService.getTypeCustomer(inputIllegal);
        });
    }

    @Test
    public void getDatesTest() throws ParseException {
        List<LocalDate> response = reservationService.getDates(input);
        assertEquals(dates, response);
    }

    @Test
    public void getDatesSigularDateTest() throws ParseException {
        List<LocalDate> response = reservationService.getDates(inputSingularDate);
        assertEquals(date, response);
    }

    @Test
    public void getDateThrowParseExceptionTest() {
        assertThrows(ParseException.class, () -> {
            reservationService.getDates(inputParse);
        });
    }

}
