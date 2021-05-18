package Day_18PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPage {
	
	
	WebDriver driver;
	
	public void LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	@Test
	public void Login() throws Exception
	{
		findElement(By.id("txtUsername")).sendKeys("Admin");
		
		findElement(By.id("txtPassword")).sendKeys("admin123");
		
		findElement(By.id("btnLogin")).click();
		
	}
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
		
		
	}


