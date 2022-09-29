package redbusPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	@FindBy (xpath="//input[@data-message='Please enter a source city']")
	private WebElement from;
	
	@FindBy (xpath="//li[@data-id='624']")
	private WebElement from1;
	
	@FindBy (xpath="//input[@data-message='Please enter a destination city']")
	private WebElement to;
	
	@FindBy (xpath="//li[@data-id='130']")
	private WebElement to1;
	
	@FindBy (xpath="//input[@id='onward_cal']")
	private WebElement date;
	
	@FindBy (xpath="//td[text()='25']")
	private WebElement dateSelect;
	
	@FindBy (xpath="//button[@id='search_btn']")
	private WebElement searchBt;
	
	@FindBy (xpath="//a[@target='_blank']")
	private WebElement helpButton;
	
	
	
	public SearchPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void fromSource(String toSource) throws Exception {
		from.sendKeys(toSource);
		Thread.sleep(3000);
		from1.click();
	}
	
	public void toDestination(String toDestination) throws Exception {
		to.sendKeys(toDestination);
		Thread.sleep(3000);
		to1.click();
		
	}
	
	public void dateSelect() throws InterruptedException {
		date.click();
		Thread.sleep(3000);
		dateSelect.click();
	}
	public void searchButton() {
		searchBt.click();
	}
	
	public void helpLinkOnSearchPage() {
		helpButton.click();
	}


}
