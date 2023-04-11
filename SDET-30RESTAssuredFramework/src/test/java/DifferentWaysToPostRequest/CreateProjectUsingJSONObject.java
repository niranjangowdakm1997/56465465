package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;

import static io.restassured.RestAssured.*;
import  io.restassured.http.ContentType;

public class CreateProjectUsingJSONObject {
	
	@Test
	
	public void CreateProject()
	{
		
		
		JavaLibrary jlib=new JavaLibrary();
		
		JSONObject jobj=new JSONObject();
		
		jobj.put("createdBy","Reena");
		jobj.put("projectName","Mehabooba"+jlib.getRandomNumber());
		jobj.put("status","Created");
		jobj.put("teamSize",2);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		
		.log().all();
	}

}
