package redbusPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriverWait wait;
	private Actions act;
	
	@FindBy (xpath="//div[@class='tripleFive-block']//i")
	private WebElement popupCancel;
	
	@FindBy (xpath="(//label[@for='dt12 pm to 6 pm'])[1]")
	private WebElement timeCheckBox;
	
	@FindBy (xpath="(//label[@for='dt12 pm to 6 pm'])[1]]")
	private WebElement sleeperCheckBox;
	
	@FindBy (xpath="(//label[@for='bt_Single Seats'])")
	private WebElement singleCheckBox;
	
	@FindBy (xpath="(//div[text()='View Seats'])[1]")
	private WebElement checkSits;
	
	@FindBy (xpath="(//a[text()='Help'])")
	private WebElement help;
	
	@FindBy (xpath="(//li)[2]//a[@id='rYde']")
	private WebElement cabLink;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 20);
		act=new Actions(driver);
	}
	
	public void popupCacel() {
		wait.until(ExpectedConditions.visibilityOf(popupCancel));
		act.moveToElement(popupCancel).click().build().perform();
		
		
	}
	
	public void checkbox() {
		timeCheckBox.click();
		sleeperCheckBox.click();
		singleCheckBox.click();
	}
	public void sitCheck() {
		checkSits.click();
	}
	public void helpButton() {
		help.click();
	}
	
	public void clickOnCabLink() {
		wait.until(ExpectedConditions.visibilityOf(cabLink));
		cabLink.click();
		
		
	}
		
		
		
	

}
