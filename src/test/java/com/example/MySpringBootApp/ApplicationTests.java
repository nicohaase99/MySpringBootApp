package com.example.MySpringBootApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private AppointmentController AppointmentController;

	@Test
	void contextLoads() {
		// Test that the context loads successfully
	}

	@Test
	void AppointmentControllerLoads() {
		// Test that AppointmentController is properly injected
		assertThat(AppointmentController).isNotNull();
	}

	@Test
	void AppointmentEndpointReturnsContent() {
		// Test that the Appointment endpoint returns content
		String headline = AppointmentController.getLatestAppointmentDetails();
		assertThat(headline).isNotNull();
		assertThat(headline).contains("Jenkins Pipeline");

	}

}
