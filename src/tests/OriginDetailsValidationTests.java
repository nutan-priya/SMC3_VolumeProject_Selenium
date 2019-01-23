package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OriginDetails;
import pages.Login;
import utilities.CommonFunctions;
import utilities.ExceptionalHandlingFunctions;
import utilities.PropertyFileUtility;

public class OriginDetailsValidationTests {

	WebDriver driver;
	Login loginToApplication;
	OriginDetails originDetails;
	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"+"/DataFile.properties");
	CommonFunctions utilityfunctions = new CommonFunctions(driver);
	
	String cityNamesList;
	String originState;
	String originCountry;
	
	@BeforeMethod
	public void start()
	{		
		System.setProperty("webdriver.chrome.driver", "./ExternalFiles/"+"/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(propertyValue.getValue("TestingURL"));
		loginToApplication=new Login(driver);
		loginToApplication.LoginToApplication(propertyValue.getValue("loginUserName"),propertyValue.getValue("loginPassword"));
	}
	
	
	@Test(priority=1)
	public void originZipValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		originDetails=new OriginDetails(driver);
		
		//Test to validate US zipcode having 5 characters and error message to select one city.
		originDetails.setOriginZip(propertyValue.getValue("OrizinZip"));
		Thread.sleep(2000);
		 cityNamesList = originDetails.getOriginCity();
		 originState = originDetails.getOriginState();
		 originCountry = originDetails.getOriginCountry();
				
		utilityfunctions.validationEquals(cityNamesList, propertyValue.getValue("OriginCityNames"));
		utilityfunctions.validationEquals(originState, propertyValue.getValue("OriginState"));
		utilityfunctions.validationEquals(originCountry, propertyValue.getValue("OriginCountry"));
		System.out.println("Populated cities are: " + cityNamesList);
		System.out.println("Populated State is: " + originState);
		System.out.println("Populated Country is: " + originCountry);
		utilityfunctions.validationEquals("Multiple cities found, please edit to one", originDetails.selectOneCityMessage());
		System.out.println("Validated for valid US Zip Code");
		
		originDetails.clearMethodById("originZip");
		
		//Test to validate Alphanumeric Canada Zipcode
		originDetails.setOriginZip(propertyValue.getValue("canadaOriginZip"));
		Thread.sleep(2000);
		String CAcityNamesList = originDetails.getOriginCity();
		String CAoriginState = originDetails.getOriginState();
		String CAoriginCountry = originDetails.getOriginCountry();
		
		utilityfunctions.validationEquals(CAcityNamesList, propertyValue.getValue("canadaOriginCity"));
		utilityfunctions.validationEquals(CAoriginState, propertyValue.getValue("canadaOriginState"));
		utilityfunctions.validationEquals(CAoriginCountry, propertyValue.getValue("canadaOriginCountry"));
		System.out.println("Populated cities are: " + CAcityNamesList);
		System.out.println("Populated State is: " + CAoriginState);
		System.out.println("Populated Country is: " + CAoriginCountry);
		utilityfunctions.validationEquals("Multiple cities found, please edit to one", originDetails.selectOneCityMessage());
		System.out.println("Validated for valid alphanumeric Canadian Zip Code");
		
		//Test to validate Origin Zip by passing 7 digit Zipcode
		originDetails.clearMethodById("originZip");
		originDetails.setOriginZip(propertyValue.getValue("7digitOriginZip"));
		utilityfunctions.validationEquals(originDetails.getOriginZip(), propertyValue.getValue("6digitTrimmedOriginZip"));
		System.out.println("Validated for 6 characters in Origin Zip code.");
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		
	}	
	
	@Test(priority=2)
	public void originCityValidation() throws Exception
	{
		try {
		originDetails=new OriginDetails(driver);
		originDetails.setOriginZip(propertyValue.getValue("OrizinZip"));
		cityNamesList = originDetails.getOriginCity();
		String selectOneCity=utilityfunctions.splitFunction(cityNamesList, 1);
		originDetails.setOriginCity(selectOneCity);
		
//		originDetails.setOriginCity(
//				utilityfunctions.splitFunction(cityNamesList, 1)  ---or directly can be written in this way
//				);
		
		String citySelected = originDetails.getOriginCity();
		utilityfunctions.validationEquals(citySelected, selectOneCity);
		System.out.println("User is able to edit City field and select one from multiple cities populated: "+citySelected );
		
		//Test to validate multiple 
		originDetails.clearMethodById("originCity");
		originDetails.setOriginCity(propertyValue.getValue("63charCity"));
		utilityfunctions.validationEquals(originDetails.getOriginCity(), propertyValue.getValue("Trimmed_60charCity"));
		System.out.println("Validated 60 char length on Origin City field");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		
		}

	
	@Test(priority=3)
	public void originStateCountryValidation() throws Exception
	{
		try {
		//Test to verify Origin State field is editable	
		originDetails=new OriginDetails(driver);
		originDetails.setOriginZip(propertyValue.getValue("OrizinZip"));
		originDetails.setOriginState();
		utilityfunctions.validationEquals(originDetails.getOriginState(), propertyValue.getValue("OriginStateNameDropdownIndex1") );
		System.out.println("User is able to edit Origin State field :" + propertyValue.getValue("OriginStateNameDropdownIndex1"));
		
		//Test to verify Origin Country field is editable	
		originDetails.setOriginCountry();
		utilityfunctions.validationEquals(originDetails.getOriginCountry(), propertyValue.getValue("OriginCountryNameDropdownByVisibility") );
		System.out.println("User is able to edit Origin State field :" + propertyValue.getValue("OriginCountryNameDropdownByVisibility"));
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		
		}
	
	@Test(priority=4)
	public void verifyCurrentDate() throws Exception
	{
		try {
			Thread.sleep(3000);
			originDetails=new OriginDetails(driver);
			String systemCurrentDate = utilityfunctions.dateFunction();
			Thread.sleep(3000);
			String applicationPickupDate = originDetails.getPickUpDate();
			Assert.assertEquals(applicationPickupDate, systemCurrentDate);
			System.out.println("Current Date is autopopulated in PickUp Date field while logging into application.");
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	}
	/*
	@Test(priority=5)
	public void verifyNextDateIsEnabled() throws Exception
	{
		try {
			Thread.sleep(3000);
			originDetails=new OriginDetails(driver);
			String systemNextDay = utilityfunctions.nextDay();
			Thread.sleep(3000);
			originDetails.clickPickUpDate();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'"+systemNextDay+"')]")).isDisplayed());
			driver.findElement(By.xpath("//a[contains(text(),'"+systemNextDay+"')]")).click();
			Thread.sleep(2000);
			String pickUpNextDate=originDetails.getPickUpDate();
			Assert.assertTrue(pickUpNextDate.contains(systemNextDay));
			System.out.println("Next Pickup day Date is selected as: " + pickUpNextDate);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	}
	
	@Test(priority=6)
	public void verifyPreviousDateIsDisabled() throws Exception
	{
		try {
			Thread.sleep(3000);
			originDetails=new OriginDetails(driver);
			String systemPreviousDay = utilityfunctions.previousDay();
			String systemCurrentDate = utilityfunctions.dateFunction();
			Thread.sleep(3000);
			originDetails.clickPickUpDate();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+systemPreviousDay+"')]")).isDisplayed());
			System.out.println("Previous day from system current date: " + systemPreviousDay);
			driver.findElement(By.xpath("//span[contains(text(),'"+systemPreviousDay+"')]")).click();
	//		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+systemPreviousDay+"')]")).isEnabled());---doubt
			Thread.sleep(2000);
			String pickUpDate=originDetails.getPickUpDate();
			Assert.assertEquals(pickUpDate,systemCurrentDate);
			System.out.println("Previous dates are disabled.");
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	}*/
	
	@AfterMethod
	public void close()
	{
		driver.close();
		
	}
}