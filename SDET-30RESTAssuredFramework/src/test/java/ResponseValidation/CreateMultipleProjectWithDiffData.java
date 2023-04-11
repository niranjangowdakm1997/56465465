package ResponseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectWithDiffData {
	
	@Test(dataProvider = "getData")
	
	public void createMultipleProject(String createdBy,String projectName,String status,int teamSize)
	{
	   //Pre-Requisites
		JavaLibrary jlib=new JavaLibrary();
		
		ProjectLibrary plib=new ProjectLibrary(createdBy,projectName+jlib.getRandomNumber(),status,teamSize);
		
		baseURI="http://localhost";
		port=8084;
	
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		//Perform Actions
		.when()
		.post("/addProject")
		
		
		//Validation
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

	@DataProvider(name="getData")
	public Object[][] data()
	{
	  Object[][] data=new Object[3][4];
	  
	  data[0][0]="Niranjan";
	  data[0][1]="Dell";
	  data[0][2]="on-going";
	  data[0][3]=12;
	  
	  data[1][0]="Pramod";
	  data[1][1]="sony";
	  data[1][2]="created";
	  data[1][3]=23;
	  
	  data[2][0]="Prashant";
	  data[2][1]="HP";
	  data[2][2]="completed";
	  data[2][3]=34;
	  
	  return data;
		
	}
}
