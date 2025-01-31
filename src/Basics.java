import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basics {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParams("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(Payload.AddPlaceBody())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200)
				.body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.52 (Ubuntu)")
				.extract().response().asString();
		
		System.out.println("**response******");
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String placeID = js.getString("place_id");
		
		System.out.println(placeID);
		System.out.println(placeID.equals("8d2573bdf6ceec0e474c5f388fa917fb"));
		
		//8d2573bdf6ceec0e474c5f388fa917fb
		String address = "177A Bleecker Street in Manhattan, New York City";
		
		given().log().all().queryParams("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(Payload.putPlaceBody(placeID, address))
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200);
		
		String GETresponse = given().log().all()
				.queryParams("key", "qaclick123")
				.queryParam("place_id", placeID)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println("getRes: "+GETresponse);
		JsonPath getJS = new JsonPath(GETresponse);

		Assert.assertEquals(getJS.getString("address"), address);
		
	}

}
