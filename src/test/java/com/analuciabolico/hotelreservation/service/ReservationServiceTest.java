package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import com.analuciabolico.hotelreservation.exception.HotelException;
import com.analuciabolico.hotelreservation.service.reservations.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @InjectMocks
    ReservationService reservationService;

    private String input;
    private String inputSingularDate;
    private String inputIllegal;
    private String inputParse;
    private List<LocalDate> dates = new ArrayList<>();
    private List<LocalDate> date = new ArrayList<>();

    @BeforeEach
    void setup() {
        input = "Regular: 16Dez2019(mon), 17Dez2019(tues)";
        inputSingularDate = "Regular: 16Dez2019(mon)";
        inputIllegal = "Illegal: 16Dez2019(mon), 17Dez2019(tues)";
        inputParse = "Regular: 16Dez2019(mon), 17Dec2019(tues)";
        dates.add(LocalDate.of(2019, 12, 16));
        dates.add(LocalDate.of(2019, 12, 17));
        date.add(LocalDate.of(2019, 12, 16));
    }

    @Test
    @DisplayName("test capture type customer enum of input ")
    void getTypeCustomerTest() {
        TypeCustomerEnum response = reservationService.getTypeCustomer(input);
        assertEquals(TypeCustomerEnum.REGULAR, response);
    }

    @Test
    @DisplayName("input illegal case test")
    void getTypeCustomerThrowIllegalArgumentExceptionTest() throws HotelException {
        try {
            HotelException exception = assertThrows(HotelException.class, () -> {
                reservationService.getTypeCustomer(inputIllegal);
            });
            assertNull(exception.getCause());
        } catch (Exception exception) {
            exception.getMessage();
        }

    }

    @Test
    @DisplayName("input normal case test")
    void getDatesTest() {
        List<LocalDate> response = new ArrayList<>(reservationService.getDates(input));
        assertIterableEquals(dates, response);
    }

    @Test
    @DisplayName("input singular date test")
    void getDatesSingularDateTest() {
        List<LocalDate> response = new ArrayList<>(reservationService.getDates(inputSingularDate));
        assertIterableEquals(date, response);
    }

    @Test
    @DisplayName("launch exception on input invalid")
    void getDateThrowParseExceptionTest() throws HotelException {
        try {
            HotelException exception = assertThrows(HotelException.class, () -> {
                reservationService.getDates(inputParse);
            });
            assertNull(exception.getCause());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

}
