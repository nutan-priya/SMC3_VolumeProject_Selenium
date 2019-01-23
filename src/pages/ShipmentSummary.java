package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShipmentSummary {

	WebDriver driver;	
	public By ShipmentSummaryHeader= By.xpath("//p[contains(text(),'Shipment Summary')]");
	public By OriginHeader= By.xpath("//label[contains(text(),'Origin')]");
	public By DestinationHeader= By.xpath("//label[contains(text(),'Destination')]");
	public By PicUpDateHeader= By.xpath("//label[contains(text(),'Pickup Date')]");
	public By PayerHeader= By.xpath("//label[contains(text(),'Payer')]");
	public By PaymentTermsHeader= By.xpath("//label[contains(text(),'Payment Terms')]");
	public By TotalLinearFTHeader= By.xpath("//label[contains(text(),'Total Linear Feet')]");
	public By TotalPackagingUnitsHeader= By.xpath("//label[contains(text(),'Total Packaging Units')]");
	public By TotalShipmentWeightHeader= By.xpath("//div[@class='vltl_form-33 vltl_form-dark']//div[3]//div[2]//div[1]//label[1]");
	public By AccessorialsHeader= By.xpath("//label[contains(text(),'Accessorials')]");
	public By carrierWithOutExceptionHeader =By.xpath("//p[contains(text(),'Carrier Quotes Without Exceptions')]");
	public By carrierWithExceptionHeader =By.xpath("//p[contains(text(),'Carriers With Exceptions')]");
	public By carrierNameUPSGroundFrght= By.xpath("//td[contains(text(),'UPS Ground Freight')]");
	
	
	
	
	By GetQuoteBtn= By.xpath("//input[@value='Get Quote']");
		
	public ShipmentSummary(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void GetQuote() throws Exception
	{
		driver.findElement(GetQuoteBtn).click();
		Thread.sleep(10000);
		
	}

}

