package runner;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pageObjects.BasePage;
import pageObjects.GoogleHomePage;
import pageObjects.SearchResultPage;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/features"
 ,glue={"src/test/java/stepDefinitions"}
 )
 
public class TestRunner {
	
 
}
