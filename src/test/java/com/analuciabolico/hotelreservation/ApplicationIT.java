package com.analuciabolico.hotelreservation;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationIT {

	@Mock
	Application application;

	@Test
	void entrada1() throws Exception {
		application.main(new String[]{"Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"});
	}
}
