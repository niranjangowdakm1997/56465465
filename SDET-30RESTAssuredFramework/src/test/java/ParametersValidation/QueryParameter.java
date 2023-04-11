package ParametersValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryParameter {
	
	@Test
	
	public void queryParameter()
	{
		baseURI="https://reqres.in";
		
		given()
		.queryParam("page",2)
		.contentType(ContentType.JSON)
		
		.when()
		.get("/api/users")
		
		.then()
		.assertThat()
		.log().all();
	}

}
