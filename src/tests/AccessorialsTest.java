package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.Accessorials;
import pages.Login;
import utilities.CommonFunctions;
import utilities.ExceptionalHandlingFunctions;
import utilities.PropertyFileUtility;

public class AccessorialsTest {

	WebDriver driver;
	Login loginToApplication;
	Accessorials accessorialDetails;
	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"+"/DataFile.properties");
	CommonFunctions utilityfunctions = new CommonFunctions(driver);
	
	
	@BeforeMethod
	public void start()
	{		
		System.setProperty("webdriver.chrome.driver", "./ExternalFiles/"+"/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to(propertyValue.getValue("TestingURL"));
		loginToApplication=new Login(driver);
		loginToApplication.LoginToApplication(propertyValue.getValue("loginUserName"),propertyValue.getValue("loginPassword"));
	}
	
	@Test
	public void accessorialsCheckBoxValidation() throws Exception
	{
		try {
		Thread.sleep(4000);
		accessorialDetails = new Accessorials(driver);
		
		//Test to verify the accessorial check boxes when Checked
		accessorialDetails.setAccessorials();
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Notify Before Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Construction Site Pickup')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Construction Site Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Lift Gate Service Pickup')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Lift Gate Service Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Limited Access Pickup')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Limited Access Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Residential Pickup')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Residential Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Hazardous Material')]/preceding::input[@type='checkbox'][1]")).isSelected());
	//	Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Insurance')]/preceding::input[@type='checkbox'][1]")).isSelected());
		System.out.println("Validated for all the accessorial items checkbox; gets selected when checked by the user. ");
		
		
		//Test to verify the accessorial check boxes when Unchecked
		accessorialDetails.setAccessorials();
		
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Notify Before Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Construction Site Pickup')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Construction Site Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Lift Gate Service Pickup')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Lift Gate Service Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Limited Access Pickup')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Limited Access Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Residential Pickup')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Residential Delivery')]/preceding::input[@type='checkbox'][1]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Hazardous Material')]/preceding::input[@type='checkbox'][1]")).isSelected());
		//Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Insurance')]/preceding::input[@type='checkbox'][1]")).isSelected());
		System.out.println("Validated for all the accessorial items checkbox; gets unselected when unchecked by the user.");
	}
		catch (Exception e) {
			System.out.println(e);
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
		
	}
}
