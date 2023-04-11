package ParametersValidation;

import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	
	public void pathParameter()
	{
		JavaLibrary jlib=new JavaLibrary();
	    
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("pid","TY_PROJ_002")
		.contentType(ContentType.JSON)
		
		.when()
		.get("/projects/{pid}")
		
		.then()
		.log().all();
	}

}
