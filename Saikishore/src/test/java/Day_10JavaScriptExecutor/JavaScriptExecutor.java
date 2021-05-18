package Day_10JavaScriptExecutor;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class JavaScriptExecutor {
	
	WebDriver driver;
	
	@Test
	public void JSE_Test() throws Exception
	{
	driver=TestBrowser.OpenChromeBrowser();
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	driver.get(TestURL);
	
	
	
		
		((JavascriptExecutor)driver).executeScript("window.open()");
		((JavascriptExecutor)driver).executeScript("window.open()");
		
		ArrayList<String> tabs =new ArrayList<String>(driver.getWindowHandles());
		
		
		
		
		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.google.com/?gws_rd=ssl");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement Element=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
		js.executeScript("arguments[0].click()",Element);
		js.executeScript("arguments[0].style.border='3px solid red'",Element);
		
		
		
		
		driver.switchTo().window(tabs.get(2));
		driver.get("https://www.facebook.com/");
		
		
		
		
		
		
		
		
		driver.switchTo().window(tabs.get(0));
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		
		
	}

}
