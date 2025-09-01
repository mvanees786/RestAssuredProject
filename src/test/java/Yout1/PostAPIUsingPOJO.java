package Yout1;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
public class PostAPIUsingPOJO {

	public static void main(String[] args) {

		EmployeePOJO ep=new EmployeePOJO("morpheus", "Leader",new String[] {"Java","C++"}, "Google", "test@gmail.com");
		
		Response postResponse = given()
			    .auth().none()
			    .header("Content-Type", "application/json")
			    .contentType(ContentType.JSON)
			    .body(ep)
			.when()
			    .log().all()
			    .post("https://reqres.in/api/users");

			System.out.println("Post Response is " + postResponse.asString());
			System.out.println("Post Response status code is " + postResponse.getStatusCode());
		
		
	}

}
