package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	
	public void bearerToken()
	{
		baseURI="https://api.github.com";
		
		JSONObject jobj=new JSONObject();
		jobj.put("name","LeaveEarth");
		
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then()
		.log().all();
		
	}

}
