package Day_10JavaScriptExecutor;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindows_2 {
	
	WebDriver driver;
	@Test
	public void Windows2_Test() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		
		((JavascriptExecutor)driver).executeScript("window.open()");
		((JavascriptExecutor)driver).executeScript("window.open()");
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		
		driver.switchTo().window(tabs.get(2));
		
		driver.get("http://google.com");
		
		
		
		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.facebook.com/");
		
		
		
		
		driver.findElement(By.id("email")).sendKeys("9676026690");
		driver.findElement(By.id("pass")).sendKeys("saikishore.32");
		//driver.findElement(By.xpath("//*[@id=\'u_0_d_WQ\']")).click();
		
		
		
		
		driver.switchTo().window(tabs.get(0));
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		
		driver.quit();
	}

}
