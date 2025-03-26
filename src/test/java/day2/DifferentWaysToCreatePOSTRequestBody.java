package day2;
//static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class DifferentWaysToCreatePOSTRequestBody {

	//Using HASHMAP
	@Test(priority=1)
	void postUsingHashMap() {
		HashMap data =new HashMap();
		data.put("name", "Anees");
		data.put("location", "UAE");
		data.put("phone", "123456");
		
		String courseArray[]= {"C++", "Java"};
		data.put("Courses", courseArray);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students/")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Anees"))
			.body("location",equalTo("UAE"))
			.body("phone",equalTo("123456"))
			.body("courses[0]",equalTo("C++"))
			.body("courses[1]",equalTo("Java"))
			.header("Content-Type","application/json;charset=utf-8")
			.log().all();

	
	
	}
	@Test(priority=2)
	void deleteTest() {
		
		
		given()
		.when()
			.delete("http://localhost:3000/students/4")

		.then()
		.statusCode(anyOf(equalTo(200), equalTo(204)));
	}
	
		//Using Org.JSON
		//@Test(priority=1)
		void postUsingJSON() {
			JSONObject data =new JSONObject();	
			data.put("name", "Anees");
			data.put("location", "UAE");
			data.put("phone", "123456");
			
			String courseArray[]= {"C++", "Java"};
			data.put("Courses", courseArray);
			
			given()
				.contentType("application/json")
				.body(data.toString())
			.when()
				.post("http://localhost:3000/students")
			
			.then()
				.statusCode(201)
				.body("name",equalTo("Anees"))
				.body("Location",equalTo("UAE"))
				.body("Phone",equalTo("123456"))
				.body("courses[0]",equalTo("C++"))
				.body("courses[1]",equalTo("Java"))
				.header("Content-Type","application/json;charset=utf-8")
				.log().all();
		
		}
		//@Test(priority=2)
		void deleteTest2() {
			
			
			given()
			.when()
				.post("http://localhost:3000/students/4")

			.then()
				.statusCode(200);
		}
		
//USING POJO		
		//@Test(priority=1)
		void postUsingPOJO() {
			POJO data=new POJO();
			data.setName("Anees");
			data.setLocation("UAE");
			data.setPhone("123465");
		
			
			String courseArray[]= {"C++", "Java"};
			data.setCourses(courseArray);
			
			given()
				.contentType("application/json")
				.body(data)
			.when()
				.post("http://localhost:3000/students/")
			
			.then()
				.statusCode(201)
				.body("name",equalTo("Anees"))
				.body("location",equalTo("UAE"))
				.body("phone",equalTo("123456"))
				.body("courses[0]",equalTo("C++"))
				.body("courses[1]",equalTo("Java"))
				.header("Content-Type","application/json;charset=utf-8")
				.log().all();

		
		
		}
	//	@Test(priority=2)
		void deleteTest3() {
			
			
			given()
			.when()
				.delete("http://localhost:3000/students/4")

			.then()
				.statusCode(200);
		}
	
}
