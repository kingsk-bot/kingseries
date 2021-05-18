package Day_09Emailable_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddSkills_Test {
	
	
	
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
       Reporter.log("Click on Login");
      
       findElement(By.id("menu_admin_viewAdminModule")).click();
       Reporter.log("Pass-Click on Admin");
       
       findElement(By.id("menu_admin_Qualifications")).click();
       Reporter.log("Pass-Click on Qualifications");
       
       findElement(By.id("menu_admin_viewSkills")).click();
       Reporter.log("Pass-Click on Skills");
       
       findElement(By.id("btnAdd")).click();
       Reporter.log("Pass-Click on Add");
       
       findElement(By.id("skill_name")).sendKeys("skillname");
       Reporter.log("Pass-Enter SkillName");
       
       findElement(By.id("skill_description")).sendKeys("skill desc");
       Reporter.log("Pass-Enter Skill Description");
       findElement(By.id("btnSave")).click();
       Reporter.log("Pass-Click on Save");
       
      driver.quit();
		
	}
	 public  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid black'", elem);
		 
			}
			
			return elem;
		}
}
