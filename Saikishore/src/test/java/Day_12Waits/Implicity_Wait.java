package Day_12Waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Implicity_Wait {
	
	WebDriver driver;
	
	@Test
	
	public void ImplicityWait_Test() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		
		
	//Implicity Wait... it is global rule applicable for all the webelements.display time for all webelements
		
		

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		
	}

}
