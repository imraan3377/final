package Appointment.service;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateUsingSlotId {
  @Test
  public void putRequest() {
	  RestAssured.baseURI="http://localhost:8060/api/v1/doctor/slot/status/3";
	  RequestSpecification httpRequest=RestAssured.given();
	  JSONObject requestparams=new JSONObject();
	  requestparams.put("slotId","3");
	  requestparams.put("doctorEmailId","Peter@gmail.com");
	  requestparams.put("specialization","Surgeon");
	  requestparams.put("slotDate","2021-02-14");
	  requestparams.put("slotStartTime","22:04:04");
	  requestparams.put("slotEndTime","23:05:05");
	  requestparams.put("slotStatus","BOOKED");
	  
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response=httpRequest.put("http://localhost:8060/api/v1/doctor/slot/status/3");
	  System.out.println(response.getStatusLine());
	  
	  int Statuscode=response.getStatusCode();
	  Assert.assertEquals(200, Statuscode);
	  Response response1=httpRequest.get("http://localhost:8060/api/v1/doctor/slot/status/3");
	  System.out.println("Response Body is\n"+response1.asString());
  }
}
