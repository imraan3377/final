package Appointment.service;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateAppoinmentByPatient {
  @Test
  public void toRegisterPatient() {
	  RestAssured.baseURI="http://localhost:8080/api/v1/patient";
	  RequestSpecification httpRequest=RestAssured.given();
	  JSONObject requestparams=new JSONObject();
	  requestparams.put("patientEmail","Oliver@gmail.com");
	  requestparams.put("patientName","Oliver");
	  requestparams.put("patientmobileNumber","989023456");
	  requestparams.put("password","Oliver@123");
	  requestparams.put("city","London");
	  requestparams.put("patientImage","Jpg");
	 	  
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response=httpRequest.post("http://localhost:8080/api/v1/patient");
	  System.out.println(response.getStatusLine());
	  
	  
	  int Statuscode=response.getStatusCode();
	  Assert.assertEquals(201, Statuscode);
	 

  }
}
