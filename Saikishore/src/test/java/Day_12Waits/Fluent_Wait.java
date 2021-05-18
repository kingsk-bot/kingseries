package Day_12Waits;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Fluent_Wait {
	
	WebDriver driver;
	
	@Test
	
	public void ImplicityWait_Test() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		
		
		
	//Fluent Wait... it is global rule applicable for specific webelements.
		
		

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		
		driver.findElement(By.id("welcome")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(120, TimeUnit.SECONDS)
			       .pollingEvery(30, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
			   
			   WebElement Logout1 = wait.until(new Function<WebDriver,WebElement>() 
			   {
				     public WebElement apply(WebDriver driver) 
				     {
				       return driver.findElement(By.xpath("//*[@id=\'welcome-menu\']/ul/li[2]/a"));
				     }
				   }
			   );
			
			driver.findElement(By.xpath("//*[@id=\'welcome-menu\']/ul/li[2]/a"));
			
			Logout1.click();
			
		
		
		
		driver.findElement(By.xpath("//*[@id=\'welcome-menu\']/ul/li[2]/a")).click();
		
		
	}

}
