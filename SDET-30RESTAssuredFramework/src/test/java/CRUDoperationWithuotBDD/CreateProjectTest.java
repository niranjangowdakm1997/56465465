package CRUDoperationWithuotBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	
	public void createProject()
	{
		//Step-1 Create Pre-Requisite 
		JSONObject jobj=new JSONObject();
		
		jobj.put("createdBy","NiranjanGowda");
		jobj.put("projectName","Appolo");
		jobj.put("status","created");
		jobj.put("teamSize",40);
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		//Step-2 Perform the actions
		Response response = req.post("http://localhost:8084/addProject");
		
		//Step-3 validate the response
		System.out.println(response.contentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
		
	}

}
