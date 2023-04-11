package CRUDoperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	
	@Test
	
	public void CreateProject()
	{
		//Step-1 Create Pre-Requisites
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","NiranjanGowda");
		jobj.put("projectName","US POLO");
		jobj.put("status","created");
		jobj.put("teamSize",20);
		
		baseURI="http://localhost";
		port=8084;
		
		//Step-2 Perform Actions
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
	    .then()
	    
	    //Step-3 Validation
	    .assertThat()
	    .statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
				
	}

}
