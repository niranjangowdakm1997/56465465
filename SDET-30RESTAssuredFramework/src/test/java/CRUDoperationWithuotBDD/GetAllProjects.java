package CRUDoperationWithuotBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	
	@Test
	
	public void getAllProjects()
	{
		//Step-1 Create Pre-Requisites
		
		
		//Step-2 Perform the actions
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		//Step-3 validate
		response.then().log().all();
		int actualStatus = response.statusCode();
		Assert.assertEquals(200,actualStatus);
	}

}
