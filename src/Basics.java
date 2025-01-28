import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.Payload;
import io.restassured.RestAssured;

public class Basics {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParams("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(Payload.AddPlaceBody())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.52 (Ubuntu)");
	}

}
