package Appointment.service;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBySlotId {
	@Test
	public void getDoctorUsingSpecialization () {
		RestAssured
		.given()
		.log()
		.all()
		.header("Content-Type","application/json")
		.get("http://localhost:8060/api/v1/doctor/slot/2")
		.then()
		.log()
		.all();
		
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"");
		System.out.println("status received=>"+response.getStatusCode());
		Assert.assertEquals(404, response.getStatusCode());
		
	}
}
