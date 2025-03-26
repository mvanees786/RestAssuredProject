package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.json.JSONObject;
import org.testng.annotations.Test;
public class PathQueryParameters {
	@Test
	void TestQueryAndPathParameters(){	
		//https://reqres.in/api/users?page=2&id=5
		given()
				.pathParam("myPath", "users") //path param
				.queryParam("page",2) // query param
				.queryParam("id",5) // query param
		.when()
				.get("https://reqres.in/api/{myPath}")
		
		.then()
				.statusCode(200)
				.log().all();
	}
}
