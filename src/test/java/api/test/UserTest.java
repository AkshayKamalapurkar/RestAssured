package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	User usr;
	Faker fk;
	
	@BeforeClass
	public void setUpData()
	{
		Faker fk = new Faker();
		usr= new User();
		
		usr.setId(fk.idNumber().hashCode());
		usr.setUsername(fk.name().username());
		usr.setFirstname(fk.name().firstName());
		usr.setLastname(fk.name().lastName());
		usr.setEmail(fk.internet().safeEmailAddress());
		usr.setPassword(fk.internet().password(5,10));
		usr.setPhone(fk.phoneNumber().cellPhone());
	}

	@Test(priority=1)
	public void TestPostUser()
	{
		Response res = UserEndPoints.createUser(usr);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void TestGetUser()
	{
		Response res = UserEndPoints.getUser(this.usr.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void TestUpdateUser()
	{
		Faker fks = new Faker();
		usr.setFirstname(fks.name().firstName());
		usr.setLastname(fks.name().lastName());
		usr.setEmail(fks.internet().safeEmailAddress());
		
		Response res = UserEndPoints.updateUser(usr,this.usr.getUsername());
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//checking after upgrade
		Response resafterupdate = UserEndPoints.getUser(this.usr.getUsername());
		Assert.assertEquals(resafterupdate.getStatusCode(), 200);
		
	}
	

	@Test(priority=4)
	public void TestDeleteUser()
	{
		Response res = UserEndPoints.delUser(this.usr.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
