package DRA.api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import DRA.api.endpoints.DRAendpoints;
import DRA.api.payload.DRAuser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class DRAtests extends DRAendpoints {
	

	Faker faker;
	DRAuser Userpayload;
	String Token="";

	
	@BeforeClass
	public void testsetup() {
		
		faker = new Faker();
		Userpayload = new DRAuser();
		
		Userpayload.setId(faker.idNumber().hashCode());
		//Userpayload.setFirstname(faker.name().firstName());
		Userpayload.setName(faker.name().lastName());
		Userpayload.setEmail(faker.internet().safeEmailAddress());
		//Userpayload.setUsername(faker.name().fullName());
		//Userpayload.setPhone(faker.phoneNumber().cellPhone());
		Userpayload.setPassword(faker.internet().password(6,9));

		
	
	}
	
	
	@Test(priority=1)
	public void Registrationflow() {
		
		Response response = DRAendpoints.registration(Userpayload);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		String email=jsonPathEvaluator.get("data.Email");
		System.out.println(email);
		Assert.assertEquals(email, Userpayload.getEmail());
		
	}
	
	@Test(priority=2)
	public void Loginflow() {
		
		 
		Response response=DRAendpoints.Login(Userpayload);
		response.then().log().all();
		JsonPath jsonPathEvaluator = response.jsonPath();
		Token= jsonPathEvaluator.getString("data.Token");
		
	}
	
	@Test(priority=3)
	public void Getusers() {
		
		Response response = DRAendpoints.Getuser(Token);
		response.then().log().all();		
	}
	
	
	@Test(priority=4)
	public void createusertest() {
		
		Userpayload.setEmail(faker.internet().safeEmailAddress());
		Response response= DRAendpoints.Createuser(Token,Userpayload);
		response.then().log().all();
	}
	
	
	

}
