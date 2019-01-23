package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	
	WebDriver driver;	
	By UserName= By.name("username");	
	By Password= By.name("password");
	By LoginBtn=By.id("login-button");

	public Login(WebDriver driver)
	{
		this.driver=driver;
			}
	
	public void setUserName(String userName)
	{
		driver.findElement(UserName).sendKeys(userName);	
	
	}
	
	public void setPassword(String password)
	{
		driver.findElement(Password).sendKeys(password);
	}
	
	public void clkLogin()
	{
		driver.findElement(LoginBtn).click();
	}
	
	public void LoginToApplication(String userName,String password)
	{
		this.setUserName(userName);
		this.setPassword(password);
		this.clkLogin();
		
	}
}
