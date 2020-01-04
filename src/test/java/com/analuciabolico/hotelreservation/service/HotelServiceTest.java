package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.HotelEnum;
import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import com.analuciabolico.hotelreservation.exception.HotelException;
import com.analuciabolico.hotelreservation.service.fees.IFeeService;
import com.analuciabolico.hotelreservation.service.hotels.HotelService;
import com.analuciabolico.hotelreservation.service.reservations.IReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class HotelServiceTest {

    @InjectMocks
    HotelService hotelService;
    @Mock
    IFeeService iFeeService;
    @Mock
    IReservationService iReservationService;

    private String input;
    private String inputInvalid;
    private String inputParseThrow;
    private List<LocalDate> dates = new ArrayList<>();

    @BeforeEach
    void setup() {
        input = "Regular: 16Dez2019(mon), 17Dez2019(tues)";
        inputInvalid = "Regular - 16Dez2019(mon), 17Dez2019(tues)";
        inputParseThrow = "Regular: EEDez2019(mon)";
        dates.add(LocalDate.of(2019, 12, 16));
        dates.add(LocalDate.of(2019, 12, 17));
    }

    @Test
    void getResultsTest() throws Exception {
        doReturn(TypeCustomerEnum.REGULAR).when(iReservationService).getTypeCustomer(input);
        doReturn(dates).when(iReservationService).getDates(input);
        when(iFeeService.hotel(TypeCustomerEnum.REGULAR, dates)).thenReturn(HotelEnum.LAKEWOOD);

        String response = hotelService.getResults(input);

        assertEquals("Lakewood", response);
    }

    @Test
    void getResultsInvalidTest() throws Exception {
        String response = hotelService.getResults(inputInvalid);

        assertEquals("Invalid Input", response);
    }

    @Test
    void getResultsThrowParseTest() throws Exception {
        HotelException parseException = mock(HotelException.class);
        String response = "Unparseable date: " + inputParseThrow.substring(inputParseThrow.indexOf(":"), inputParseThrow.indexOf("("));

        doReturn(TypeCustomerEnum.REGULAR).when(iReservationService).getTypeCustomer(inputParseThrow);
        doThrow(parseException).when(iReservationService).getDates(inputParseThrow);
        doReturn(response).when(parseException).getMessage();

        assertEquals(response, hotelService.getResults(inputParseThrow));
    }
}
