package Appointment.service;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateSlotByDoctor {
  @Test
  public void toRegisterDoctor() {
	  RestAssured.baseURI="http://localhost:8060/api/v1/doctor/slot";
	  RequestSpecification httpRequest=RestAssured.given();
	  JSONObject requestparams=new JSONObject();
	  requestparams.put("slotId","5");
	  requestparams.put("doctorEmailId","charlie@gmail.com");
	  requestparams.put("specialization","Eye Specialists");
	  requestparams.put("slotDate","2021-02-14");
	  requestparams.put("slotStartTime","22:04:04");
	  requestparams.put("slotEndTime","23:05:05");
	  requestparams.put("slotStatus","AVAILABLE");
	  
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response=httpRequest.post("http://localhost:8060/api/v1/doctor/slot");
	  System.out.println(response.getStatusLine());
	   
	  int Statuscode=response.getStatusCode();
	  Assert.assertEquals(200, Statuscode);
	 
  }
}
