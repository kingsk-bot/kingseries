package Day_10JavaScriptExecutor;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class MultipleWindows_1 {
	
	WebDriver driver;
	@Test
	public void windows_Test() throws Exception
	{
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		
		((JavascriptExecutor)driver).executeScript("window.open()");
		
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		
		
		driver.switchTo().window(tabs.get(1));
		driver.get("http://google.com");
		
		
		driver.switchTo().window(tabs.get(0));
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		
	}

}
