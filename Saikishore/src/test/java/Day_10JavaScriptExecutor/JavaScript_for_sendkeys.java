package Day_10JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScript_for_sendkeys {
	
	WebDriver driver;
	
	@Test
	public void SendKeys_Test() throws Exception
	{
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	
	//JavaScriptExecutor concept is using to execute the javascript of the particular weblement
	
	
	WebElement Username= driver.findElement(By.id("txtUsername"));
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('value','Admin')",Username);	
	
	
	WebElement Password=driver.findElement(By.id("txtPassword"));
	//JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('value','admin123')",Password);
	
	WebElement Login= driver.findElement(By.id("btnLogin"));
	js.executeScript("arguments[0].click()",Login);
		
		
		driver.quit();
	
	}

}
