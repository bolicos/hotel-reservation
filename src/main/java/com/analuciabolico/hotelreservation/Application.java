package com.analuciabolico.hotelreservation;

import com.analuciabolico.hotelreservation.service.FeeService;
import com.analuciabolico.hotelreservation.service.HotelService;
import com.analuciabolico.hotelreservation.service.IHotelService;
import com.analuciabolico.hotelreservation.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application {
	private  static  final  Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) throws Exception {
		IHotelService hotelService = new HotelService(new FeeService(), new ReservationService());
		Scanner keyboard = new Scanner(System.in);
		String input;

		logger.info("===========================================");
		logger.info("===              WELCOME                ===");
		logger.info("===========================================");


		logger.info("ENTER CUSTOMER TYPE AND DATES:");
		input = keyboard.nextLine();

		logger.info(hotelService.getResults(input));
	}

}
