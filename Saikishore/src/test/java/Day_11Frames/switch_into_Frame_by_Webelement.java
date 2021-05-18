package Day_11Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class switch_into_Frame_by_Webelement {
	
	WebDriver driver;
	@Test
	public void Frame_By_Webelement()throws Exception
	{
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.bhavasri.com/Frames/AllContacts.html");
	
	
	driver.switchTo().frame(driver.findElement(By.id("AmazonContactForm")));
	
	driver.findElement(By.id("fname")).sendKeys("thalluri");
	driver.findElement(By.id("lname")).sendKeys("sai");
	driver.findElement(By.id("subject")).sendKeys("kishore");
	
	driver.switchTo().defaultContent();
	
	
		driver.switchTo().frame(driver.findElement(By.id("GoogleContactForm")));
		
		driver.findElement(By.id("fname")).sendKeys("thalluri");
		driver.findElement(By.id("lname")).sendKeys("sai");
		driver.findElement(By.id("subject1")).sendKeys("kishore");
		
		driver.switchTo().defaultContent();
		
		
		driver.quit();
		
	}

}
