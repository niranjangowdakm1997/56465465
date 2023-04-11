package ResponseValidation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
	
	@Test
	
	public void dynamicResponseValidation()
	{
		String expectedData = "TY_PROJ_1405";
		Response response = when()
				.get("/projects");
		
		boolean flag=false;
		List<String> PIDs= response.jsonPath().get("projectId");
		for(String projectId :PIDs)
		{
			if(projectId.equalsIgnoreCase(expectedData))
			{
				flag=true;
			}
		}
		
		Assert.assertTrue(flag);
		System.out.println("data verified");
		
		response.then().log().all();
	}

}
