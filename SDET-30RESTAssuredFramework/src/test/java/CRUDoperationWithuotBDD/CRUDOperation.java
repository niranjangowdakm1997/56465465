package CRUDoperationWithuotBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CRUDOperation {
	
	@Test
	
	public void getAllProjects()
	{
		RestAssured.post();
		Response Rest = RestAssured.get("http://localhost:8084/projects");
		//System.out.println(Rest.asString());
		//Rest.prettyPrint();
		Rest.then().log().all();
	}

}
