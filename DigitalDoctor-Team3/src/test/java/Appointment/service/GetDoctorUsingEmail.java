package Appointment.service;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDoctorUsingEmail {
	@Test
	public void getDoctorUsingEmail () {
		RestAssured
		.given()
		.log()
		.all()
		.header("Content-Type","application/json")
		.get("http://localhost:8060/api/v1/appointmentSlot/Tim@gmail.com")
		.then()
		.body("specialization",equalTo("Dermatologists"))
		.log()
		.all();
	}
}

