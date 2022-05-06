package Authentication.service;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class registerUser {
  @Test
  public void f() {
	  RestAssured.baseURI="http://localhost:8095/api/v1/user/register";
	  RequestSpecification httpRequest=RestAssured.given();
	  JSONObject requestparams=new JSONObject();
	  requestparams.put("emailId","Nihal@gmail.com");
	  requestparams.put("password","Nihal@123");
	  requestparams.put("role","doctor");
	 
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response=httpRequest.post("http://localhost:8095/api/v1/user/register");
	  System.out.println(response.getStatusLine());
	 
	  int Statuscode=response.getStatusCode();
	  Assert.assertEquals(200, Statuscode);
	  

	  
  }

}
