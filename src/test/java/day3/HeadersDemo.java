package day3;
import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

    //@Test(priority = 1)
    void testHeaders() {
        given()
        .when()
            .get("https://www.google.co.in/")
        .then()
            .header("Content-Type", "text/html; charset=ISO-8859-1")
            .header("Content-Encoding", "gzip")
            .log().headers();  // Logs all headers for debugging
    }

    @Test(priority = 2)
    void getHeaders() {
        Response res = given()
        .when()
            .get("https://www.google.com/");   

		//String headerValeue=res.getHeader("Content-Type");
		//System.out.println("Content-Type:"+headerValeue );
        // Extract all headers
        Headers myHeaders = res.getHeaders();
        System.out.println("---- Response Headers ----");
        for (Header h : myHeaders) {
            System.out.println(h.getName() + ": " + h.getValue());
        }
    }
}
