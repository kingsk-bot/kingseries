package Day_09Custmized_EmailableReport;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Addjobtitles_Test {
	
	
	
WebDriver driver;	
Reporter1 R1;

	@Test
	public void Addskills() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		String str="Addskills";
		R1=new Reporter1(driver,str);
		
		
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		R1.TakeScreenShotAuto(driver,"openedOrangeHRM","Pass");
	
	
	   findElement(By.id("txtUsername")).sendKeys("Admin");
	   R1.TakeScreenShotAuto(driver,"Entered Username","Pass");
	   
       findElement(By.id("txtPassword")).sendKeys("admin123");
       R1.TakeScreenShotAuto(driver,"Entered Password","Pass");
       
       findElement(By.id("btnLogin")).click();
       R1.TakeScreenShotAuto(driver,"Clicked on Login","Pass");
       
		
      
       
       findElement(By.id("menu_admin_viewAdminModule")).click();
       R1.TakeScreenShotAuto(driver,"Clicked on Admin","Pass");
       
       findElement(By.id("menu_admin_Job")).click();
       R1.TakeScreenShotAuto(driver,"Clicked on Job","Pass");
       
       findElement(By.id("menu_admin_viewJobTitleList")).click();
       R1.TakeScreenShotAuto(driver,"Clicked on Jobtitles","Pass");
       
       findElement(By.id("btnAdd")).click();
       R1.TakeScreenShotAuto(driver,"Clicked on Add","Pass");
       
       findElement(By.id("jobTitle_jobTitle")).sendKeys("software");
       R1.TakeScreenShotAuto(driver,"Entered Jobtitle","Pass");
       
       findElement(By.id("jobTitle_jobDescription")).sendKeys("ITfield");
       R1.TakeScreenShotAuto(driver,"Entered JobDescrption","Pass");
       
       findElement(By.id("jobTitle_note")).sendKeys("ITfield note");
       R1.TakeScreenShotAuto(driver,"Entered Jobtitle Note","Pass");
       findElement(By.id("btnSave")).click();
       R1.TakeScreenShotAuto(driver,"Clicked on Save","Pass");
       
       
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
