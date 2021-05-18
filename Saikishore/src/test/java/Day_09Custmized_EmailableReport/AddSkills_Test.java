package Day_09Custmized_EmailableReport;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddSkills_Test {
	
	
	
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
		R1.TakeScreenShotAuto(driver,"Opened OrangeHRM","Pass");
		
	
	
	   findElement(By.id("txtUsername")).sendKeys("Admin");
	   R1.TakeScreenShotAuto(driver,"Entered Username","Pass");
	   
       findElement(By.id("txtPassword")).sendKeys("admin123");
       R1.TakeScreenShotAuto(driver,"Entered Password","Pass");
       
       findElement(By.id("btnLogin")).click();	
       R1.TakeScreenShotAuto(driver,"Clicked on Login","Pass");
       
       
      
       findElement(By.id("menu_admin_viewAdminModule")).click();
       R1.TakeScreenShotAuto(driver,"clicked on Admin","Pass");
       
       findElement(By.id("menu_admin_Qualifications")).click();
       R1.TakeScreenShotAuto(driver,"clicked on Qualifications","Pass");
       
       findElement(By.id("menu_admin_viewSkills")).click();
       R1.TakeScreenShotAuto(driver,"Clicked on Skills","Pass");
       
       findElement(By.id("btnAdd")).click();
       R1.TakeScreenShotAuto(driver,"Clicked on Save","Pass");
       
       findElement(By.id("skill_name")).sendKeys("skillname");
       R1.TakeScreenShotAuto(driver,"Entered Skill name","Pass");
       
       findElement(By.id("skill_description")).sendKeys("skill desc");
       R1.TakeScreenShotAuto(driver,"Entered Skill description","Pass");
       
       findElement(By.id("btnSave")).click();
       R1.TakeScreenShotAuto(driver,"clicked on Save","Pass");
       
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
