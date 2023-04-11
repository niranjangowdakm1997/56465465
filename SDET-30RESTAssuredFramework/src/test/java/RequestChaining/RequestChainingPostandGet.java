package RequestChaining;

import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingPostandGet {
	
	@Test
	
	public void RequestChaining()
	{
		
		//create pre-requisites
		
		JavaLibrary jlib=new JavaLibrary();
		ProjectLibrary plib=new ProjectLibrary("RAghavan","BiggestCriminal "+jlib.getRandomNumber(),"created",1);
		
		baseURI="http://localhost";
		port=8084;
		
		Response response = given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		//perform Actions
		
		.when()
		.post("/addProject");
		
		//validation
		
		String proId = response.jsonPath().get("projectId");
		System.out.println(proId);
		response.then().log().all();
		
		
		//Pre-Requisites
		
		given()
		.pathParam("pid", proId)
		
		//Perform Actions
		
		.when()
		.get("/projects/{pid}")
		
		//Validation
		
		.then()
		.assertThat().statusCode(200).log().all();
		
	}

}
