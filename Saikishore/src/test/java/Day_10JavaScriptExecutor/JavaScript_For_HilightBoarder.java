package Day_10JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class JavaScript_For_HilightBoarder {
	
	WebDriver driver;
	@Test
	public void boarder_Test() throws Exception
	{
		
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebElement Username=driver.findElement(By.cssSelector("input#txtUsername"));
		js.executeScript("arguments[0].setAttribute('value','Admin')",Username);
		js.executeScript("arguments[0].style.border='3px solid blue'",Username);
		
	    WebElement Password=driver.findElement(By.cssSelector("input#txtPassword"));
	   js.executeScript("arguments[0].setAttribute('value','admin123')",Password);
	 js.executeScript("arguments[0].style.border='3px solid green'",Password);
		
		
		WebElement Login=driver.findElement(By.cssSelector("input#btnLogin"));
		js.executeScript("arguments[0].click()",Login);
		js.executeScript("arguments[0].style.border='3px solid blue'",Login);
		
		
		
		
		
		
		/*WebElement Admin=driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
		js.executeScript("arguments[0].click()",Admin);
		js.executeScript("arguments[0].style.border='3px solid red'",Admin);*/
		
		driver.findElement(By.linkText("Admin")).click();
		
		driver.findElement(By.linkText("Job")).click();
		driver.findElement(By.linkText("JobTitle")).click();
		
		
			/*WebElement Job =driver.findElement(By.xpath("//*[@id=\'menu_admin_Job\']"));
			js.executeScript("arguments[0].click()",Job);
			js.executeScript("arguments[0].style.border='3px solid red'",Job);*/
			
		
		
		
		
		
		/*WebElement JobTitle=driver.findElement(By.xpath("//*[@id='menu_admin_viewJobTitleList']"));
		
		js.executeScript("arguments[0].click()",JobTitle);
		js.executeScript("arguments[0].style.border='3px solid red'",JobTitle);*/
		
		
		
		
		WebElement Element=driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[25]/td[2]/a"));
		js.executeScript("arguments[0].scrollIntoView()",Element);
		js.executeScript("arguments[0].style.border='3px solid red'",Element);
		
		
		
		
		
		driver.quit();
		
		
		
		
		
		
		
	}

}
