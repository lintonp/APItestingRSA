package explorer;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class JsonExplorer {

	@Test
	public void testMockResponse() {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(Payload.getCoursePricesMockResponse());
		System.out.println(js.getString("dashboard.website"));
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		System.out.println(js.getInt("courses[0].price"));
		
		System.out.println(js.getInt("courses.size()"));
		
		int n = js.getInt("courses.size()");
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			System.out.println(i+
					" price="+js.getInt("courses["+i+"].price")+
					" copies="+js.getInt("courses["+i+"].copies"));
			sum += js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
		}
		
		System.out.println(sum);
		
		Assert.assertEquals(sum, js.getInt("dashboard.purchaseAmount"));
		
	}

}
