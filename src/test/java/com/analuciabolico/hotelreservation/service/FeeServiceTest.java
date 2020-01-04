package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.HotelEnum;
import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import com.analuciabolico.hotelreservation.service.fees.FeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FeeServiceTest {

    @InjectMocks
    FeeService feeService;

    private List<LocalDate> dates = new ArrayList<>();
    private List<LocalDate> datesEndsWeek = new ArrayList<>();
    private List<LocalDate> datesStarHotel = new ArrayList<>();
    private TypeCustomerEnum regular = TypeCustomerEnum.REGULAR;
    private TypeCustomerEnum reward = TypeCustomerEnum.REWARD;

    @BeforeEach
    void setup() {
        dates.add(LocalDate.of(2019, 12, 16));
        dates.add(LocalDate.of(2019, 12, 17));

        datesEndsWeek.add(LocalDate.of(2019, 12, 15));
        datesEndsWeek.add(LocalDate.of(2019, 12, 14));
        datesEndsWeek.add(LocalDate.of(2019, 12, 13));

        datesStarHotel.add(LocalDate.of(2019, 12, 14));
        datesStarHotel.add(LocalDate.of(2019, 12, 13));
        datesStarHotel.add(LocalDate.of(2019, 12, 12));

    }

    @Test
    void hotelTest() {
        HotelEnum hotel = feeService.hotel(regular, dates);
        assertEquals(HotelEnum.LAKEWOOD, hotel);
    }

    @Test
    void calculateLowestPriceTest() {
        HotelEnum hotel = feeService.hotel(regular, dates);
        assertEquals(HotelEnum.LAKEWOOD, hotel);
    }

    @Test
    void calculateLowestPriceEndsWeekTest() {
        HotelEnum hotel = feeService.hotel(regular, datesEndsWeek);
        assertEquals(HotelEnum.BRIDGWOOD, hotel);
    }

    @Test
    void calculateLowestPriceStarHotelTest() {
        HotelEnum hotel = feeService.hotel(reward, datesStarHotel);
        assertEquals(HotelEnum.RIDGEWOOD, hotel);
    }
}
