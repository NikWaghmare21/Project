package redbusPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CabHomePage {
	
	private WebDriver driver;
	private Actions act;
	
	
	@FindBy (xpath="(//div[@class='Abw3ybfmrhmGEXyk7e6i'])[1]")
	private WebElement outStation;
	
	@FindBy (xpath="(//div[@class='Abw3ybfmrhmGEXyk7e6i'])[1]")
	private WebElement hourlyRental;
	
	
	
	

	public CabHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
		act=new Actions(driver);
		
	}
	
	
	
	public void clickOutstationTab() {
		
		outStation.click();
	}
	
// 	public void clickOnhourlyRentalTab(){
		
// 		hourlyRental.click();
// 	}
	

}
