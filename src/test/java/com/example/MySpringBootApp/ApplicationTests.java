
package com.example.MySpringBootApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private AppointmentController appointmentController;

	@Test
	void contextLoads() {
		// Verifies that the Spring context loads successfully
	}

	@Test
	void appointmentControllerLoads() {
		// Verifies that AppointmentController is injected
		assertThat(appointmentController).isNotNull();
	}
}
