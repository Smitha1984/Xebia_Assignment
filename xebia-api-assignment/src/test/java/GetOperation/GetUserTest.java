package GetOperation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO.GetUserResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUserTest extends BaseTest {

	Response response;
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getEmployeeDetailTest() throws JsonParseException, JsonMappingException, IOException {
		int id = 2;
		//Execute request
		Response response = RestAssured.given().contentType(ContentType.JSON).when().get("/posts/{id}", id).then()
				.extract().response();

		// Get Status code and Assert
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);

		// Verify User detail
		// Map Response to POJO and assert details
		GetUserResponse getUserResponse = mapper.readValue(response.getBody().asString(), GetUserResponse.class);

		// Get Response assertions
		Assert.assertEquals(1, getUserResponse.getUserId(), "UserId returned does not match with expected UserId");
		Assert.assertEquals(2, getUserResponse.getId(), "Id returned does not match with expected Id");
		Assert.assertEquals("qui est esse", getUserResponse.getTitle(),
				"Title returned does not match with expected title");
		Assert.assertEquals(
				"est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla",
				getUserResponse.getBody(), "Body returned does not match with expected body");

	}

}
