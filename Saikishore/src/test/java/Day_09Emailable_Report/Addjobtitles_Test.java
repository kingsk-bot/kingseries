package Day_09Emailable_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Addjobtitles_Test {
	
	
	
WebDriver driver;	

	@Test
	public void Addskills() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		Reporter.log("Pass-OpenOrangeHRM");
	
	
	   findElement(By.id("txtUsername")).sendKeys("Admin");
	   Reporter.log("Pass-Enter Username");
       findElement(By.id("txtPassword")).sendKeys("admin123");
       Reporter.log("Pass-Enter Password");
       findElement(By.id("btnLogin")).click();	
       Reporter.log("Pass-Click on Login");
      
       
       findElement(By.id("menu_admin_viewAdminModule")).click();
       Reporter.log("Pass-Click on Admin");
       findElement(By.id("menu_admin_Job")).click();
       Reporter.log("Pass-Click on Job");
       findElement(By.id("menu_admin_viewJobTitleList")).click();
       Reporter.log("Pass-Click on Jobtitle");
       findElement(By.id("btnAdd")).click();
       Reporter.log("Pass-Click on Add");
       findElement(By.id("jobTitle_jobTitle")).sendKeys("software");
       Reporter.log("Pass-Enter Jobtitle");
       findElement(By.id("jobTitle_jobDescription")).sendKeys("ITfield");
       Reporter.log("Pass-Enter JobDescription");
       findElement(By.id("jobTitle_note")).sendKeys("ITfield note");
       Reporter.log("Pass-Enter Jobnote");
       
       findElement(By.id("btnSave")).click();
       Reporter.log("Pass-Click on Save");
       
       driver.quit();
      
		
	}
	 public   WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
		 
			}
			
			return elem;
		}
}
