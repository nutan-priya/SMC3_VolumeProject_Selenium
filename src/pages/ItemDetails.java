package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ItemDetails {
	WebDriver driver;
	public By ItemNo1Header=By.xpath("//h2[contains(text(),'ITEM No. 1')]");
	public By ItemNo2Header=By.xpath("//h2[contains(text(),'ITEM No. 2')]");
	public By ItemNo3Header=By.xpath("//h2[contains(text(),'ITEM No. 3')]");
	public By ItemNo4Header=By.xpath("//h2[contains(text(),'ITEM No. 4')]");
	public By ItemNo5Header=By.xpath("//h2[contains(text(),'ITEM No. 5')]");
	By Quantity= By.name("vltl_itemqty_1");
	By PackagingType= By.name("vltl_itempackagingtype_1");
	By Class= By.name("vltl_itemclass_1");
	By Stackable= By.name("vltl_itemstackable_1");
	By Length= By.name("vltl_itemlength_1");
	By Width= By.name("vltl_itemwidth_1");
	By Height= By.name("vltl_itemheight_1");
	By Weight= By.name("vltl_itemweight_1");
	By CommodityDesc= By.name("vltl_itemdescription_1");
	By QuatityLengthErrorMessage= By.xpath("//span[contains(text(),'Please enter quantity between 1-999')]");
	By LengthfieldErrorMessage= By.xpath("//span[contains(text(),'Please enter length between 1-636 (inch)')]");
	By WidthfieldErrorMessage= By.xpath("//span[contains(text(),'Please enter width between 1-96 (inch)')]");
	By HeightfieldErrorMessage= By.xpath("//span[contains(text(),'Please enter height between 1-144 (inch)')]");
	By WeightfieldErrorMessage= By.xpath("//span[contains(text(),'Please enter weight between 1-45000 (lbs)')]");
	By CommodityfieldErrorMessage= By.xpath("//span[contains(text(),'Please enter commodity description between 4-255 (char)')]");
	public By AddItemBtn = By.id("addItemBtn");
	public By DeleteItemBtn1=By.xpath("(//input[@id='deleteItem'])[1]");
	public By DeleteItemBtn2=By.xpath("//input[@id='2']");
	public By DeleteItemBtn3=By.xpath("//input[@id='3']");
	public By DeleteItemBtn4=By.xpath("//input[@id='4']");
	public By DeleteItemBtn5=By.xpath("//input[@id='5']");
	public By Quantity1=By.name("vltl_itemqty_1");
	public By Quantity2=By.name("vltl_itemqty_2");
	public By Quantity3=By.name("vltl_itemqty_3");
	public By Quantity4=By.name("vltl_itemqty_4");
	public By Quantity5=By.name("vltl_itemqty_5");
	public By Weight1= By.name("vltl_itemweight_1");
	public By Weight2= By.name("vltl_itemweight_2");
	public By Weight3= By.name("vltl_itemweight_3");
	public By Weight4= By.name("vltl_itemweight_4");
	public By Weight5= By.name("vltl_itemweight_5");
	public By PackagingType4= By.name("vltl_itempackagingtype_4");
	public By PackagingType5= By.name("vltl_itempackagingtype_5");
	public By Class4= By.name("vltl_itemclass_4");
	public By Class5= By.name("vltl_itemclass_5");
	public By Stackable4= By.name("vltl_itemstackable_4");
	public By Stackable5= By.name("vltl_itemstackable_5");
	public By Length4= By.name("vltl_itemlength_4");
	public By Length5= By.name("vltl_itemlength_5");
	public By Width4= By.name("vltl_itemwidth_4");
	public By Width5= By.name("vltl_itemwidth_5");
	public By Height4= By.name("vltl_itemheight_4");
	public By Height5= By.name("vltl_itemheight_5");
	public By CommodityDesc4= By.name("vltl_itemdescription_4");
	public By CommodityDesc5= By.name("vltl_itemdescription_5");
	public By TotalpackagingUnit= By.id("totalPackingUnit");
	public By TotalShipmentWeight= By.id("totalDShipmentWeight");
	
	
	public ItemDetails(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setQuantity(String quantity) throws Exception
	{
		driver.findElement(Quantity).sendKeys(quantity);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getQuantity()
	{
		return driver.findElement(Quantity).getAttribute("value");
	}
	
	public WebElement getQuantityErrorMsg()
	{
		return driver.findElement(QuatityLengthErrorMessage);
	}
	
	public String setPackagingTypeBasket() throws Exception
	{
		Select packagingBasket = new Select(driver.findElement(PackagingType));
		packagingBasket.selectByVisibleText("Basket");
		Thread.sleep(2000);
		return packagingBasket.getFirstSelectedOption().getText(); 
	}
	
	public String setPackagingTypeContainer() throws Exception
	{
		Select packagingContainer = new Select(driver.findElement(PackagingType));
		packagingContainer.selectByVisibleText("Container");
		Thread.sleep(2000);
		return packagingContainer.getFirstSelectedOption().getText(); 
	}
	
	public String setClass85() throws Exception
	{
		Select Class85 = new Select(driver.findElement(Class));
		Class85.selectByVisibleText("85");
		Thread.sleep(2000);
		return Class85.getFirstSelectedOption().getText();
	}
	
	public String setClass400() throws Exception
	{
		Select Class400 = new Select(driver.findElement(Class));
		Class400.selectByVisibleText("400");
		Thread.sleep(2000);
		return Class400.getFirstSelectedOption().getText();
	}
	
	public String setStackableYes() throws Exception
	{
		Select stackableYes = new Select(driver.findElement(Stackable));
		stackableYes.selectByVisibleText("Yes");
		Thread.sleep(2000);
		return stackableYes.getFirstSelectedOption().getText();
	}
	
	public String setStackableNo() throws Exception
	{
		Select stackableNo = new Select(driver.findElement(Stackable));
		stackableNo.selectByVisibleText("No");
		Thread.sleep(2000);
		return stackableNo.getFirstSelectedOption().getText();
	}
	

	public void setLength(String length) throws Exception
	{
		driver.findElement(Length).sendKeys(length);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getLength()
	{
		return driver.findElement(Length).getAttribute("value");
	}
	
	public WebElement getLengthErrorMsg()
	{
		return driver.findElement(LengthfieldErrorMessage);
	}
	
	public void setWidth(String width) throws Exception
	{
		driver.findElement(Width).sendKeys(width);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getWidth()
	{
		return driver.findElement(Width).getAttribute("value");
	}
	
	public WebElement getWidthErrorMsg()
	{
		return driver.findElement(WidthfieldErrorMessage);
	}
	
	public void setHeight(String height) throws Exception
	{
		driver.findElement(Height).sendKeys(height);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getHeight()
	{
		return driver.findElement(Height).getAttribute("value");
	}
	
	public WebElement getHeightErrorMsg()
	{
		return driver.findElement(HeightfieldErrorMessage);
	}
	
	public void setWeight(String weight) throws Exception
	{
		driver.findElement(Weight).sendKeys(weight);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getWeight()
	{
		return driver.findElement(Weight).getAttribute("value");
	}
	
	public WebElement getWeightErrorMsg()
	{
		return driver.findElement(WeightfieldErrorMessage);
	}
	
	public void setCommodity(String commodity) throws Exception
	{
		driver.findElement(CommodityDesc).sendKeys(commodity);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getCommodity()
	{
		return driver.findElement(CommodityDesc).getAttribute("value");
	}
	
	public WebElement getCommodityErrorMsg()
	{
		return driver.findElement(CommodityfieldErrorMessage);
	}
	
	public void clickAdditemBtn() throws Exception
	{
		driver.findElement(AddItemBtn).click();
		Thread.sleep(2000);
	}
	
	public void clickDeleteItem4() throws Exception
	{
		driver.findElement(DeleteItemBtn4).click();
		Thread.sleep(3000);
	}
	
	public String getTotalPackagingUnit()
	{
		return driver.findElement(TotalpackagingUnit).getText();
	}
	
	public String getTotalShipmentWeight()
	{
		return driver.findElement(TotalShipmentWeight).getText();
	}
	
	public void setQuantity1(String quantity1) throws Exception
	{
		driver.findElement(Quantity1).sendKeys(quantity1);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public void setQuantity2(String quantity2) throws Exception
	{
		driver.findElement(Quantity2).sendKeys(quantity2);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public void setQuantity3(String quantity3) throws Exception
	{
		driver.findElement(Quantity3).sendKeys(quantity3);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public void setQuantity4(String quantity4) throws Exception
	{
		driver.findElement(Quantity4).sendKeys(quantity4);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public void setQuantity5(String quantity5) throws Exception
	{
		driver.findElement(Quantity5).sendKeys(quantity5);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getQuantity5()
	{
		return driver.findElement(Quantity5).getAttribute("value");
	}
	
	public String setPackagingTypeBox() throws Exception
	{
		Select packagingBasket = new Select(driver.findElement(PackagingType5));
		packagingBasket.selectByVisibleText("Box");
		Thread.sleep(2000);
		return packagingBasket.getFirstSelectedOption().getText(); 
	}
	
	public String getPackagingTypeBox() throws Exception
	{
		Select sel = new Select(driver.findElement(PackagingType4));
		return sel.getFirstSelectedOption().getText();
	}
	
	
	public String setClass92() throws Exception
	{
		Select Class85 = new Select(driver.findElement(Class5));
		Class85.selectByVisibleText("92.5");
		Thread.sleep(2000);
		return Class85.getFirstSelectedOption().getText();
	}
	
	public String getClass92() throws Exception
	{
		Select sel = new Select(driver.findElement(Class4));
		return sel.getFirstSelectedOption().getText();
	}
	
	public String setItem5StackableNo() throws Exception
	{
		Select stackableNo = new Select(driver.findElement(Stackable5));
		stackableNo.selectByVisibleText("No");
		Thread.sleep(2000);
		return stackableNo.getFirstSelectedOption().getText();
	}
	
	public String getItem4StackableNo() throws Exception
	{
		Select sel = new Select(driver.findElement(Stackable4));
		return sel.getFirstSelectedOption().getText();
	}
	
	public void setLength5(String length5) throws Exception
	{
		driver.findElement(Length5).sendKeys(length5);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getLength5()
	{
		return driver.findElement(Length5).getAttribute("value");
	}
	
	public void setWidth5(String width5) throws Exception
	{
		driver.findElement(Width5).sendKeys(width5);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getWidth5()
	{
		return driver.findElement(Width5).getAttribute("value");
	}
	
	public void setHeight5(String height5) throws Exception
	{
		driver.findElement(Height5).sendKeys(height5);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getHeight5()
	{
		return driver.findElement(Height5).getAttribute("value");
	}
		
	public void setWeight1(String weight1) throws Exception
	{
		driver.findElement(Weight1).sendKeys(weight1);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	public void setWeight2(String weight2) throws Exception
	{
		driver.findElement(Weight2).sendKeys(weight2);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public void setWeight3(String weight3) throws Exception
	{
		driver.findElement(Weight3).sendKeys(weight3);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public void setWeight4(String weight4) throws Exception
	{
		driver.findElement(Weight4).sendKeys(weight4);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public void setWeight5(String weight5) throws Exception
	{
		driver.findElement(Weight5).sendKeys(weight5);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getWeight5()
	{
		return driver.findElement(Weight5).getAttribute("value");
	}
	
	public void setCommodity5(String commodity5) throws Exception
	{
		driver.findElement(CommodityDesc5).sendKeys(commodity5);
		driver.findElement(ItemNo1Header).click();
		Thread.sleep(2000);
	}
	
	public String getCommodity5()
	{
		return driver.findElement(CommodityDesc5).getAttribute("value");
	}
	
	
	/**
	 * 
	 * @param Text accepts by element.
	 * @return WebElement
	 */
	public WebElement AssertionsText(By Text)
	{
		return driver.findElement(Text);
	}
	
	public void clearMethodByXpath(String elementId)
	{
		driver.findElement( By.xpath(elementId)).clear();
	}
	
	public void clearMethodByName(String elementId)
	{
		driver.findElement( By.name(elementId)).clear();
	}
	
	
}
