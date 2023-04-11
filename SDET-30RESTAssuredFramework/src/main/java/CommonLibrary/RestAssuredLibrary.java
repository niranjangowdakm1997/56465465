package CommonLibrary;

import io.restassured.response.Response;

public class RestAssuredLibrary {
	
	/**
	 * This method will return the json path
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
	public String getJsonPath(Response resp, String jsonPath)
	{  
		String value = resp.jsonPath().get(jsonPath);
		return value;
      
	}


	


}
