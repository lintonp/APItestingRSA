package graphQLqueries;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Mutation {
	@Test
	public void mutationCreateLocationEpisode() {
		String res = given().log().all().header("Content-Type", "application/json")
				.body(GraphPayload.getMutationCreateLocationAndEpisode("JungleToday", "Mowgli"))
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().log().all().extract().response().asString();
		
		System.out.println("***********************");
		System.out.println(res);
		JsonPath js = new JsonPath(res);
		System.out.println(js.getString("data.createLocation.id"));
				
	}
}
