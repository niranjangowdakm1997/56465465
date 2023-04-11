package CommonLibrary;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {
	
	public DataBaseLibrary dblib=new DataBaseLibrary();
	public JavaLibrary jlib = new JavaLibrary();
	public RestAssuredLibrary rlib = new RestAssuredLibrary();
	
	@BeforeSuite
	
	public void bsConfig() throws Throwable
	{
		//Establish databse connection
		dblib.connectToDB();
		System.out.println("=============db connection established============");
		
		//set base Uri and port
	    baseURI = "http://localhost";
	    port = 8084;
	    
	    
	}
	
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dblib.closeDB();
	}

}
