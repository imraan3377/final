package user.Service;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateDoctorUsingEmail {
  @Test
  public void putRequest() {
	  RestAssured.baseURI="http://localhost:8080/api/v1/doctor/John@gmail.com";
	  RequestSpecification httpRequest=RestAssured.given();
	  JSONObject requestparams=new JSONObject();
	  requestparams.put("doctorEmail","John@gmail.com");
	  requestparams.put("specialization","Dermatologists");
	  requestparams.put("yearsOfExperience",3);
	  requestparams.put("doctorName","John");
	  requestparams.put("password","Bangalore");
	  requestparams.put("city","John@203");
	  requestparams.put("image","Jpeg");
	  
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestparams.toJSONString());
	  Response response=httpRequest.put("http://localhost:8080/api/v1/doctor/John@gmail.com");
	  System.out.println(response.getStatusLine());
	  
	  int Statuscode=response.getStatusCode();
	  Assert.assertEquals(200, Statuscode);
	  Response response1=httpRequest.get("http://localhost:8080/api/v1/doctor/John@gmail.com");
	  System.out.println("Response Body is\n"+response1.asString());
  }
}
