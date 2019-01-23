package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accessorials {
	
	WebDriver driver;	
	public By NotifyDelivery = By.xpath("//label[contains(text(),'Notify Before Delivery')]");
	public By ConstructionPickUp= By.xpath("//label[contains(text(),'Construction Site Pickup')]");
	public By ConstructionDelivery= By.xpath("//label[contains(text(),'Construction Site Delivery')]");
	public By LiftGatePickup = By.xpath("//label[contains(text(),'Lift Gate Service Pickup')]");
	public By LiftGateDelivery= By.xpath("//label[contains(text(),'Lift Gate Service Delivery')]");
	public By LimtitedAccessPickUp= By.xpath("//label[contains(text(),'Limited Access Pickup')]");
	public By LimtitedAccessDelivery= By.xpath("//label[contains(text(),'Limited Access Delivery')]");
	public By ResidentialPickup= By.xpath("//label[contains(text(),'Residential Pickup')]");
	public By ResidentialDelivery= By.xpath("//label[contains(text(),'Residential Delivery')]");
	public By HazardousMaterial= By.xpath("//label[contains(text(),'Hazardous Material')]");
	public By Insurance = By.xpath("//label[contains(text(),'Insurance')]");
	public By EmrgncyContact=By.xpath("//input[@placeholder='Emergency Contact Name']");
	public By PhoneNumber=By.xpath("//input[@placeholder='Emergency Contact Number']");
	

	
	public Accessorials(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setNotifyDelivery() throws Exception
	{
		driver.findElement(NotifyDelivery).click();
		Thread.sleep(1000);
	}
	
	public void setConstructionPickUp() throws Exception
	{
		driver.findElement(ConstructionPickUp).click();
		Thread.sleep(1000);
	}
	
	public String setConstructionDelivery() throws Exception
	{
		driver.findElement(ConstructionDelivery).click();
		Thread.sleep(1000);
		return driver.findElement(ConstructionDelivery).getText();
	}
	
	public void setLiftGatePickup() throws Exception
	{
		driver.findElement(LiftGatePickup).click();
		Thread.sleep(1000);
	}
	
	public void setLiftGateDelivery() throws Exception
	{
		driver.findElement(LiftGateDelivery).click();
		Thread.sleep(1000);
	}
	
	public void setLimtitedAccessPickUp() throws Exception
	{
		driver.findElement(LimtitedAccessPickUp).click();
		Thread.sleep(1000);
	}
	
	public void setLimtitedAccessDelivery() throws Exception
	{
		driver.findElement(LimtitedAccessDelivery).click();
		Thread.sleep(1000);
	}
	
	public void setResidentialPickup() throws Exception
	{
		driver.findElement(ResidentialPickup).click();
		Thread.sleep(1000);
	}
	
	public void setResidentialDelivery() throws Exception
	{
		driver.findElement(ResidentialDelivery).click();
		Thread.sleep(1000);
	}
	
	public void setHazardousMaterial() throws Exception
	{
		driver.findElement(HazardousMaterial).click();
		Thread.sleep(1000);
	}
	
	public void setInsurance() throws Exception
	{
		driver.findElement(Insurance).click();
		Thread.sleep(1000);
	}
	
	
	public void setEmrgncyContact(String contactName)
	{
		driver.findElement(EmrgncyContact).sendKeys(contactName);
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		driver.findElement(PhoneNumber).sendKeys(phoneNumber);
	}
	

	public void setAccessorials() throws Exception
	{
		this.setNotifyDelivery();
		this.setConstructionPickUp();
		this.setConstructionDelivery();
		this.setLiftGatePickup();
		this.setLiftGateDelivery();
		this.setLimtitedAccessPickUp();
		this.setLimtitedAccessDelivery();
		this.setResidentialPickup();
		this.setResidentialDelivery();
		this.setHazardousMaterial();
		//this.setInsurance();
	}
	
}
