package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticResponseValidation {
	
	@Test
	
	public void StaticResponse()
	{
		
		//pre-requisites
		JavaLibrary jlib=new JavaLibrary();
		
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary plib=new ProjectLibrary("Niranjan","KGF-3 "+jlib.getRandomNumber(),"created",20);
		
		 Response response = given()
				 .body(plib)
				 .contentType(ContentType.JSON)
				
				 //Perform Actions
				 .when()
				 .post("/addProject");
		 
		 // Validation
		 String actualData = response.jsonPath().get("projectName");
		 Assert.assertTrue(actualData.contains("KGF-3"));
		
		 response.then()
		 .assertThat().statusCode(201)
		 .log().all();
		}

}
