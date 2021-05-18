package Day_10Actionsclass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Right_r_context_click {
	
	
	WebDriver driver;
	
	@Test
	
	public void right_click() throws Exception
	{
		
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://swisnl.github.io/jQuery-contextMenu/demo.html";
		driver.get(TestURL);
		
		
		
		
		
		WebElement right_click_me =driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions actions=new Actions(driver);
		
		actions.contextClick(right_click_me).perform();
		
		
		driver.findElement(By.xpath("//span[text()='Quit']")).click();
		
		Alert alert=driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		//alert.dismiss();
		
		
		
		
		
	// alert accept means .....click on Ok
// alert dismiss means........click on No
		
		
		
	}
	 public  WebElement findElement(By by) throws Exception 
		{
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}

}
