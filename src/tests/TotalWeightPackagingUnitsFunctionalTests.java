package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		System.setProperty("webdriver.chrome.driver", "./ExternalFiles/"+"/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver=new ChromeDriver(options);
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
		
		//Adding weight to 1st Item
		itemDetails.setWeight1(propertyValue.getValue("weight1"));
		utilityfunctions.validationEquals("0", itemDetails.getTotalShipmentWeight());
		System.out.println("Weight is given for Item 1 , but as Quanity Field is Blank, Total Shipment weight is: " + itemDetails.getTotalShipmentWeight());
		
		//Adding Quantity 1
		itemDetails.setQuantity1(propertyValue.getValue("quantity1"));
		int item1Quantity= Integer.parseInt(propertyValue.getValue("quantity1"));
		int item1Weight= Integer.parseInt(propertyValue.getValue("weight1"));
		int Item1QuantityWeightMultiplied= utilityfunctions.multiply(item1Quantity, item1Weight);
		String totalShipmentWeight = Integer.toString(Item1QuantityWeightMultiplied);
		utilityfunctions.validationEquals(totalShipmentWeight, itemDetails.getTotalShipmentWeight());
		System.out.println("Total Shipment Weight is total no of Quantiy multiplied with total no of Weight in 1st Item.");
		
		//Adding 2nd Item Weight and Quantity
		itemDetails.clickAdditemBtn();
		itemDetails.setQuantity2(propertyValue.getValue("quantity2"));
		itemDetails.setWeight2(propertyValue.getValue("weight2"));
		int item2Quantity= Integer.parseInt(propertyValue.getValue("quantity2"));
		int item2Weight=Integer.parseInt(propertyValue.getValue("weight2"));
		int Item2quantityWeightMultiplied= utilityfunctions.multiply(item2Quantity, item2Weight);
		
		int shipmentWeight= utilityfunctions.add(Item1QuantityWeightMultiplied, Item2quantityWeightMultiplied);
		totalShipmentWeight = Integer.toString(shipmentWeight);
		utilityfunctions.validationEquals(totalShipmentWeight, itemDetails.getTotalShipmentWeight());
		System.out.println("Total Shipment Weight is sum of total no of Quantiy multiplied with total no of Weight in 1st Item and  2nd item.");
		
		//Adding 3rd Item Weight and Quantity
		itemDetails.clickAdditemBtn();
		itemDetails.setQuantity3(propertyValue.getValue("quantity3"));
		itemDetails.setWeight3(propertyValue.getValue("weight3"));
		int item3Quantity= Integer.parseInt(propertyValue.getValue("quantity3"));
		int item3Weight=Integer.parseInt(propertyValue.getValue("weight3"));
		int Item3quantityWeightMultiplied= utilityfunctions.multiply(item3Quantity, item3Weight);
		
		shipmentWeight= utilityfunctions.add(shipmentWeight, Item3quantityWeightMultiplied);
		totalShipmentWeight = Integer.toString(shipmentWeight);
		utilityfunctions.validationEquals(totalShipmentWeight, itemDetails.getTotalShipmentWeight());
		System.out.println("Total Shipment Weight is sum of total no of Quantiy multiplied with total no of Weight in 1st Item, 2nd item, 3rd Item.");
		
		//Adding 4th Item Weight and Quantity
		itemDetails.clickAdditemBtn();
		itemDetails.setQuantity4(propertyValue.getValue("quantity4"));
		itemDetails.setWeight4(propertyValue.getValue("weight4"));
		int item4Quantity= Integer.parseInt(propertyValue.getValue("quantity4"));
		int item4Weight=Integer.parseInt(propertyValue.getValue("weight4"));
		int Item4quantityWeightMultiplied= utilityfunctions.multiply(item4Quantity, item4Weight);
		
		shipmentWeight= utilityfunctions.add(shipmentWeight, Item4quantityWeightMultiplied);
		totalShipmentWeight = Integer.toString(shipmentWeight);
		utilityfunctions.validationEquals(totalShipmentWeight, itemDetails.getTotalShipmentWeight());
		System.out.println("Total Shipment Weight is sum of total no of Quantiy multiplied with total no of Weight in 1st Item, 2nd item, 3rd Item, 4th Item.");
		
		//Adding 4th Item Weight and Quantity
		itemDetails.clickAdditemBtn();
		itemDetails.setQuantity5(propertyValue.getValue("quantity5"));
		itemDetails.setWeight5(propertyValue.getValue("weight5"));
		int item5Quantity= Integer.parseInt(propertyValue.getValue("quantity5"));
		int item5Weight=Integer.parseInt(propertyValue.getValue("weight5"));
		int Item5quantityWeightMultiplied= utilityfunctions.multiply(item5Quantity, item5Weight);
		
		shipmentWeight= utilityfunctions.add(shipmentWeight, Item5quantityWeightMultiplied);
		totalShipmentWeight = Integer.toString(shipmentWeight);
		utilityfunctions.validationEquals(totalShipmentWeight, itemDetails.getTotalShipmentWeight());
		System.out.println("Total Shipment Weight is sum of total no of Quantiy multiplied with total no of Weight in 1st Item, 2nd item, 3rd Item, 4th Item and 5th item.");
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
