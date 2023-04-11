package CRUDoperationWithuotBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTheProject {
	
	@Test
	
	public void deleteTheProject()
	{
		//Step-1 Create Pre-Requisites
		
		//Step-2 Perform the actions
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1203");
		
		//Step-3 validation
		response.then().log();
		int actualStatus = response.statusCode();
		Assert.assertEquals(actualStatus,204);
	}

}
