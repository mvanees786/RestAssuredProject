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
	
	@Test(priority=1)
	void testCookies() {
		
	Response res=	given()
		.when()
			.get("https://www.google.com/");
//	String cookieValue=res.getCookie("AEC");
	
	Map<String, String> cookiesAll = res.getCookies();
	for(Map.Entry<String,String> entry: cookiesAll.entrySet()) {
		System.out.println("KEY: "+entry.getKey()+" VALUE: "+ entry.getValue());
	}
	}
	
	
	
	
}
