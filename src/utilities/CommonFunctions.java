package utilities;

import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


/**
 * Stores all the commonly used functions to support TestCases. 
 * @author nutan.p
 *
 */
public class CommonFunctions {

	WebDriver driver;
	
	
	public CommonFunctions(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public String dateFunction()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public  String nextDay()
	{
		try{
		String curDate="",nextDate="";
		Calendar today = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("dd");
        Date date = new Date();
        today.setTime(date);
        today.add(Calendar.DAY_OF_YEAR, 1);
        return nextDate = format.format(today.getTime());
		}
		catch(Exception e)
		{
			return e.toString();
		}
		
	}
	
	public  String previousDay()
	{
		try{
		String curDate="",nextDate="";
		Calendar today = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("d");
        Date date = new Date();
        today.setTime(date);
        today.add(Calendar.DAY_OF_YEAR, -1);
        return nextDate = format.format(today.getTime());
		}
		catch(Exception e)
		{
			return e.toString();
		}
		
	}
	
	public int add(int value1, int value2)
	{
		return value1+value2;
	}
	
	public int multiply(int value1, int value2)
	{
		return value1*value2;
	}
	public String splitFunction(String cityList, int index)
	{
		String[] cityNamesList= cityList.split(", ");
		for(int i=0;i<cityNamesList.length;i++)
		{
			System.out.println(cityNamesList[i]);
		}
		
		if(index<cityNamesList.length)
		{
			return cityNamesList[index];
		}
		else {
			return cityNamesList[0];
		}
	}
	
	public void validationEquals(String expectedValue, String actualValue)
	{
		Assert.assertEquals(expectedValue, actualValue);
	}
	
	public void isElementDisplayed(WebElement Expected)
	{
		Assert.assertTrue(Expected.isDisplayed());
	}
	
	/**
	 * To check by Element is displayed or not.
	 * 
	 * @param Expected accepts by element.
	 * @param isTrue boolean value, True to check is Displayed. False if not.
	 */
	public void isDisplayedBy(By Expected, boolean isTrue)
	{
		if (isTrue==true)
		{
			Assert.assertTrue(driver.findElement(Expected).isDisplayed());
		}else {
			Assert.assertFalse(driver.findElement(Expected).isDisplayed());
		}
		
	}
		
	
	public void validationIsFalse(WebElement Expected)
	{
		Assert.assertFalse(Expected.isDisplayed());
	}
	
	public void validationIsEmpty(String Expected)
	{
		Assert.assertNull(Expected.isEmpty());  //---how to use this
	}
	
	/**
	 * 
	 * @param elementId
	 */
	public void clearMethodById(String elementId)
	{
		
		try {
		By test = By.id(elementId);
		
		WebElement t = driver.findElement(test);
		t.clear();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
