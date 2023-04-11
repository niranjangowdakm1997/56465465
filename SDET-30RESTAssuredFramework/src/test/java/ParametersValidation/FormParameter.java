package ParametersValidation;

import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {
	
	@Test
	
	public void formParameter()
	{
		JavaLibrary jlib=new JavaLibrary();
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.formParam("createdBy","Adheera")
		.formParam("projectName","Kgf-3 "+jlib.getRandomNumber())
		.formParam("status","created")
		.formParam("teamSize",10)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.contentType(ContentType.JSON)
		.log().all();
	}

}
