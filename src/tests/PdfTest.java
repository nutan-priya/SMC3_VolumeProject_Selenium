package tests;


import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Accessorials;
import pages.DestinationDetails;
import pages.ItemDetails;
import pages.Login;
import pages.OriginDetails;
import pages.ShipmentDetails;
import pages.ShipmentSummary;
import utilities.CommonFunctions;
import utilities.ExceptionalHandlingFunctions;
import utilities.PropertyFileUtility;

public class PdfTest {

	WebDriver driver;
	Login loginToApplication;
	OriginDetails originDetails;
	DestinationDetails destinationDetails;
	ShipmentDetails shipmentDetails;
	ItemDetails itemDetails;
	Accessorials accessorialDetails;
	ShipmentSummary shipmentSummary;
	String cityNamesList;
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
	
	
	//Test to verify Edit Shipment functionality.
	@Test (priority=1)
	public void getQuoteFunctionalityTest() throws Exception
	{
		
		try {
		Thread.sleep(3000);
		originDetails=new OriginDetails(driver);
		destinationDetails=new DestinationDetails(driver);
		shipmentDetails = new ShipmentDetails(driver);
		itemDetails=new ItemDetails(driver);
		accessorialDetails = new Accessorials(driver);
		shipmentDetails = new ShipmentDetails(driver);
		shipmentSummary = new ShipmentSummary(driver);
		
		//Filling up all the fields in Screen 1
		originDetails.setOriginZip(propertyValue.getValue("OrizinZip"));
		Thread.sleep(2000);
		cityNamesList = originDetails.getOriginCity();
		String selectOneOriginCity=utilityfunctions.splitFunction(cityNamesList, 1);
		originDetails.setOriginCity(selectOneOriginCity);
				
		destinationDetails.setDestinationZip(propertyValue.getValue("DestinationZip"));
		Thread.sleep(2000);
		cityNamesList = destinationDetails.getDestinationCity();
		String selectOneDestinationCity=utilityfunctions.splitFunction(cityNamesList, 1);
		destinationDetails.setDestinationCity(selectOneDestinationCity);
		
		shipmentDetails.setPayerConsignee();
		shipmentDetails.setPaymentTermsPrepaid();
		shipmentDetails.setTotalLinearFeet(propertyValue.getValue("validLinearFt1"));
		itemDetails.setQuantity(propertyValue.getValue("validQuantity1"));
		itemDetails.setPackagingTypeBasket();
		itemDetails.setClass85();
		itemDetails.setStackableYes();
		itemDetails.setLength(propertyValue.getValue("validLength1"));
		itemDetails.setWidth(propertyValue.getValue("validWidth1"));
		itemDetails.setHeight(propertyValue.getValue("validHeight1"));
		itemDetails.setWeight(propertyValue.getValue("validWeight1"));
		itemDetails.setCommodity(propertyValue.getValue("validCommodity4char"));
		
		accessorialDetails.setConstructionDelivery();
		
		
		shipmentSummary.GetQuote();
		Thread.sleep(25000);
		
		shipmentSummary.clickSelectBtn();
		shipmentSummary.clickDownloadPDF();
		shipmentSummary.clickSelectBtn();
		utilityfunctions.isElementDisplayed(driver.findElement(ShipmentSummary.popUpDialogTitle));
		utilityfunctions.isElementDisplayed(driver.findElement(ShipmentSummary.downloadPDF));
		utilityfunctions.isElementDisplayed(driver.findElement(ShipmentSummary.cancelBtn));
		
		System.out.println("Verified the PDF button and download pdf dialog box.");
		
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


