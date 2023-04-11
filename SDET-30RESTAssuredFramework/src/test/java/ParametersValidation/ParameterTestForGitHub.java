package ParametersValidation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParameterTestForGitHub {
	
	@Test
	
	public void parameterTest()
	{
         baseURI ="https://api.github.com";
		
		given()
		 .pathParam("username", "Niranjan")
		 .queryParam("per_page", 20)
		 .queryParam("page", 2)
		 
		.when()
		 .get("/users/{username}/repos")
		 
		.then().assertThat().statusCode(200).log().all();
	
	}

}
