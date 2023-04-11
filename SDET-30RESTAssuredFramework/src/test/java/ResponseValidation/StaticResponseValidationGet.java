package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationGet {
	
	@Test
	
	public void StaticresponseValidationUsingGet()
	{
				 
				 Response response = when()
				 .get("/projects");
		 
		 String actualData = response.jsonPath().get("projectName");
		 Assert.assertTrue(actualData.contains("KGF-3"));
		
		 response.then()
		 .assertThat().statusCode(201)
		 .log().all();
		}

}
