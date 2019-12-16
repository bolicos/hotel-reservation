package com.analuciabolico.hotelreservation.service;

import com.analuciabolico.hotelreservation.enums.HotelEnum;
import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
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
public class FeeServiceTest {

    @InjectMocks
    FeeService feeService;

    List<LocalDate> dates = new ArrayList<>();
    List<LocalDate> datesEndsWeek = new ArrayList<>();
    List<LocalDate> datesStarHotel = new ArrayList<>();
    TypeCustomerEnum regular = TypeCustomerEnum.REGULAR;
    TypeCustomerEnum reward = TypeCustomerEnum.REWARD;

    @BeforeEach
    public void setup() {
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
    public void hotelTest() {
        HotelEnum hotel = feeService.hotel(regular, dates);
        assertEquals(HotelEnum.LAKEWOOD, hotel);
    }

    @Test
    public void calculateLowestPriceTest() {
        HotelEnum hotel = feeService.hotel(regular, dates);
        assertEquals(HotelEnum.LAKEWOOD, hotel);
    }

    @Test
    public void calculateLowestPriceEndsWeekTest() {
        HotelEnum hotel = feeService.hotel(regular, datesEndsWeek);
        assertEquals(HotelEnum.BRIDGWOOD, hotel);
    }

    @Test
    public void calculateLowestPriceStarHotelTest() {
        HotelEnum hotel = feeService.hotel(reward, datesStarHotel);
        assertEquals(HotelEnum.RIDGEWOOD, hotel);
    }
}
