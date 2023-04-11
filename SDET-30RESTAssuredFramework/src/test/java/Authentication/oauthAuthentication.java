package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class oauthAuthentication {
	
	@Test
	
	public void OauthAuthenticate()
	{
		Response response = given()
		.formParam("client_id","SDET_30Coops")
		.formParam("client_secret","2af7e851600a611ae4e533f26fd351b5")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri","http://Niranjan.com")
		.formParam("code","authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		String token = response.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID",3109)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/echickens-feed")
		
		.then()
		.log().all();
		
		
	}

}
