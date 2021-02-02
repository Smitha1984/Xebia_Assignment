package GetOperation;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseTest {
	//https://jsonplaceholder.typicode.com/posts/1
	@BeforeSuite
	public void beforeSuite() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}
}
