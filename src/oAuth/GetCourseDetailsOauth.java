package oAuth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class GetCourseDetailsOauth {
	@Test
	public void get_courseDetails() {
//		RestAssured.baseURI = "https://rahulshettyacademy.com";
//		String oAuthRes = given().log().all()
//			.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//			.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//			.formParam("grant_type", "client_credentials")
//			.formParam("scope", "trust")
//			.when().post("/oauthapi/oauth2/resourceOwner/token")
//			.then().log().all().extract().response().asString();
		

		String oAuthRes = given().log().all()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		JsonPath js = new JsonPath(oAuthRes);
		String authToken = js.getString("access_token");
		System.out.println("authToken: "+authToken);
		
		String get_courseDetails_res =  
				given().log().all()
				.queryParams("access_token", authToken)
				.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.then().log().all().extract().response().asString();
		System.out.println(get_courseDetails_res);
	}
}
