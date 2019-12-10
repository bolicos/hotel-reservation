package com.analuciabolico.hotelreservation;

import com.analuciabolico.hotelreservation.service.ServiceHotel;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ServiceHotel service = new ServiceHotel();
		String input;

		System.out.println("===========================================");
		System.out.println("===              WELCOME                ===");
		System.out.println("===========================================");


		System.out.println("ENTER CUSTOMER TYPE AND DATES:");
		input = keyboard.nextLine();

		System.out.println("BEST HOTEL AND CHEAPEST:");
		System.err.println(service.response(input));
	}

}
