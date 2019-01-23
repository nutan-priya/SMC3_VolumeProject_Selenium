package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShipmentDetails {
	WebDriver driver;	
	By PickupDetailsHeader= By.xpath("//p[contains(text(),'Shipping Details')]");	
	By Payer= By.name("vltl_payer");
	By PaymentTerms=By.name("vltl_paymentterms");
	By TotalLinearFeet=By.name("vltl_totallinearfeet");
	By LinearFtLengthErMessage= By.xpath("//span[contains(text(),'Please enter linear feet between 1-53 (ft)')]");
	By LinearFtErrorField= By.xpath("//span[@id='vltl_totallinearfeet-error']");
	By LinearAlphabetErrorMessage= By.xpath("//span[contains(text(),'Please enter a valid number')]");
	
	
	
	public ShipmentDetails(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public String setPayerConsignee() throws Exception
	{
		Select payerConsignee= new Select(driver.findElement(Payer));
		payerConsignee.selectByVisibleText("Consignee");
		Thread.sleep(2000);
		Select sel = new Select(driver.findElement(Payer));
		return sel.getFirstSelectedOption().getText();
	}
	
	public String setPayerShipper()
	{
		Select payerShipper= new Select(driver.findElement(Payer));
		payerShipper.selectByVisibleText("Shipper");
		Select sel = new Select(driver.findElement(Payer));
		return sel.getFirstSelectedOption().getText();
	}
	
	public String setPayerThirdParty()
	{
		Select payerThirdParty= new Select(driver.findElement(Payer));
		payerThirdParty.selectByVisibleText("Third Party");
		Select sel = new Select(driver.findElement(Payer));
		return sel.getFirstSelectedOption().getText();
	}
	
	public String setPaymentTermsPrepaid()
	{
		Select paymentPrepaid= new Select(driver.findElement(PaymentTerms));
		paymentPrepaid.selectByVisibleText("Prepaid");
		Select sel = new Select(driver.findElement(PaymentTerms));
		return sel.getFirstSelectedOption().getText();
	}

	public String setPaymentTermsCollect()
	{
		Select paymentCollect= new Select(driver.findElement(PaymentTerms));
		paymentCollect.selectByVisibleText("Collect");
		Select sel = new Select(driver.findElement(PaymentTerms));
		return sel.getFirstSelectedOption().getText();
	}
	
	public String setPaymentTermsThirdParty()
	{
		Select paymentThirdParty= new Select(driver.findElement(PaymentTerms));
		paymentThirdParty.selectByVisibleText("Third Party");
		Select sel = new Select(driver.findElement(PaymentTerms));
		return sel.getFirstSelectedOption().getText();
	}
	
	public String setPaymentTermsOther()
	{
		Select paymentOther= new Select(driver.findElement(PaymentTerms));
		paymentOther.selectByVisibleText("Other");
		Select sel = new Select(driver.findElement(PaymentTerms));
		return sel.getFirstSelectedOption().getText();
	}

	public void setTotalLinearFeet(String linearFt) throws Exception
	{
		driver.findElement(TotalLinearFeet).sendKeys(linearFt);
		driver.findElement(PickupDetailsHeader).click();
		Thread.sleep(2000);
	}
	
	public String getTotalLinearFeet()
	{
		return driver.findElement(TotalLinearFeet).getText();
	}
	
	public WebElement getLengthLinearFtErrorMessage()
	{
		return driver.findElement(LinearFtLengthErMessage);
	}
	
	public WebElement getAlphabetLinearFtErrorMessage()
	{
		return driver.findElement(LinearAlphabetErrorMessage);
	}
	
	public String getNoMessageforValidInput()
	{
		return driver.findElement(LinearFtErrorField).getText();
	}
	
	public void clearMethodByName(String elementId)
	{
		driver.findElement( By.name(elementId)).clear();
	}
	
}
