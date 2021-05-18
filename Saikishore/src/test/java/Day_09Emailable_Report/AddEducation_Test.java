package Day_09Emailable_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddEducation_Test {
	
	
	
WebDriver driver;	

	@Test
	public void Addskills() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		Reporter.log("Pass-OpenOrangeHrm");
		
	
	
	   findElement(By.id("txtUsername")).sendKeys("Admin");
	   Reporter.log("Pass-Enter Username");
	   
       findElement(By.id("txtPassword")).sendKeys("admin123");
       Reporter.log("Pass-Enter Password");
       
       
       findElement(By.id("btnLogin")).click();
       Reporter.log("Pass-Click on Login");
       
		
      
       
      
      
       
       
       
       
       
       findElement(By.id("menu_admin_viewAdminModule")).click();
       Reporter.log("Pass-Click on Admin");
       
       findElement(By.id("menu_admin_Qualifications")).click();
       Reporter.log("Pass-Click on Qualifications");
       
       findElement(By.id("menu_admin_viewEducation")).click();
       Reporter.log("Pass-Click on Education");
       
       findElement(By.id("btnAdd")).click();
       Reporter.log("Pass-Click on Add");
       
       findElement(By.id("education_name")).sendKeys("BMW");
       Reporter.log("Pass-Enter EducationName");
       
       findElement(By.id("btnSave")).click();
       Reporter.log("Pass-Click on Save");
       
       
       
       driver.quit();
       
      
		
	}
	 public   WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}
}
