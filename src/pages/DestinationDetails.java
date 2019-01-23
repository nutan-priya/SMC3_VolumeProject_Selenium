package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DestinationDetails {
	WebDriver driver;
	By DeliveryDetailsHeader= By.xpath("//p[contains(text(),'Delivery Details')]");	
	By DestinationZip= By.id("destinationZip");
	By DestinationCity=By.id("destinationCity");
	By DestinationState=By.id("destinationState");
	By DestinationCountry=By.id("destinationCountry");
	By SelectCityMessage=By.xpath("//span[contains(text(),'Multiple cities found, please edit to one')]");
	
	
	public DestinationDetails(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setDeliveryDetails(String deliveryDetails)
	{
		driver.findElement(DeliveryDetailsHeader).sendKeys(deliveryDetails);
	}
	
	public void setDestinationZip(String DestinationZipCode) throws Exception
	{
		driver.findElement(DestinationZip).sendKeys(DestinationZipCode);
		driver.findElement(DeliveryDetailsHeader).click();
		Thread.sleep(3000);
	}
	
	public String getDestinationZip()
	{
		return driver.findElement(DestinationZip).getAttribute("value");
	}
	
	public void setDestinationCity(String DestinationCityName) throws Exception
	{
		driver.findElement(DestinationCity).clear();
		driver.findElement(DestinationCity).sendKeys(DestinationCityName);
		Thread.sleep(2000);
	}
	
	public String getDestinationCity()
	{
		return driver.findElement(DestinationCity).getAttribute("value");
	}
	
	public String selectOneCityMessage()
	{
		return driver.findElement(SelectCityMessage).getText();
	}
	
	public void setDestinationState() throws Exception
	{
		Select stateDropdown = new Select(driver.findElement(DestinationState));
		stateDropdown.selectByIndex(1);
		Thread.sleep(2000);
	}
	
	public String getDestinationState()
	{
		Select sel = new Select(driver.findElement(DestinationState));
		return sel.getFirstSelectedOption().getText();
	}
	
	public void setDestinationCountry() throws Exception
	{
		Select CountryDropdown = new Select(driver.findElement(DestinationCountry));
		CountryDropdown.selectByVisibleText("Canada");
		Thread.sleep(2000);
	}
	
	public String getDestinationCountry()
	{
		Select sel = new Select(driver.findElement(DestinationCountry));
		return sel.getFirstSelectedOption().getText();		
	}

	public void clearMethodById(String elementId)
	{
		driver.findElement( By.id(elementId)).clear();
	}
}
