package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends BasePage{
	
	@FindBy(name = "q")
	WebElement search_TextBox;
	
	@FindBy(xpath = "(//input[@class='gNO89b'])[2]")
	WebElement search_Btn;
	
	public void enterText(String text) {
		search_TextBox.sendKeys(text);
	}
	
	public SearchResultPage clickSearchBtn() {
		search_Btn.click();
		return new SearchResultPage();
	}

}
