package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import api.endpoints.UserEndPointsusingPropertiesFile;
import api.payload.User;
import api.utilities.DataProvidersExample;
import io.restassured.response.Response;

public class DDTest2usingProperties {

	//@Test(priority=1,dataProvider="test",dataProviderClass = DataProvidersExample.class)
	@Test(priority=1,dataProvider="test",dataProviderClass = DataProvidersExample.class)
	public void testPostUser(String userId,	String userName,String firstName,String lastName,String password,String phone)
	{
		User payload = new User();
		payload.setId(Integer.parseInt(userId));
		payload.setUsername(userName);
		payload.setFirstname(firstName);
		payload.setLastname(lastName);
		payload.setPassword(password);
		payload.setPhone(phone);
		
		Response res = UserEndPointsusingPropertiesFile.createUser(payload);
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
	}
	
//	@Test(priority = 2,dataProvider="UserNames",dataProviderClass = DataProviders.class)
//	public void testDeleteUserbyName(String username)
//	{
//		Response res = UserEndPoints.delUser(username);
//		Assert.assertEquals(res.getStatusCode(), 200);
//	}
	
	
}
