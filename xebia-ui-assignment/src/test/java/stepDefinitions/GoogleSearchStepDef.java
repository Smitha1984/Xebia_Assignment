package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.GoogleHomePage;
import pageObjects.SearchResultPage;

public class GoogleSearchStepDef {

	GoogleHomePage googleHomePage;
	SearchResultPage searchResultPage;
	public static WebDriver driver;

	@Given("user launches browser")
	public void user_launches_browser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Smitha\\Desktop\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		BasePage.driver = driver;
	}

	@Given("navigates to website google.com")
	public void navigates_to_website_google_com() {
		driver.get("https://www.google.com/");
	}

	@When("user enters ducks as input box")
	public void user_enters_ducks_as_input_box() {
		googleHomePage = new GoogleHomePage();
		googleHomePage.enterText("Ducks");
	}

	@When("clicks seach button")
	public void clicks_seach_button() {
		searchResultPage = googleHomePage.clickSearchBtn();
	}

	@Then("search result page should display result related to ducks")
	public void search_result_page_should_display_result_related_to_ducks() {
		// Verify result stat
		Assert.assertTrue(searchResultPage.resultStatsPresent());
		
		// Verify search text is present
		Assert.assertTrue(searchResultPage.verifyTextInSearchResult("ducks"));
		
		// Verify pagination
		Assert.assertTrue(searchResultPage.verifyPagination());
	}

}
