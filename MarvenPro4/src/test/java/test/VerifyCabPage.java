package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import redbusPages.CabHomePage;
import redbusPages.Help;
import redbusPages.HomePage;
import redbusPages.SearchPage;
import setup.Base;
import utils.Utility;

public class VerifyCabPage extends Base{
	
	private WebDriver driver;
	private SearchPage searchPage;
	private CabHomePage cabHomePage;
	private HomePage homePage;
	private int testID;
	
	@Parameters("browser")
	@BeforeTest
	public void launchMultipleBrowser(String browserName) {
		
		if(browserName.equals("Chrome")) {
			driver=openChromeBrowser();
		}
		
		if(browserName.equals("Firefox")) {
			driver=openFirefoxBroswer();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	@BeforeClass
	public void launchBrowser() throws Throwable {
		driver.get("https://www.redbus.in/");
		searchPage=new SearchPage(driver);
		
		String source=Utility.fetchExcelData("Property", 6, 0);
		searchPage.fromSource(source);
		
		String destination=Utility.fetchExcelData("Property", 7, 0);
		searchPage.toDestination(destination);
		
		searchPage.dateSelect();
		searchPage.searchButton();
		
		
		homePage=new HomePage(driver);
		homePage.popupCacel();
		cabHomePage=new CabHomePage(driver);
		
	}
	
	@BeforeMethod
	public void openCabPage() throws Exception {
		
		homePage.clickOnCabLink();
		
			
	}
	
	
	@Test
	public void verifyOutstaionTab() throws Throwable {
		testID=3456;
		
		cabHomePage.clickOutstationTab();
		String url= driver.getCurrentUrl();
		
		String expectedUrl=Utility.fetchExcelData("Property", 7, 2);
		Assert.assertEquals(url, expectedUrl);
					
	}
	
	@Test
	public void verifyHoyrlyRentalTab() throws Throwable {
		testID=7890;
		cabHomePage.clickOnhourlyRentalTab();
		
		
	}
		
	@AfterMethod
	public void navigateBackToHome(ITestResult result) throws Throwable {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.captureScreenshot(driver, +testID);
		}
		
		driver.navigate().back();
	}
	
	@AfterClass
	public void clearobjects() {
		searchPage= null;
		homePage= null;
		cabHomePage= null;
		driver.quit();
	}
	
	@AfterTest
	public void closeTheWindow() {
		driver.quit();
		driver=null;
		System.gc();
	}
		

}
