package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONFile {
	
	@Test
	
	public void CreateProject()
	{
		//Step-1 Create PRE-Requisites
		File file=new File(".\\Data.json");
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		//step-2 Perform Actions
		.when()
		.post("/addProject")
		
		//Step-3 validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		
		.log().all();
	}

}
