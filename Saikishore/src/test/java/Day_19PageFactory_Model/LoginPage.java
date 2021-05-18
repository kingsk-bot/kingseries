package Day_19PageFactory_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
	
	
	WebDriver driver;
	
	public void LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="txtUsername")
	WebElement Username1;
	
	@FindBy(id="txtPassword")
	WebElement Password1;
	
	@FindBy(id="btnLogin")
	WebElement Login1;
	
	@Test
	public void Login() throws Exception
	{
		Username1.sendKeys("Admin");
		Password1.sendKeys("admin123");
		Login1.click();
		
	}
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", elem);
	 
		}
		return elem;
	}
}
