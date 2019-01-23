package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import pages.DestinationDetails;
import pages.Login;
import utilities.CommonFunctions;
import utilities.ExceptionalHandlingFunctions;
import utilities.PropertyFileUtility;

public class DestinationDetailsValidationTests {

	WebDriver driver;
	Login loginToApplication;
	DestinationDetails destinationDetails;
	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"+"/DataFile.properties");
	CommonFunctions utilityfunctions = new CommonFunctions(driver);
	
	String cityNamesList;
	String destinationState;
	String destinationCountry;
	
	
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
	public void destinationZipValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		destinationDetails=new DestinationDetails(driver);
		
	//Test to validate US zipcode having 5 characters and error message to select one city.	
		destinationDetails.setDestinationZip(propertyValue.getValue("DestinationZip"));
		Thread.sleep(2000);
		cityNamesList = destinationDetails.getDestinationCity();
		destinationState = destinationDetails.getDestinationState();
		destinationCountry = destinationDetails.getDestinationCountry();
		
		utilityfunctions.validationEquals(cityNamesList, propertyValue.getValue("DestinationCityNames"));
		utilityfunctions.validationEquals(destinationState, propertyValue.getValue("DestinationState"));
		utilityfunctions.validationEquals(destinationCountry, propertyValue.getValue("DestinationCountry"));
		System.out.println("Populated cities are: " + cityNamesList);
		System.out.println("Populated State is: " + destinationState);
		System.out.println("Populated Country is: " + destinationCountry);
		utilityfunctions.validationEquals("Multiple cities found, please edit to one", destinationDetails.selectOneCityMessage());
		System.out.println("Validated for valid US Zip Code");
		
		destinationDetails.clearMethodById("destinationZip");
		
		//Test to validate Alphanumeric Canada Zipcode
		destinationDetails.setDestinationZip(propertyValue.getValue("canadaDestinationZip"));
		Thread.sleep(2000);
		String CAcityNamesList = destinationDetails.getDestinationCity();
		String CAoriginState = destinationDetails.getDestinationState();
		String CAoriginCountry = destinationDetails.getDestinationCountry();
		
		utilityfunctions.validationEquals(CAcityNamesList, propertyValue.getValue("canadaDestinationCity"));
		utilityfunctions.validationEquals(CAoriginState, propertyValue.getValue("canadaDestinationState"));
		utilityfunctions.validationEquals(CAoriginCountry, propertyValue.getValue("canadaDestinationCountry"));
		System.out.println("Populated cities are: " + CAcityNamesList);
		System.out.println("Populated State is: " + CAoriginState);
		System.out.println("Populated Country is: " + CAoriginCountry);
		utilityfunctions.validationEquals("Multiple cities found, please edit to one", destinationDetails.selectOneCityMessage());
		System.out.println("Validated for valid alphanumeric Canadian Zip Code");
		
		//Test to validate Origin Zip by passing 7 digit Zipcode
		destinationDetails.clearMethodById("destinationZip");
		destinationDetails.setDestinationZip(propertyValue.getValue("7digitOriginZip"));
		utilityfunctions.validationEquals(destinationDetails.getDestinationZip(), propertyValue.getValue("6digitTrimmedDestinationZip"));
		System.out.println("Validated for 6 characters in Origin Zip code.");
		}
		catch (Exception e) {
			System.out.println(e);
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}	
	
	@Test(priority=2)
	public void originCityValidation() throws Exception
	{
		try {
		destinationDetails=new DestinationDetails(driver);
		destinationDetails.setDestinationZip(propertyValue.getValue("DestinationZip"));
		cityNamesList = destinationDetails.getDestinationCity();
		String selectOneCity=utilityfunctions.splitFunction(cityNamesList, 1);
		destinationDetails.setDestinationCity(selectOneCity);
		
		String citySelected = destinationDetails.getDestinationCity();
		utilityfunctions.validationEquals(citySelected, selectOneCity);
		System.out.println("User is able to edit City field and select one from multiple cities populated: "+citySelected );
		
		//Test to validate multiple 
		destinationDetails.clearMethodById("destinationZip");
		destinationDetails.setDestinationCity(propertyValue.getValue("63charCity"));
		utilityfunctions.validationEquals(destinationDetails.getDestinationCity(), propertyValue.getValue("Trimmed_60charCity"));
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
		destinationDetails=new DestinationDetails(driver);
		destinationDetails.setDestinationZip(propertyValue.getValue("DestinationZip"));
		destinationDetails.setDestinationState();
		utilityfunctions.validationEquals(destinationDetails.getDestinationState(), propertyValue.getValue("DestinationStateNameDropdownIndex1") );
		System.out.println("User is able to edit Origin State field :" + propertyValue.getValue("DestinationStateNameDropdownIndex1"));
		
		//Test to verify Origin Country field is editable	
		destinationDetails.setDestinationCountry();
		utilityfunctions.validationEquals(destinationDetails.getDestinationCountry(), propertyValue.getValue("DestinationCountryNameDropdownByVisibility") );
		System.out.println("User is able to edit Origin State field :" + propertyValue.getValue("DestinationCountryNameDropdownByVisibility"));
		
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
		
	}
}