package CRUDoperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	
	@Test
	
	public void DeleteProject()
	{
		//Step-1 Create Pre-Requisites
		baseURI="http://localhost";
		port=8084;
		
		//Step-2 perform actions
		when()
		.delete("/projects/TY_PROJ_1204")
		
	    //Step-3 Validation
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204)
		.log().all();
	}

}
