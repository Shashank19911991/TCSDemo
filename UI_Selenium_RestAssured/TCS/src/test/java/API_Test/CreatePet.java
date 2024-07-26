package API_Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreatePet {
	String body = null;
	String bodyInvalidID = null;

	@BeforeClass
	public void setup() throws IOException {
	body =	FileUtils.readFileToString(new File(Constants.postPet),"UTF-8");
	bodyInvalidID = FileUtils.readFileToString(new File(Constants.postPetInvalidID),"UTF-8");
	
	RestAssured.baseURI = "https://petstore.swagger.io";
	}
	
	//Positive Test to Create Pet
	@Test()
	public void testAPIPositive() {
		
		Response rs = 	RestAssured.given()
		.basePath("/v2/pet")
		.contentType("application/json")
		.body(body)
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
		
		String name = rs.getBody().jsonPath().get("name").toString();
		
		Assert.assertEquals(name, "doggie", "Name is not Matching in API Response");
	}
	
	//Negative Test Verification
	@Test
	public void testNegative() {
		
		Response rs = 	RestAssured.given()
		.basePath("/v2/pet")
		.contentType("application/json")
		.body(bodyInvalidID)
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(400)
		.extract()
		.response();
		
		String message = rs.getBody().jsonPath().get("message").toString();
		
		Assert.assertEquals(message, "bad input", "Issue in Invalid Test Matching in API Response");
	}
	
	
}
