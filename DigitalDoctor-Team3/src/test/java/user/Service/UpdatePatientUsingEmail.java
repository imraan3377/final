package user.Service;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdatePatientUsingEmail {
	  @Test
	  public void putRequest() {
		  RestAssured.baseURI="http://localhost:8080/api/v1/patient/Alia@gmail.com";
		  RequestSpecification httpRequest=RestAssured.given();
		  JSONObject requestparams=new JSONObject();
		  requestparams.put("patientEmail","Alia@gmail.com");
		  requestparams.put("patientName","Alia Rose");
		  requestparams.put("patientmobileNumber","9954346786");
		  requestparams.put("password","Alia@987");
		  requestparams.put("city","Ukraine");
		  requestparams.put("patientImage","Jpeg");
		  
		  httpRequest.header("Content-Type","application/json");
		  httpRequest.body(requestparams.toJSONString());
		  Response response=httpRequest.put("http://localhost:8080/api/v1/patient/Alia@gmail.com");
		  
		  System.out.println(response.getStatusLine());
		  
		  int Statuscode=response.getStatusCode();
		  Assert.assertEquals(200, Statuscode);
		  Response response1=httpRequest.get("http://localhost:8080/api/v1/patient/Alia@gmail.com");
		  System.out.println("Response Body is\n"+response1.asString());
	  }
	}

