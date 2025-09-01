package day2;
//static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DifferentWaysToCreatePOSTRequestBody {
	
	//@Test(priority=1)
	public void postUsingHashMap() {
		
		HashMap data =new HashMap();
		data.put("name", "AZEEM");
		data.put("location", "Swiss");
		data.put("phone", "123987");
		String []courseArr= {"Python","MongoDB"};
		data.put("courses", courseArr);
		
		given()
			.contentType(ContentType.JSON)
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("AZEEM"))
			.header("Content-Type", "application/json")
			.log().all();
		
	}
	
	@Test(priority=1)
		public void orgJSON() {
		
		
		JSONObject data =new JSONObject();
		data.put("name", "AZEEM");
		data.put("location", "Swiss");
		data.put("phone", "123987");
		String []courseArr= {"Python","MongoDB"};
		data.put("courses", courseArr);
		
		given()
			.contentType(ContentType.JSON)
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("AZEEM"))
			.header("Content-Type", "application/json")
			.log().all();
	
	}
	
	
	
	
	
	
}
