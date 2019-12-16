package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.HotelEnum;
import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {

    @InjectMocks
    HotelService hotelService;
    @Mock
    IFeeService iFeeService;
    @Mock
    IReservationService iReservationService;

    String input;
    String inputInvalid;
    String inputParseThrow;
    List<LocalDate> dates = new ArrayList<>();

    @BeforeEach
    public void setup() {
        input = "Regular: 16Dez2019(mon), 17Dez2019(tues)";
        inputInvalid = "Regular - 16Dez2019(mon), 17Dez2019(tues)";
        inputParseThrow = "Regular: EEDez2019(mon)";
        dates.add(LocalDate.of(2019, 12, 16));
        dates.add(LocalDate.of(2019, 12, 17));
    }

    @Test
    public void getResultsTest() throws Exception {
        doReturn(TypeCustomerEnum.REGULAR).when(iReservationService).getTypeCustomer(input);
        doReturn(dates).when(iReservationService).getDates(input);
        when(iFeeService.hotel(TypeCustomerEnum.REGULAR, dates)).thenReturn(HotelEnum.LAKEWOOD);

        String response = hotelService.getResults(input);

        assertEquals("Lakewood", response);
    }

    @Test
    public void getResultsInvalidTest() throws Exception {
        String response = hotelService.getResults(inputInvalid);

        assertEquals("Invalid Input", response);
    }

    @Test
    public void getResultsThrowParseTest() throws Exception {
        ParseException parseException = mock(ParseException.class);
        String response = "Unparseable date: " + inputParseThrow.substring(inputParseThrow.indexOf(":"), inputParseThrow.indexOf("("));

        doReturn(TypeCustomerEnum.REGULAR).when(iReservationService).getTypeCustomer(inputParseThrow);
        doThrow(parseException).when(iReservationService).getDates(inputParseThrow);
        doReturn(response).when(parseException).getMessage();

        assertEquals(response, hotelService.getResults(inputParseThrow));
    }
}
