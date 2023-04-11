package DifferentWaysToPostRequest;

import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPoJoClass {
	
	@Test
	
	public void CreateProjectUsingPojo()
	{
		JavaLibrary jlib=new JavaLibrary();
		
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary plib=new ProjectLibrary("kalil", "kalashnikav"+jlib.getRandomNumber(),"created",50);
		
		given()
		.body(plib)
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
