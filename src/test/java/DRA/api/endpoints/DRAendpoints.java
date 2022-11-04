package DRA.api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import DRA.api.payload.DRAuser;



public class DRAendpoints {
	
	
	
	
	public static Response registration(DRAuser Payload) {
		
		Response response= given()
						.contentType("application/json")
						.queryParam("api_key", "api_key")
						.body(Payload)
						.when()
						.post(DRAroutes.Registration_url);
		
		return response;
		
		
	}
	
	public static Response Login(DRAuser Payload) {
		
		Response response=given()
					.contentType("application/json")
					.queryParam("api_key", "api_key")
					.body(Payload)
					.when()
					.post(DRAroutes.Login_url);
		
		return response;
		
	}
	
	public static Response Getuser(String token) {
		Response response=given()
				.contentType("application/json")
				.queryParam("api_key", "api_key")
				.header("Authorization", "Bearer " + token)
				.when()
				.get(DRAroutes.getuser);
		return response;
	}
	
	public static Response Createuser(String token,DRAuser Payload) {
		Response response =given()
				.contentType("application/json")
				.queryParam("api_key", "api_key")
				.header("Authorization", "Bearer " + token)
				.body(Payload)
				.when()
				.post(DRAroutes.Createuser_url);
		return response;
	}
	
	
	

}
