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

public class ShipmentSummaryFunctionalTest {

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
	
	@Test(priority=1)
	public void getQuoteWithAllFieldBlank() throws Exception
	{
		try {
		Thread.sleep(3000);
		originDetails=new OriginDetails(driver);
		destinationDetails=new DestinationDetails(driver);
		shipmentDetails = new ShipmentDetails(driver);
		itemDetails=new ItemDetails(driver);
		accessorialDetails = new Accessorials(driver);
		shipmentSummary = new ShipmentSummary(driver);
		
		//Test to Click on Get Quote Button with out filling any data in any of the field. All fields should be mandatory.
		shipmentSummary.GetQuote();
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='originZip' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='originCity' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//select[@id='originState' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//select[@id='originCountry' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='destinationZip' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='destinationCity' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//select[@id='destinationState' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//select[@id='destinationCountry' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//select[@name='vltl_payer' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//select[@name='vltl_paymentterms' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter Linear Feet' and @class='has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter Quantity' and @class='itemQty has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//select[@name='vltl_itempackagingtype_1' and @class='packagingType has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//select[@name='vltl_itemclass_1' and @class='itemClass has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//select[@name='vltl_itemstackable_1' and @class='itemStackable has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter Length' and @class='itemLength has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter Width' and @class='itemWidth has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter Height' and @class='itemHeight has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter Weight' and @class='itemWeight has-error']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter Description' and @class='itemDescription has-error']")).isDisplayed());
		System.out.println("Verified that all the fields are mandatory to be filled with data.");
		} catch (Exception e) {
			System.out.println("Fail");
			System.out.println(e);
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		
	}
	
	
	//Test to verify the Shipment Summary section  in the screen2 without the item details.
	@Test (priority=2)
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
		String originZip= originDetails.getOriginZip();
		cityNamesList = originDetails.getOriginCity();
		String selectOneOriginCity=utilityfunctions.splitFunction(cityNamesList, 1);
		originDetails.setOriginCity(selectOneOriginCity);
		String originState= originDetails.getOriginState();
		String originCountry= originDetails.getOriginCountry();
		
		destinationDetails.setDestinationZip(propertyValue.getValue("DestinationZip"));
		Thread.sleep(2000);
		String DestinationZip= destinationDetails.getDestinationZip();
		cityNamesList = destinationDetails.getDestinationCity();
		String selectOneDestinationCity=utilityfunctions.splitFunction(cityNamesList, 1);
		destinationDetails.setDestinationCity(selectOneDestinationCity);
		String destinationState = destinationDetails.getDestinationState();
		String destinationCountry = destinationDetails.getDestinationCountry();
		String payerConsignee=shipmentDetails.setPayerConsignee();
		String paymentPrepaid=shipmentDetails.setPaymentTermsPrepaid();
		shipmentDetails.setTotalLinearFeet(propertyValue.getValue("validLinearFt1"));
		String LinearFt= shipmentDetails.getTotalLinearFeet();
		itemDetails.setQuantity(propertyValue.getValue("validQuantity1"));
		String getQuantity = itemDetails.getQuantity();
		String packagingBasket=itemDetails.setPackagingTypeBasket();
		String class85=itemDetails.setClass85();
		String stackableYes=itemDetails.setStackableYes();
		itemDetails.setLength(propertyValue.getValue("validLength1"));
		String Length= itemDetails.getLength();
		itemDetails.setWidth(propertyValue.getValue("validWidth1"));
		String Width= itemDetails.getWidth();
		itemDetails.setHeight(propertyValue.getValue("validHeight1"));
		String Height= itemDetails.getHeight();
		String Dimension = Length+"*"+Width+"*"+Height;
		System.out.println("The Dimension of the item is: " + Dimension);
		System.out.println("Pass");
		itemDetails.setWeight(propertyValue.getValue("validWeight1"));
		itemDetails.setCommodity(propertyValue.getValue("validCommodity4char"));
		System.out.println("Pass");
		String Accessorials = accessorialDetails.setConstructionDelivery();
		String totalPackagingUnit= itemDetails.getTotalPackagingUnit();
		String totalShipmentWeight= itemDetails.getTotalShipmentWeight();
		
		shipmentSummary.GetQuote();
		Thread.sleep(16000);
		
		//Verifying all the sections in Screen2, whether the data provided in screen 1 are reflected in screen 2 or not.
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.ShipmentSummaryHeader));
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.OriginHeader));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+originZip+"')]")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+selectOneOriginCity+"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+originState+"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+originCountry+"')]")).isDisplayed());
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.DestinationHeader));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+DestinationZip+"')]")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+selectOneDestinationCity+"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+destinationState+"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+destinationCountry+"')]")).isDisplayed());
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.PayerHeader));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+payerConsignee+"')]")).isDisplayed());
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.PaymentTermsHeader));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+paymentPrepaid+"')]")).isDisplayed());
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.TotalLinearFTHeader));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+LinearFt+"')]")).isDisplayed());
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.TotalPackagingUnitsHeader));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+totalPackagingUnit+"')]")).isDisplayed());
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.TotalShipmentWeightHeader));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+totalShipmentWeight+"')]")).isDisplayed());
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.AccessorialsHeader));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+Accessorials+"')]")).isDisplayed());
		System.out.println("Verified all the details under Shipment Summary section.");
		
		//Verifying the item details section
		Assert.assertTrue(driver.findElement(By.xpath("//tr[1]/td[contains(text(),'ITEM No. 1')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//tr[1]/td[contains(text(),'"+getQuantity+"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//tr[1]/td[contains(text(),'"+packagingBasket+"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//tr[1]/td[contains(text(),'"+class85+"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//tr[1]/td[contains(text(),'"+stackableYes+"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//tr[1]/td[contains(text(),'"+Dimension+"')]")).isDisplayed());
		System.out.println("Verified all the item details in the Second screen.");
		
		//Verifying the Carrier section
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.carrierWithExceptionHeader));
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.carrierWithOutExceptionHeader));
		
		//Verifying the Carrier 'UPS Ground Freight' populated in Carrier Quotes without Exception
		Assert.assertTrue(driver.findElement(By.xpath("//table[@class='vltl_items-grid vltl_grid-carrier']//tbody//tr//td[contains(text(),'UPS Ground Freight')]")).isDisplayed());
		System.out.println("Carrier name has got populated under Carrier Quotes without Exception.");
		
		//Verifying the Carrier 'Holland' populated in Carrier Quotes without Exception
		Assert.assertTrue(driver.findElement(By.xpath("//table[@class='vltl_items-grid']//tbody//tr//td[contains(text(),'Holland')]")).isDisplayed());
		utilityfunctions.isElementDisplayed(driver.findElement(shipmentSummary.carrierNameUPSGroundFrght));
		System.out.println("Carrier name has got populated under Carrier Quotes with Exception.");
		
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


