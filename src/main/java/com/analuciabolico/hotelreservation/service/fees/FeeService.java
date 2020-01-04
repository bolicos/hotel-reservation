package com.analuciabolico.hotelreservation.service.fees;

import com.analuciabolico.hotelreservation.enums.HotelEnum;
import com.analuciabolico.hotelreservation.enums.TypeCustomerEnum;
import com.analuciabolico.hotelreservation.models.Fee;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FeeService implements IFeeService {

    private static final List<Fee> weekDays = Arrays.asList(
            new Fee(HotelEnum.LAKEWOOD, 110.00, TypeCustomerEnum.REGULAR),
            new Fee(HotelEnum.LAKEWOOD, 80.00, TypeCustomerEnum.REWARD),
            new Fee(HotelEnum.BRIDGWOOD, 160.00, TypeCustomerEnum.REGULAR),
            new Fee(HotelEnum.BRIDGWOOD, 110.00, TypeCustomerEnum.REWARD),
            new Fee(HotelEnum.RIDGEWOOD, 220.00, TypeCustomerEnum.REGULAR),
            new Fee(HotelEnum.RIDGEWOOD, 100.00, TypeCustomerEnum.REWARD)
    );
    private static final List<Fee> weekEnds = Arrays.asList(
            new Fee(HotelEnum.LAKEWOOD, 90.00, TypeCustomerEnum.REGULAR),
            new Fee(HotelEnum.LAKEWOOD, 80.00, TypeCustomerEnum.REWARD),
            new Fee(HotelEnum.BRIDGWOOD, 60.00, TypeCustomerEnum.REGULAR),
            new Fee(HotelEnum.BRIDGWOOD, 50.00, TypeCustomerEnum.REWARD),
            new Fee(HotelEnum.RIDGEWOOD, 150.00, TypeCustomerEnum.REGULAR),
            new Fee(HotelEnum.RIDGEWOOD, 40.00, TypeCustomerEnum.REWARD)
    );

    public HotelEnum hotel(TypeCustomerEnum typeCustomer, List<LocalDate> dates) {
        Map<HotelEnum, Double> hotelInfoDayWeek = new EnumMap<>(HotelEnum.class);
        Map<HotelEnum, Double> hotelInfoEndWeek = new EnumMap<>(HotelEnum.class);
        List<Integer> days = feeWeek(dates);
        Predicate<Fee> type = fee -> fee.getTypeCustomerEnum().getType().equalsIgnoreCase(typeCustomer.getType());
        List<Fee> dayOfWeek = weekDays.stream().filter(type).collect(Collectors.toList());
        List<Fee> endOfWeek = weekEnds.stream().filter(type).collect(Collectors.toList());
        dayOfWeek.forEach(fee -> hotelInfoDayWeek.put(fee.getHotelEnum(), (fee.getFeeValue() * days.get(0) )));
        endOfWeek.forEach(fee -> hotelInfoEndWeek.put(fee.getHotelEnum(), (fee.getFeeValue() * days.get(1) )));
        return calculateLowestPrice(hotelInfoDayWeek, hotelInfoEndWeek);
    }

    private HotelEnum calculateLowestPrice(Map<HotelEnum, Double> hotelInfoDayWeek, Map<HotelEnum, Double> hotelInfoEndWeek) {
        hotelInfoDayWeek.forEach(
                (key, value) -> hotelInfoEndWeek.merge( key, value, Double::sum)
        );
        final Map<HotelEnum, Double> listHotels = hotelInfoEndWeek.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Iterator<Map.Entry<HotelEnum, Double >> it = listHotels.entrySet().iterator();
        Map.Entry<HotelEnum, Double> firstElement = it.next();
        Map.Entry<HotelEnum, Double> secondElement = it.next();
        HotelEnum hotel = firstElement.getKey();
        if (firstElement.getValue().equals(secondElement.getValue())){
            hotel = (firstElement.getKey().getRating() > secondElement.getKey().getRating()) ? firstElement.getKey() : secondElement.getKey();
        }
        return hotel;
    }

    private List<Integer> feeWeek(List<LocalDate> dates) {
        List<Integer> list = new ArrayList<>();
        Integer countWeekDays = 0;
        Integer countWeekEnds = 0;
        for (LocalDate date : dates) {
            DayOfWeek day = date.getDayOfWeek();
            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                countWeekEnds++;
            } else {
                countWeekDays++;
            }
        }
        list.add(0, countWeekDays);
        list.add(1, countWeekEnds);
        return list;
    }
}
