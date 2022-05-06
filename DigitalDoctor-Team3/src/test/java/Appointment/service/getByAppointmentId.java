package Appointment.service;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class getByAppointmentId {
	@Test
	public void getDoctorUsingEmail () {
		RestAssured
		.given()
		.log()
		.all()
		.header("Content-Type","application/json")
		.get("http://localhost:8060/api/v1/appointmentDetails/c863207c-4bb1-4226-886e-ac828a73168b")
		.then()
		.body("patientEmail",equalTo("Tim@gmail.com"))
		.log()
		.all();
	}
}