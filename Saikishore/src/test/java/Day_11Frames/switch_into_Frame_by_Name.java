package Day_11Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class switch_into_Frame_by_Name {
	
	WebDriver driver;
	@Test
	public void Frame_Test() throws Exception
	{
		
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="http://www.bhavasri.com/Frames/AllContacts.html";
		driver.get(TestURL);
		
		
		driver.switchTo().frame("GoogleContactForm");
		driver.findElement(By.name("firstname")).sendKeys("thalluri");
		driver.findElement(By.name("lastname")).sendKeys("saikishore");
		driver.findElement(By.name("subject1")).sendKeys("softwaretest");
		
		driver.switchTo().defaultContent();
		
		
		
		driver.switchTo().frame("AmazonContactForm");
		driver.findElement(By.id("fname")).sendKeys("thalluri");
		driver.findElement(By.id("lname")).sendKeys("saikishore");
		driver.findElement(By.id("subject")).sendKeys("softwaretester");
		
		driver.switchTo().defaultContent();
		
		
		
		driver.quit();
		
		
		
		
		
		
	}

}
