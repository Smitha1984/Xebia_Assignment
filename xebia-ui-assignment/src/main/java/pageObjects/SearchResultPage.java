package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
	
	@FindBy(id = "result-stats")
	WebElement resultStats_Text;
	
	@FindBy(xpath = "//table/tbody/tr/td")
	List<WebElement> pagination;
	
	@FindBy(xpath = "//span/a[text()='Wikipedia']")
	WebElement wiki_Link;
	
	public boolean verifyTextInSearchResult(String text) {
		String pageSource = driver.getPageSource();
		return pageSource.contains(text);
	}
	
	public boolean verifyPagination() {
		return pagination.size() > 0;
	}
	
	public boolean resultStatsPresent() {
		return resultStats_Text.isDisplayed();
	}

}
