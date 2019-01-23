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


/**
 * Class containing TestCases related to Item Details section.
 * @author nutan.p
 *
 */
public class ItemDetailsTests {

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
	public void validQuantityFieldValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setQuantity(propertyValue.getValue("validQuantity1"));
		Thread.sleep(2000);
		itemDetails.clearMethodByXpath("//input[@placeholder='Enter Quantity']");
		itemDetails.setQuantity(propertyValue.getValue("validQuantity2"));
		Thread.sleep(2000);
		itemDetails.clearMethodByXpath("//input[@placeholder='Enter Quantity']");
		itemDetails.setQuantity(propertyValue.getValue("validQuantity3"));
		Thread.sleep(2000);
		itemDetails.clearMethodByXpath("//input[@placeholder='Enter Quantity']");
		itemDetails.setQuantity(propertyValue.getValue("validQuantity4"));
		Thread.sleep(2000);
		System.out.println("Validated Quantity field with Valid Inputs");
		
	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		}
	
	@Test(priority=2)
	public void invalidQuantityFieldValidations() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setQuantity(propertyValue.getValue("invalidQuantity1"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getQuantityErrorMsg());
		itemDetails.clearMethodByXpath("//input[@placeholder='Enter Quantity']");
		itemDetails.setQuantity(propertyValue.getValue("invalidQuantity2"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getQuantityErrorMsg());
		itemDetails.clearMethodByXpath("//input[@placeholder='Enter Quantity']");
		itemDetails.setQuantity(propertyValue.getValue("invalidQuantity3"));
		Thread.sleep(2000);
		utilityfunctions.validationEquals("", itemDetails.getQuantity());
		System.out.println("Validated Quantity field with invalid values");
	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		}
	
	@Test(priority=3)
	public void packagingTypeValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		String packagingBasket=itemDetails.setPackagingTypeBasket();
		utilityfunctions.validationEquals(packagingBasket, "Basket");
		System.out.println("Packaging Type selected as Basket.");
		String packagingContainer= itemDetails.setPackagingTypeContainer();
		utilityfunctions.validationEquals(packagingContainer,"Container");
		System.out.println("Packaging Type selected as Container.");
	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		}	
	
	@Test(priority=4)
	public void classFieldValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		String class85=itemDetails.setClass85();
		utilityfunctions.validationEquals(class85, "85");
		System.out.println("Class selected as 85.");
		String class400= itemDetails.setClass400();
		utilityfunctions.validationEquals(class400,"400");
		System.out.println("Class selected as 400.");
	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		}	
	
	@Test(priority=5)
	public void stackableFieldValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		String stackableYes=itemDetails.setStackableYes();
		utilityfunctions.validationEquals(stackableYes, "Yes");
		System.out.println("Stackable selected as Yes.");
		String stackableNo= itemDetails.setStackableNo();
		utilityfunctions.validationEquals(stackableNo,"No");
		System.out.println("Stackable selected as No.");
	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		}	
	
	@Test(priority=6)
	public void validLengthFieldValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setLength(propertyValue.getValue("validLength1"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemlength_1");
		itemDetails.setLength(propertyValue.getValue("validLength2"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemlength_1");
		itemDetails.setLength(propertyValue.getValue("validLength3"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemlength_1");
		itemDetails.setLength(propertyValue.getValue("validLength4"));
		Thread.sleep(2000);
		System.out.println("Validated Length field with Valid Inputs");
	
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		}
	
	@Test(priority=7)
	public void invalidLengthFieldValidations() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setLength(propertyValue.getValue("invalidLength1"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getLengthErrorMsg());
		itemDetails.clearMethodByName("vltl_itemlength_1");
		itemDetails.setLength(propertyValue.getValue("invalidLength2"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getLengthErrorMsg());
		itemDetails.clearMethodByName("vltl_itemlength_1");
		itemDetails.setLength(propertyValue.getValue("invalidLength3"));
		Thread.sleep(2000);
		utilityfunctions.validationEquals("", itemDetails.getLength());
		System.out.println("Validated Length field with invalid values");
	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		}
	
	@Test(priority=8)
	public void validWidthFieldValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setWidth(propertyValue.getValue("validWidth1"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemwidth_1");
		itemDetails.setWidth(propertyValue.getValue("validWidth2"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemwidth_1");
		itemDetails.setWidth(propertyValue.getValue("validWidth3"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemwidth_1");
		itemDetails.setWidth(propertyValue.getValue("validWidth4"));
		Thread.sleep(2000);
		System.out.println("Validated Width field with Valid Inputs");
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		}
	
	@Test(priority=9)
	public void invalidWidthFieldValidations() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setWidth(propertyValue.getValue("invalidWidth1"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getWidthErrorMsg());
		itemDetails.clearMethodByName("vltl_itemwidth_1");
		itemDetails.setWidth(propertyValue.getValue("invalidWidth2"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getWidthErrorMsg());
		itemDetails.clearMethodByName("vltl_itemwidth_1");
		itemDetails.setWidth(propertyValue.getValue("invalidWidth3"));
		Thread.sleep(2000);
		utilityfunctions.validationEquals("", itemDetails.getWidth());
		System.out.println("Validated Width field with invalid values");
	
		
		}	catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}	
	}

	@Test(priority=10)
	public void validHeightFieldValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setHeight(propertyValue.getValue("validHeight1"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemheight_1");
		itemDetails.setHeight(propertyValue.getValue("validHeight2"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemheight_1");
		itemDetails.setHeight(propertyValue.getValue("validHeight3"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemheight_1");
		itemDetails.setHeight(propertyValue.getValue("validHeight4"));
		Thread.sleep(2000);
		System.out.println("Validated Height field with Valid Inputs");
	}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	}
	
	
	@Test(priority=11)
	public void invalidHeightFieldValidations() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setHeight(propertyValue.getValue("invalidHeight1"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getHeightErrorMsg());
		itemDetails.clearMethodByName("vltl_itemheight_1");
		itemDetails.setHeight(propertyValue.getValue("invalidHeight2"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getHeightErrorMsg());
		itemDetails.clearMethodByName("vltl_itemheight_1");
		itemDetails.setHeight(propertyValue.getValue("invalidHeight3"));
		Thread.sleep(2000);
		utilityfunctions.validationEquals("", itemDetails.getHeight());
		System.out.println("Validated Height field with invalid values");
	}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	}
	
	@Test(priority=12)
	public void validWeightFieldValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setWeight(propertyValue.getValue("validWeight1"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemweight_1");
		itemDetails.setWeight(propertyValue.getValue("validWeight2"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemweight_1");
		itemDetails.setWeight(propertyValue.getValue("validWeight3"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemweight_1");
		itemDetails.setWeight(propertyValue.getValue("validWeight4"));
		Thread.sleep(2000);
		System.out.println("Validated Weight field with Valid Inputs");
	}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
}
	
	@Test(priority=13)
	public void invalidWeightFieldValidations() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setWeight(propertyValue.getValue("invalidWeight1"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getWeightErrorMsg());
		itemDetails.clearMethodByName("vltl_itemweight_1");
		itemDetails.setWeight(propertyValue.getValue("invalidWeight2"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getWeightErrorMsg());
		itemDetails.clearMethodByName("vltl_itemweight_1");
		itemDetails.setWeight(propertyValue.getValue("invalidWeight3"));
		Thread.sleep(2000);
		utilityfunctions.validationEquals("", itemDetails.getWeight());
		System.out.println("Validated Height field with invalid values");
	}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	}
	
	@Test(priority=14)
	public void validCommodityFieldValidation() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setCommodity(propertyValue.getValue("validCommodity4char"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemdescription_1");
		itemDetails.setCommodity(propertyValue.getValue("validCommodity5char"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemdescription_1");
		itemDetails.setCommodity(propertyValue.getValue("validCommodity254char"));
		Thread.sleep(2000);
		itemDetails.clearMethodByName("vltl_itemdescription_1");
		itemDetails.setCommodity(propertyValue.getValue("validCommodity255char"));
		Thread.sleep(2000);
		System.out.println("Validated Commodity Description field with Valid Inputs");
	}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	}
	
	@Test(priority=15)
	public void invalidCommodityFieldValidations() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.setCommodity(propertyValue.getValue("invalidCommodity3char"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getCommodityErrorMsg());
		itemDetails.clearMethodByName("vltl_itemdescription_1");
		itemDetails.setCommodity(propertyValue.getValue("invalidCommodity1char"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getCommodityErrorMsg());
		itemDetails.clearMethodByName("vltl_itemdescription_1");
		itemDetails.setCommodity(propertyValue.getValue("invalidCommodity256char"));
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(itemDetails.getCommodityErrorMsg());
		System.out.println("Validated Commodity Description field with invalid values");
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
