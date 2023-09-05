package api.endpoints;
import static io.restassured.RestAssured.given;


import java.util.*; 
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPointsusingPropertiesFile {
	
	//method for fetching urls from properties files
	public static ResourceBundle getUrl()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload)
	{
		//get url
		String postUrl = getUrl().getString("post_url");
		
		Response res = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(postUrl);
		//.post(Routes.post_url);
		
		return res;
		
		
	}
	
	public static Response getUser(String username)
	{
		//get url
		String getUrl = getUrl().getString("get_url");
				
		Response res = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.when()
		.get(getUrl);
		//.get(Routes.get_url);

		return res;

	}
	
	public static Response updateUser(User payload,String username)
	{
		//get url
				String updateUrl = getUrl().getString("put_url");
				
		Response res = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		.when()
		.put(updateUrl);
		//.put(Routes.put_url);

		return res;

	}
	
	public static Response delUser(String username)
	{
		String delUrl = getUrl().getString("delete_url");
		
		Response res = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.when()
		.delete(delUrl);
	//	.delete(Routes.delete_url);

		return res;

	}

}
