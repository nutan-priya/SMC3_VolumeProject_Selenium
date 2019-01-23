package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ItemDetails;
import pages.Login;
import utilities.CommonFunctions;
import utilities.ExceptionalHandlingFunctions;
import utilities.PropertyFileUtility;

public class TotalWeightPackagingUnitsFunctionalTests {
	WebDriver driver;
	Login loginToApplication;
	ItemDetails itemDetails;

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
	public void totalPackagingUnitValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		utilityfunctions.validationEquals("0", itemDetails.getTotalPackagingUnit());
		System.out.println("Validated that, while launching the application, initially Total Packaging Units is 0.");
		
		itemDetails.setQuantity1(propertyValue.getValue("quantity1"));
		utilityfunctions.validationEquals(propertyValue.getValue("quantity1"), itemDetails.getTotalPackagingUnit());
		int item1Quantity= Integer.parseInt(propertyValue.getValue("quantity1"));
		itemDetails.clickAdditemBtn();
		itemDetails.setQuantity2(propertyValue.getValue("quantity2"));
		int item2Quantity=Integer.parseInt(propertyValue.getValue("quantity2"));
		int packagingUnit= utilityfunctions.add(item1Quantity, item2Quantity);
		String totalPackagingUnit = Integer.toString(packagingUnit);
		utilityfunctions.validationEquals(totalPackagingUnit, itemDetails.getTotalPackagingUnit());
		itemDetails.clickAdditemBtn();
		itemDetails.setQuantity3(propertyValue.getValue("quantity3"));
		int item3Quantity=Integer.parseInt(propertyValue.getValue("quantity3"));
		packagingUnit = (utilityfunctions.add(packagingUnit, item3Quantity));
		totalPackagingUnit = Integer.toString(packagingUnit);
		utilityfunctions.validationEquals(totalPackagingUnit, itemDetails.getTotalPackagingUnit());
		itemDetails.clickAdditemBtn();
		itemDetails.setQuantity4(propertyValue.getValue("quantity4"));
		int item4Quantity=Integer.parseInt(propertyValue.getValue("quantity4"));
		packagingUnit = (utilityfunctions.add(packagingUnit, item4Quantity));
		totalPackagingUnit = Integer.toString(packagingUnit);
		utilityfunctions.validationEquals(totalPackagingUnit, itemDetails.getTotalPackagingUnit());
		itemDetails.clickAdditemBtn();
		itemDetails.setQuantity5(propertyValue.getValue("quantity5"));
		int item5Quantity=Integer.parseInt(propertyValue.getValue("quantity5"));
		packagingUnit = (utilityfunctions.add(packagingUnit, item5Quantity));
		totalPackagingUnit = Integer.toString(packagingUnit);
		utilityfunctions.validationEquals(totalPackagingUnit, itemDetails.getTotalPackagingUnit());
		System.out.println("Total Packaging Unit: " + itemDetails.getTotalPackagingUnit());
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		

		}
	
	
	@Test(priority=2)
	public void totalShipmentWeightValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		utilityfunctions.validationEquals("0", itemDetails.getTotalShipmentWeight());
		System.out.println("Validated that, while launching the application, initially Total shipment weight is 0.");
		
		itemDetails.setWeight1(propertyValue.getValue("weight1"));
		utilityfunctions.validationEquals(propertyValue.getValue("weight1"), itemDetails.getTotalShipmentWeight());
		int item1Weight= Integer.parseInt(propertyValue.getValue("weight1"));
		itemDetails.clickAdditemBtn();
		itemDetails.setWeight2(propertyValue.getValue("weight2"));
		int item2Weight=Integer.parseInt(propertyValue.getValue("weight2"));
		int shipmentWeight= utilityfunctions.add(item1Weight, item2Weight);
		String totalShipmentWeight = Integer.toString(shipmentWeight);
		utilityfunctions.validationEquals(totalShipmentWeight, itemDetails.getTotalShipmentWeight());
		itemDetails.clickAdditemBtn();
		itemDetails.setWeight3(propertyValue.getValue("weight3"));
		int item3Weight=Integer.parseInt(propertyValue.getValue("weight3"));
		shipmentWeight = (utilityfunctions.add(shipmentWeight, item3Weight));
		totalShipmentWeight = Integer.toString(shipmentWeight);
		utilityfunctions.validationEquals(totalShipmentWeight, itemDetails.getTotalShipmentWeight());
		itemDetails.clickAdditemBtn();
		itemDetails.setWeight4(propertyValue.getValue("weight4"));
		int item4Weight=Integer.parseInt(propertyValue.getValue("weight4"));
		shipmentWeight = (utilityfunctions.add(shipmentWeight, item4Weight));
		totalShipmentWeight = Integer.toString(shipmentWeight);
		utilityfunctions.validationEquals(totalShipmentWeight, itemDetails.getTotalShipmentWeight());
		itemDetails.clickAdditemBtn();
		itemDetails.setWeight5(propertyValue.getValue("weight5"));
		int item5Weight=Integer.parseInt(propertyValue.getValue("weight5"));
		shipmentWeight = (utilityfunctions.add(shipmentWeight, item5Weight));
		totalShipmentWeight = Integer.toString(shipmentWeight);
		utilityfunctions.validationEquals(totalShipmentWeight, itemDetails.getTotalShipmentWeight());
		System.out.println("Total Shipment Weight: " + itemDetails.getTotalShipmentWeight());
	
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
