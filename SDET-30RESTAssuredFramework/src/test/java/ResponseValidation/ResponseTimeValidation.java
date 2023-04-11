package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseTimeValidation {
	
	@Test
	
	public void responseTimeValidation()
	{
		
		//pre-requisites
		baseURI="http://localhost";
		port=8084;
		
		//Actions
		Response response = when()
		.get("/projects");
		
		//Validation
		response.then()
		.assertThat().time(Matchers.lessThan(800L),TimeUnit.MILLISECONDS)
		.log().all();
		
		long time=response.time();
		System.out.println(time);
		
	}

}
