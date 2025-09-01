package day4;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class ParsingJSONResponseData {

	@Test(priority=1)
	void testJSONResponse() {
		
		//Approach 1
		Response res=given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/book");
//		.then()
//			.statusCode(200)
//			.header("Content-Type", "application/json")
//			.body("book[3].title", equalTo("The Lord of the Rings"));
	
	/*		//Approach 2
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/book");
	
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json");
		String nametitle=res.jsonPath().get("book[3].title").toString();
		System.out.println(nametitle);
		Assert.assertEquals(nametitle,"The Lord of the Rings");
	
	*/
		
		

		
		//Approach 3	
		//USING JSON Object class
		JSONObject jo= new JSONObject(res.asString());
		
		for(int i=0;i<jo.getJSONArray("book").length();i++) {
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
		}
	}
	
	
	
}
