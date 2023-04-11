package CRUDoperationWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProject {
	
	@Test
	
	public void UpdateProject()
	{
		
		//Step-1 Create pre-Requisites
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","NiranjanGowda");
		jobj.put("projectName","US POLO");
		jobj.put("status","created");
		jobj.put("teamSize",30);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//step-2 Perform Actions
		.when()
		.put("/addProject/TY_PROJ_1204")
		
		//Step-3 validation
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
	}

}
