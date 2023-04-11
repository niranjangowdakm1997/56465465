package CRUDoperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProjectTest {
	
	@Test
	
	public void GetSingleProject()
	{
		//Step-1 Create Pre-Requisites
		baseURI="http://localhost";
		port=8084;
		
		//Step-2 Perform actions 
		when()
		.get("/projects/TY_PROJ_1204")
		
		//Step-3 Validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
