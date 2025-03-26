package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class CookiesDemo {

	String cookieValue="";
	
	
	@Test(priority=1)
	void getCookiesInfo() {
		
		Response res=given()
		
		.when()
			.get("https://www.google.co.in/");
		
		//cookieValue=res.getCookie("AEC");
		//System.out.println("Value of Cookie is "+ cookieValue);
		
		Map<String, String> cookieValues= res.getCookies();
		for(String k:cookieValues.keySet()) {
			
		String	cookieValue=res.getCookie(k);
			System.out.println(k+ "  "+ cookieValue);
		}
		
		
	}
	
	//@Test(priority=2)
	void testCookies() {
		
		given()
		
		.when()
			.get("https://www.google.co.in/")
		.then()
		.cookie("AEC",cookieValue)
			.log().all();
		
	}
}
