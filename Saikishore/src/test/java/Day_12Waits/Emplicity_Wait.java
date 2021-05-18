package Day_12Waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Emplicity_Wait {
	
	WebDriver driver;
	
	@Test
	
	public void ExplicityWait_Test() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		
		
		
	//Emplicity Wait... it is global rule applicable for specific webelements.
		
		

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		
		driver.findElement(By.id("welcome")).click();
		
		WebDriverWait Wait= new WebDriverWait(driver,60);
		
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		
		
		
		driver.findElement(By.linkText("Logout")).click();
		
		
	}

}
