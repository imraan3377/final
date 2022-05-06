package user.Service;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateDoctor {
  @Test
  public void toRegisterDoctor() {
	  RestAssured.baseURI="http://localhost:8080/api/v1/doctor";
	  RequestSpecification httpRequest=RestAssured.given();
	  JSONObject requestparams=new JSONObject();
	  requestparams.put("doctorEmail","Justin@gmail.com");
	  requestparams.put("specialization","Cardiologists");
	  requestparams.put("yearsOfExperience","7");
	  requestparams.put("doctorName","Justin");
	  requestparams.put("password","Justin@203");
	  requestparams.put("city","Chennai");
	  requestparams.put("image","Jpg");
	  
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response=httpRequest.post("http://localhost:8080/api/v1/doctor");
	  System.out.println(response.getStatusLine());
	   
	  int Statuscode=response.getStatusCode();
	  Assert.assertEquals(201, Statuscode);
	 
  }
}
