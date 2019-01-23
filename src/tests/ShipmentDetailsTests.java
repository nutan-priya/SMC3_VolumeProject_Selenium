package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Login;
import pages.ShipmentDetails;
import utilities.CommonFunctions;
import utilities.ExceptionalHandlingFunctions;
import utilities.PropertyFileUtility;

public class ShipmentDetailsTests {

	WebDriver driver;
	Login loginToApplication;
	ShipmentDetails shipmentDetails;
	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"+"/DataFile.properties");
	CommonFunctions utilityfunctions = new CommonFunctions(driver);
	
	
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
	public void payerFieldValidation() throws Exception 
	{
		try {
		Thread.sleep(3000);
		shipmentDetails = new ShipmentDetails(driver);
		String payerConsignee=shipmentDetails.setPayerConsignee();
		utilityfunctions.validationEquals(payerConsignee , "Consignee");
		System.out.println("Payer selected as Consignee.");
		String payerShipper=shipmentDetails.setPayerShipper();
		utilityfunctions.validationEquals(payerShipper , "Shipper");
		System.out.println("Payer selected as Shipper.");
		String payerThirdParty=shipmentDetails.setPayerThirdParty();
		utilityfunctions.validationEquals(payerThirdParty , "Third Party");
		System.out.println("Payer selected as Third Party.");

		}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	}
	
	@Test(priority=2)
	public void paymentTermsFieldValidation() throws Exception 
	{
		try {
		Thread.sleep(3000);
		shipmentDetails = new ShipmentDetails(driver);
		String paymentPrepaid=shipmentDetails.setPaymentTermsPrepaid();
		utilityfunctions.validationEquals(paymentPrepaid , "Prepaid");
		System.out.println("Payment Terms selected as Prepaid.");
		String paymentCollect=shipmentDetails.setPaymentTermsCollect();
		utilityfunctions.validationEquals(paymentCollect , "Collect");
		System.out.println("Payment Terms selected as Collect.");
		String paymentThirdParty=shipmentDetails.setPaymentTermsThirdParty();
		utilityfunctions.validationEquals(paymentThirdParty , "Third Party");
		System.out.println("Payment Terms selected as Third Party.");
		String paymentOther=shipmentDetails.setPaymentTermsOther();
		utilityfunctions.validationEquals(paymentOther , "Other");
		System.out.println("Payment Terms selected as Other");
	  
		}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
		
	}
	
	@Test(priority=3)
	public void validLinearFeetValidation() throws Exception
	{
		try {
		shipmentDetails = new ShipmentDetails(driver);
		shipmentDetails.setTotalLinearFeet(propertyValue.getValue("validLinearFt1"));
		Thread.sleep(2000);
		//utilityfunctions.validationIsEmpty(shipmentDetails.getNoMessageforValidInput());---positive assertion
		shipmentDetails.clearMethodByName("vltl_totallinearfeet");
		shipmentDetails.setTotalLinearFeet(propertyValue.getValue("validLinearFt2"));
		Thread.sleep(2000);
		shipmentDetails.clearMethodByName("vltl_totallinearfeet");
		shipmentDetails.setTotalLinearFeet(propertyValue.getValue("validLinearFt3"));
		Thread.sleep(2000);
		shipmentDetails.clearMethodByName("vltl_totallinearfeet");
		shipmentDetails.setTotalLinearFeet(propertyValue.getValue("validLinearFt4"));
		Thread.sleep(2000);
		System.out.println("Validated Linear feet field with valid values ");

		}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	}
	
	
	@Test(priority=4)
	public void invalidLinearFeetValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		shipmentDetails = new ShipmentDetails(driver);
		shipmentDetails.setTotalLinearFeet(propertyValue.getValue("invalidLinearFt1"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(shipmentDetails.getLengthLinearFtErrorMessage());
		shipmentDetails.clearMethodByName("vltl_totallinearfeet");
		shipmentDetails.setTotalLinearFeet(propertyValue.getValue("invalidLinearFt2"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(shipmentDetails.getLengthLinearFtErrorMessage());
		shipmentDetails.clearMethodByName("vltl_totallinearfeet");
		shipmentDetails.setTotalLinearFeet(propertyValue.getValue("invalidLinearFt3"));
		Thread.sleep(2000);
		utilityfunctions.validationEquals("", shipmentDetails.getTotalLinearFeet());
		System.out.println("Validated Linear feet field with invalid values");
		
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
