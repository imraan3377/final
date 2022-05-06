package user.Service;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class getPatientUsingEmail {
	@Test
	public void getDoctorUsingEmail () {
		RestAssured
		.given()
		.log()
		.all()
		.header("Content-Type","application/json")
		.get("http://localhost:8080/api/v1/patient/Denise@gmail.com")
		.then()
		.body("patientName",equalTo("Denise"))
		.log()
		.all();
	}
}