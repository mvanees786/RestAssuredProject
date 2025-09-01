package day1;
//static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {
	int id;
	
	@Test(priority = 1)
	void getUsers() {
	given()
	.when()
		.get("https://reqres.in/api/users?page=2")
	.then()
	.body("page",equalTo(2))
		.statusCode(200)
		.log().body();
	}

	@Test(priority = 2)
	void createUser() {
		HashMap data =new HashMap() ;
		data.put("name", "Anz");
		data.put("job", "Engr");

		 id=given()
			.header("x-api-key", "reqres-free-v1")
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
		System.out.println("ID:"+id);
		
	}
	

	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser() {
		HashMap data =new HashMap() ;
		data.put("name", "Anz");
		data.put("job", "Doc");

		given()
		.header("x-api-key", "reqres-free-v1")
		.contentType("application/json")
		.body(data)
	.when()
		.post("https://reqres.in/api/users/"+id)
	.then()
		.log().body();
	
	}
	
}
