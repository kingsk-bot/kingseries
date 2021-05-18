package Day_13Priority;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddEducation_Test_withoutPriority {
	
	
	
 static WebDriver driver;	

	@Test
	public void Test1_OpenChromeBrowser() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
		
	@Test
	public void Test2_Login() throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys("Admin");
       findElement(By.id("txtPassword")).sendKeys("admin123");
       findElement(By.id("btnLogin")).click();	
	}	
      
       
      
      
       
       
     @Test  
     public void Test3_AddQualifications() throws Exception
     {
       
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Qualifications")).click();
       findElement(By.id("menu_admin_viewEducation")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("education_name")).sendKeys("BMW");
       findElement(By.id("btnSave")).click();
     } 
     
     @Test
     public void Test4_CloseBrowser() throws Exception
     {
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
