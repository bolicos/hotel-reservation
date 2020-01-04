package com.analuciabolico.hotelreservation;

import com.analuciabolico.hotelreservation.service.fees.FeeService;
import com.analuciabolico.hotelreservation.service.hotels.HotelService;
import com.analuciabolico.hotelreservation.service.hotels.IHotelService;
import com.analuciabolico.hotelreservation.service.reservations.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application {
	private  static  final  Logger logger = LoggerFactory.getLogger(Application.class);
	private static Scanner keyboard = new Scanner(System.in);
	private static final String TEXT = "===========================================";

	public static void main(String[] args) {
		run();
	}

	static void run() {
		String input;
		IHotelService hotelService = new HotelService(new FeeService(), new ReservationService());
		logger.info(TEXT);
		logger.info("===              WELCOME                ===");
		logger.info(TEXT);


		logger.info("ENTER CUSTOMER TYPE AND DATES:");
		input = keyboard.nextLine();

		logger.info(hotelService.getResults(input));
		keyboard.close();
		logger.info(TEXT);
		logger.info("===                 END                 ===");
		logger.info(TEXT);
	}

}