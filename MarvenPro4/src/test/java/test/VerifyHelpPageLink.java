package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.asserts.SoftAssert;

import redbusPages.Help;
import redbusPages.HomePage;
import redbusPages.SearchPage;
import setup.Base;
import utils.Utility;

public class VerifyHelpPageLink extends Base {
	
	private WebDriver driver;
	private HomePage homePage;
	private Help help;
	private JavascriptExecutor js;
	private SearchPage searchPage;
	private ArrayList<String> addr;
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
	public void openApplicationSearchBuses() throws Throwable {
		
		driver.get("https://www.redbus.in/");
		
		searchPage=new SearchPage(driver);
		
		
		String souceName=Utility.fetchExcelData("Property", 6, 0);
		searchPage.fromSource(souceName);
		
		String destinationName=Utility.fetchExcelData("Property", 7, 0);
		searchPage.toDestination(destinationName);
		
		searchPage.dateSelect();
		searchPage.searchButton();
		homePage=new HomePage(driver);
		help=new Help(driver);
	}
	
	@BeforeMethod
	public void openHelpPage() throws Exception {
		
		homePage.helpButton();
		addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		help.helpPagePopup();
		
	}
	
	
	@Test
	public void verifyLoginToAccountLink() throws Throwable {
		
		testID=1234;
		help.clickLoginToAccountLink();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();

		String expectedUrl=Utility.fetchExcelData("Property", 6, 2);	
		Assert.assertEquals(url, expectedUrl);
		String expectedTitle=Utility.fetchExcelData("Property", 6, 3);
		Assert.assertEquals(title,expectedTitle );
				
	}
	
	@Test
	public void verifySetLanguage() throws Throwable {
	
		testID=4567;
		help.clickHindiLanguage();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		
		String expectedUrl=Utility.fetchExcelData("Property", 6, 2);	
		Assert.assertEquals(url, expectedUrl);
		String expectedTitle=Utility.fetchExcelData("Property", 6, 3);
		Assert.assertEquals(title,expectedTitle );
		
	}
		
	@AfterMethod
	public void closeCurrentWindowSwitchToMainWindow(ITestResult result) throws Throwable {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.captureScreenshot(driver, +testID);
		}
		driver.close();
		driver.switchTo().window(addr.get(0));
	}
	
	@AfterClass
	public void clearObject() {
		searchPage= null;
		homePage= null;
		help= null;
		driver.quit();
	}
	@AfterTest
	public void closeTheWindow() {
		driver.quit();
		driver= null;
		System.gc();
	}
	
	
	

}
