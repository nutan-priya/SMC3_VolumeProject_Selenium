package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OriginDetails {

	WebDriver driver;	
	public static By PickupDetailsHeader= By.xpath("//p[contains(text(),'Pickup Details')]");	
	By OriginZip= By.id("originZip");
	By OriginCity=By.id("originCity");
	By OriginState=By.id("originState");
	By OriginCountry=By.id("originCountry");
	public By PickUpDate=By.id("pickupDate");
	By SelectCityMessage=By.xpath("//span[contains(text(),'Multiple cities found, please edit to one')]");

	
	public OriginDetails(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setPickUpDetails(String pickupDetails)
	{
		driver.findElement(PickupDetailsHeader).sendKeys(pickupDetails);
	}
	
	public void setOriginZip(String originZipCode) throws Exception
	{
		driver.findElement(OriginZip).sendKeys(originZipCode);
		driver.findElement(PickupDetailsHeader).click();
		Thread.sleep(3000);
	}
	
	public String getOriginZip()
	{
		return driver.findElement(OriginZip).getAttribute("value");
	}
	
	public void setOriginCity(String originCityName) throws Exception
	{
		driver.findElement(OriginCity).clear();
		driver.findElement(OriginCity).sendKeys(originCityName);
		Thread.sleep(2000);
	}
	
	public String getOriginCity()
	{
		return driver.findElement(OriginCity).getAttribute("value");
		
	}
	
	public String selectOneCityMessage()
	{
		return driver.findElement(SelectCityMessage).getText();
	}
	
	public void setOriginState() throws Exception
	{
		Select stateDropdown = new Select(driver.findElement(OriginState));
		stateDropdown.selectByIndex(1);
		Thread.sleep(2000);
	}
	
	public String getOriginState()
	{
		Select sel = new Select(driver.findElement(OriginState));
		return sel.getFirstSelectedOption().getText();
	}
	
	public void setOriginCountry() throws Exception
	{
		Select CountryDropdown = new Select(driver.findElement(OriginCountry));
		CountryDropdown.selectByVisibleText("Canada");
		Thread.sleep(2000);
	}
	
	public String getOriginCountry()
	{
		Select sel = new Select(driver.findElement(OriginCountry));
		return sel.getFirstSelectedOption().getText();		
	}
	
	public void clickPickUpDate()
	{
		driver.findElement(PickUpDate).click();
	}
	
	public String getPickUpDate()
	{
		return driver.findElement(PickUpDate).getAttribute("value");
	}
	
	public void setOriginDetails(String originZip,String originCity,String originState,String country,String date) throws Exception 
	{
		//this.SetPickUpDetails(pickupDetailsHeader);
		this.setOriginZip(originZip);
		this.setOriginCity(originCity);
		this.setOriginState();
		this.setOriginCountry();
		this.clickPickUpDate();
	}
	
	/**
	 * 
	 * @param elementId
	 */
	public void clearMethodById(String elementId)
	{
		driver.findElement( By.id(elementId)).clear();
	}
	
}
