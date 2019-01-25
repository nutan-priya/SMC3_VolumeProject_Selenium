package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pages.Login;
import utilities.ExceptionalHandlingFunctions;
import utilities.PropertyFileUtility;
public class LoginTests {

	WebDriver driver;
	Login loginToApplication;
	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"+"/DataFile.properties");
	
	
	@BeforeMethod
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", "./ExternalFiles/"+"/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		//loginToApplication=new Login(driver);
	}
	
	@Test(priority=1)
	public void loginWithValidCarrierCredential() throws Exception
	{
		try {
		loginToApplication=new Login(driver);
		driver.navigate().to(propertyValue.getValue("TestingURL"));
		loginToApplication.LoginToApplication(propertyValue.getValue("loginUserName"),propertyValue.getValue("loginPassword"));
	}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	}
	
	@Test(priority=2)
	public void loginWithInValidCredential() throws Exception
	{
		try {
		loginToApplication=new Login(driver);
		driver.navigate().to(propertyValue.getValue("TestingURL"));		
		loginToApplication.LoginToApplication(propertyValue.getValue("InvalidUsername"),propertyValue.getValue("InvalidPassword"));

		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}		
	
	
	@AfterMethod
	public void close()
	{
		driver.close();
		//loginToApplication=new Login(driver);
	}
	

}
