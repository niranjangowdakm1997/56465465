package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap {
	
	@Test
	
	public void CreateProjectUsingHashMap()
	{
		
		//step-1 Create Pre-requisites
		JavaLibrary jlib=new JavaLibrary();
		
		HashMap map=new HashMap();
		map.put("createdBy","Yash");
		map.put("projectName","Marine"+jlib.getRandomNumber());
		map.put("status","completed");
		map.put("teamSize",4);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		//Step-2 Perform Actions
		.when()
		.post("/addProject")
		
	    //Step-3 Validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		
		.log().all();
		
	}

}
