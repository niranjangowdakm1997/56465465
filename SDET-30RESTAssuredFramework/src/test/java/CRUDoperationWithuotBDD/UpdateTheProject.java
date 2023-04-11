package CRUDoperationWithuotBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateTheProject {
	
	@Test
	
	public void UpdateProject()
	{
		//Step-1 create pre-requisites
		JSONObject jobj=new JSONObject();
		
		jobj.put("createdBy","NiranjanGowda");
		jobj.put("projectName","Appolo");
		jobj.put("status","created");
		jobj.put("teamSize",30);
		
		RequestSpecification request = RestAssured.given();
		request.body(jobj);
		request.contentType(ContentType.JSON);
		
		//Step-2 perform the actions
		Response response = request.put("http://localhost:8084/projects/TY_PROJ_1203");
		
		//Step-3 validation
		response.then().log().all();
		int actualStatus = response.statusCode();
		Assert.assertEquals(actualStatus,200);
		
		
		
	}

}
