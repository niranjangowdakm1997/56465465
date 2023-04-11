package RestAssuredFrameworkImplementation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import CommonLibrary.BaseAPIClass;
import CommonLibrary.DataBaseLibrary;
import CommonLibrary.EndPointsLibrary;
import CommonLibrary.JavaLibrary;
import CommonLibrary.RestAssuredLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class FrameworkImplementation extends BaseAPIClass {
	
	@Test
	
	public void createProjectVerifyInDb() throws Throwable
	{
		
		//Step 1: create Prerequistes
				ProjectLibrary plib = new ProjectLibrary("Niranjan", "HP "+jlib.getRandomNumber(), "On Going", 20);
				
				Response resp = given()
				                  .body(plib)
				                  .contentType(ContentType.JSON)
				 
			                   	  .when()
				                  .post(EndPointsLibrary.CreateProject);
				
				//Step 2: Capture the project ID
				String expData = rlib.getJsonPath(resp,"projectId");
				System.out.println(expData);
				
				//Step 3: Verify the project in API response
				given()
				 .pathParam("pid",expData)
				.when()
				 .get(EndPointsLibrary.GetAllprojects+"/{pid}")
				.then().log().all();
				System.out.println("Data successfuly verifies in API response");
				
				//Step 4: Vefify the project in Database
				String query = "select * from project";
				String data = dblib.executeQueryAndGetData(query,expData,1);
				System.out.println(data);
				System.out.println("data verifed successfully in databse");
				 
				
		
	}

}
