package explorer;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test
	public void addBook() {
		RestAssured.baseURI = "http://216.10.245.166";
		
		String addBookRes = given().log().all().header("Content-Type", "application/json")
		.body(Payload.addBookPayload())
		.when().post("Library/Addbook.php")
		.then()//.assertThat().statusCode(200)
		.log().all().extract().response().asString();
		
//		JsonPath js = new JsonPath(addBookRes);
//		System.out.println(addBookRes);
		
	} 

}
