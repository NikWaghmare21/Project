package redbusPages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Help {
	
	WebDriver driver;
	

	
	@FindBy (xpath="//i[@class='icon-close']")
	private WebElement popupHelpCancel;
	
	@FindBy (xpath="//iframe[@style='overflow:visible;']")
	private WebElement iFrame;
	
	@FindBy (xpath="//div[@class='login-question']")
	private WebElement loginToAcc;
	
	@FindBy (xpath="//img[@class='close-icon']")
	private WebElement cancel;
	
	@FindBy (xpath="//span[@class='languagePreference']")
	private WebElement language;
	
	@FindBy (xpath="(//input[@id='checkmark'])[3]")
	private WebElement selectLanguageHindi;
	
	@FindBy (xpath="//button[text()='SET LANGUAGE']")
	private WebElement selectLanguageButton;
	
	
	public Help(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver= driver;
		
	}
	
	public void helpPagePopup() {
		
		popupHelpCancel.click();
	}
	
	public void clickLoginToAccountLink() throws Exception {
		driver.switchTo().frame(iFrame);
		loginToAcc.click();
		Thread.sleep(3000);
		cancel.click();
		
	}
	
	public void clickHindiLanguage() throws InterruptedException {
		driver.switchTo().frame(iFrame);
		language.click();
		Thread.sleep(3000);
		selectLanguageHindi.click();
		Thread.sleep(3000);
		selectLanguageButton.click();
	}

}
