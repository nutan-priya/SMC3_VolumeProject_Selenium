package tests;

import org.openqa.selenium.By;
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

public class ItemAddDeleteFunctionalityTests {
	
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

//Test to verify Add item button is present and Delete Item is Not present for One Item
	@Test(priority=1)
	public void verifyAddItemBtn() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		utilityfunctions.isElementDisplayed(driver.findElement(itemDetails.AddItemBtn));
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='deleteItem' and @style='display: none;']")).isDisplayed());
		System.out.println("Verified Add Button and on single item, there is no Delete Button.");
	
		}	catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		
	}
//Test to verify clicking on Add Item, Adds 2nd Item and Delete button added to both the item section.
	@Test(priority=2)
	public void clickAddItemOnce() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.clickAdditemBtn();
		Thread.sleep(2000);
		utilityfunctions.isElementDisplayed(driver.findElement(itemDetails.ItemNo1Header));
		utilityfunctions.isElementDisplayed(driver.findElement(itemDetails.ItemNo2Header));
		utilityfunctions.isElementDisplayed(driver.findElement(itemDetails.DeleteItemBtn1));
		utilityfunctions.isElementDisplayed(driver.findElement(itemDetails.DeleteItemBtn2));
		utilityfunctions.isElementDisplayed(driver.findElement(itemDetails.AddItemBtn));
		
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@id='addItemBtn' and @style='display: block;']")).isDisplayed());---why cannot use this
		System.out.println("Verified clicking on Add Item, Adds 2nd Item and Delete button added to both the item section.");
	
		}catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	}
	
	
	//Test to verify clicking on Add Item 5 times, Adds 5 Item and Delete button gets added to all the item section. Add button gets removed.
	@Test(priority=3)
	public void clickAdd5times() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		itemDetails.clickAdditemBtn();
		Thread.sleep(2000);
		itemDetails.clickAdditemBtn();
		Thread.sleep(2000);
		itemDetails.clickAdditemBtn();
		Thread.sleep(2000);
		itemDetails.clickAdditemBtn();
		Thread.sleep(2000);	
		CommonFunctions utilityfunctions = new CommonFunctions(driver);
		utilityfunctions.isDisplayedBy(itemDetails.ItemNo1Header, true);
		utilityfunctions.isDisplayedBy(itemDetails.ItemNo2Header, true);
		utilityfunctions.isDisplayedBy(itemDetails.ItemNo3Header, true);
		utilityfunctions.isDisplayedBy(itemDetails.ItemNo4Header, true);
		utilityfunctions.isDisplayedBy(itemDetails.ItemNo5Header, true);
		utilityfunctions.isDisplayedBy(itemDetails.DeleteItemBtn1, true);
		utilityfunctions.isDisplayedBy(itemDetails.DeleteItemBtn2, true);
		utilityfunctions.isDisplayedBy(itemDetails.DeleteItemBtn3, true);
		utilityfunctions.isDisplayedBy(itemDetails.DeleteItemBtn4, true);
		utilityfunctions.isDisplayedBy(itemDetails.DeleteItemBtn5, true);
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='addItemBtn' and @style='display: none;']")).isDisplayed());
		System.out.println("Verified clicking on Add Item 5 times, Adds 5 Item and Delete button added to all the item section. Add button gets removed.");
	
		}	catch (Exception e) {
		System.out.println(e.getMessage());
		Assert.fail();
		ExceptionalHandlingFunctions.captureScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
		
	}
	@Test(priority=4)
	public void deleteItemFunctionality() throws Exception
	{
		try {
		Thread.sleep(3000);
		itemDetails=new ItemDetails(driver);
		
		
		// Filling up the details in Item no1 section.
		itemDetails.setQuantity(propertyValue.getValue("validQuantity1"));
		Thread.sleep(3000);
		String QuantityItem1= itemDetails.getQuantity();
		String PackagingItem1=itemDetails.setPackagingTypeBasket();
		String ClassItem1=itemDetails.setClass85();
		String StackableItem1=itemDetails.setStackableYes();
		itemDetails.setLength(propertyValue.getValue("validLength1"));
		String lengthItem1= itemDetails.getLength();
		itemDetails.setWidth(propertyValue.getValue("validWidth1"));
		String WidthItem1= itemDetails.getWidth();
		itemDetails.setHeight(propertyValue.getValue("validHeight1"));
		String heightItem1= itemDetails.getHeight();
		itemDetails.setWeight(propertyValue.getValue("validWeight1"));
		String weightItem1= itemDetails.getWeight();
		itemDetails.setCommodity(propertyValue.getValue("validCommodity4char"));
		String commodityItem1= itemDetails.getCommodity();
		
		//Adding 4 more Item section and keeping it blank
		itemDetails=new ItemDetails(driver);
		itemDetails.clickAdditemBtn();
		Thread.sleep(2000);
		itemDetails.clickAdditemBtn();
		Thread.sleep(2000);
		itemDetails.clickAdditemBtn();
		Thread.sleep(2000);
		itemDetails.clickAdditemBtn();
		Thread.sleep(2000);	
		
		//Verifying the details entered in the Item No1. section after adding 4 more item section.
		utilityfunctions.validationEquals(propertyValue.getValue("validQuantity1"), QuantityItem1);
		utilityfunctions.validationEquals(propertyValue.getValue("validLength1"), lengthItem1);
		utilityfunctions.validationEquals(propertyValue.getValue("validWidth1"), WidthItem1);
		utilityfunctions.validationEquals(propertyValue.getValue("validHeight1"), heightItem1);
		utilityfunctions.validationEquals(propertyValue.getValue("validWeight1"), weightItem1);
		utilityfunctions.validationEquals(propertyValue.getValue("validCommodity4char"), commodityItem1);
		utilityfunctions.validationEquals(PackagingItem1, "Basket");
		utilityfunctions.validationEquals(ClassItem1, "85");
		utilityfunctions.validationEquals(StackableItem1, "Yes");
		
		//Filling all details in Item no.5
		itemDetails.setQuantity5(propertyValue.getValue("quantity5"));
		Thread.sleep(3000);
		String QuantityItem5= itemDetails.getQuantity5();
		String PackagingItem5=itemDetails.setPackagingTypeBox();
		String ClassItem5=itemDetails.setClass92();
		String StackableItem5=itemDetails.setItem5StackableNo();
		itemDetails.setLength5(propertyValue.getValue("length5"));
		String lengthItem5= itemDetails.getLength5();
		itemDetails.setWidth5(propertyValue.getValue("width5"));
		String WidthItem5= itemDetails.getWidth5();
		itemDetails.setHeight5(propertyValue.getValue("height5"));
		String heightItem5= itemDetails.getHeight5();
		itemDetails.setWeight5(propertyValue.getValue("weight5"));
		String weightItem5= itemDetails.getWeight5();
		itemDetails.setCommodity5(propertyValue.getValue("CommodityDesc5"));
		String commodityItem5= itemDetails.getCommodity5();
		
		//Verifying Add item button has got removed.
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='addItemBtn' and @style='display: none;']")).isDisplayed());
		
		//Deleting Item No.4 
		itemDetails.clickDeleteItem4();
		
		//Verifying 4 items section header and 4 delete button.
		CommonFunctions utilityfunctions = new CommonFunctions(driver);
		utilityfunctions.isDisplayedBy(itemDetails.ItemNo1Header, true);
		utilityfunctions.isDisplayedBy(itemDetails.ItemNo2Header, true);
		utilityfunctions.isDisplayedBy(itemDetails.ItemNo3Header, true);
		utilityfunctions.isDisplayedBy(itemDetails.ItemNo4Header, true);
		utilityfunctions.isDisplayedBy(itemDetails.DeleteItemBtn1, true);
		utilityfunctions.isDisplayedBy(itemDetails.DeleteItemBtn2, true);
		utilityfunctions.isDisplayedBy(itemDetails.DeleteItemBtn3, true);
		utilityfunctions.isDisplayedBy(itemDetails.DeleteItemBtn5, true);
		
		//Verified Add Item Button has got added. 
		utilityfunctions.isElementDisplayed(driver.findElement(itemDetails.AddItemBtn));
		
		//Verifying that the Item no. 5 details are changed to Item no 4 after deleting Item no.4
		utilityfunctions.validationEquals(driver.findElement(itemDetails.Quantity4).getAttribute("value"), QuantityItem5 );
		utilityfunctions.validationEquals(itemDetails.getPackagingTypeBox(), PackagingItem5);
		utilityfunctions.validationEquals(itemDetails.getClass92(), ClassItem5);
		utilityfunctions.validationEquals(itemDetails.getItem4StackableNo(), StackableItem5);
		utilityfunctions.validationEquals(driver.findElement(itemDetails.Length4).getAttribute("value"), lengthItem5 );
		utilityfunctions.validationEquals(driver.findElement(itemDetails.Width4).getAttribute("value"), WidthItem5 );
		utilityfunctions.validationEquals(driver.findElement(itemDetails.Height4).getAttribute("value"), heightItem5 );
		utilityfunctions.validationEquals(driver.findElement(itemDetails.Weight4).getAttribute("value"), weightItem5 );
		utilityfunctions.validationEquals(driver.findElement(itemDetails.CommodityDesc4).getAttribute("value"), commodityItem5 );
		
		System.out.println("Validated: After deleting 4th item, 5th item details comes to 4th item.");
	
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
