package Day_09Custmized_EmailableReport;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddEducation_Test {
	
	
	
WebDriver driver;
Reporter1  R1;

	@Test
	public void Addskills() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		
		String str="AddSkill";
		R1=new Reporter1(driver,str);
		
		
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		R1.TakeScreenShotAuto(driver,"OpenedOrangeHRM","Pass");
	
	
	   findElement(By.id("txtUsername")).sendKeys("Admin");
	   R1.TakeScreenShotAuto(driver,"Username Entered","Pass");
	   
	   
       findElement(By.id("txtPassword")).sendKeys("admin123");
       R1.TakeScreenShotAuto(driver,"Password Entered","Pass");
       
       findElement(By.id("btnLogin")).click();	
		R1.TakeScreenShotAuto(driver,"Login Clicked","Pass");      
       
      
      
       
       
       
       
       
       findElement(By.id("menu_admin_viewAdminModule")).click();
       R1.TakeScreenShotAuto(driver,"Click on Admin","Pass");
       
       findElement(By.id("menu_admin_Qualifications")).click();
       R1.TakeScreenShotAuto(driver,"Click on Qualifications","Pass");
       
       findElement(By.id("menu_admin_viewEducation")).click();
       R1.TakeScreenShotAuto(driver,"Click on Education","Pass");
       
       findElement(By.id("btnAdd")).click();
       R1.TakeScreenShotAuto(driver,"Click on Add","Pass");
       
       
       findElement(By.id("education_name")).sendKeys("BMW");
       R1.TakeScreenShotAuto(driver,"Education name Entered","Pass");
       
       findElement(By.id("btnSave")).click();
       R1.TakeScreenShotAuto(driver,"Click on Save","Pass");
       
       
       
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
