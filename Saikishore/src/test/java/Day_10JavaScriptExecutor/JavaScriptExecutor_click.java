package Day_10JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class JavaScriptExecutor_click {
	
	
	WebDriver driver;
	@Test
	public void  JSE_Test() throws Exception
	{
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
	 JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement Username=driver.findElement(By.xpath("//*[@id=\'txtUsername\']"));
		js.executeScript("arguments[0].setAttribute('value','Admin')",Username);
		
		
		
		
        WebElement Password=driver.findElement(By.xpath("//*[@id=\'txtPassword\']"));
        js.executeScript("arguments[0].setAttribute('value','admin123')",Password);
        
        
        
	    WebElement Login=driver.findElement(By.xpath("//*[@id=\'btnLogin\']"));
		js.executeScript("arguments[0].click()",Login);
		
		
		
		
	}

}
