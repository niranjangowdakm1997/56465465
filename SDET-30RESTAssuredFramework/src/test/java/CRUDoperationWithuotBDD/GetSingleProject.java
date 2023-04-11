package CRUDoperationWithuotBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	
	@Test
	
	public void getSingleProject()
	{
		//Step-1 create pre-requisites
		
		//Step-2 Perform the actions
		Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1203");
		
		//Step-3 validation
		response.then().log().all();
		int actualStatus = response.statusCode();
		Assert.assertEquals(200,actualStatus);
		
	}

}
