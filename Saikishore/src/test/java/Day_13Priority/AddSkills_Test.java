package Day_13Priority;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddSkills_Test {
	
	
	
WebDriver driver;	

	@Test(priority=1)
	public void Test1_OpenChromeBrowser() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
		
	@Test(priority=2)
	public void Test2_Login()  throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys("Admin");
       findElement(By.id("txtPassword")).sendKeys("admin123");
       findElement(By.id("btnLogin")).click();	
	}	
	
	@Test(priority=3)
	public void Test3_AddSkills() throws Exception
	{
      
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Qualifications")).click();
       findElement(By.id("menu_admin_viewSkills")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("skill_name")).sendKeys("skill");
       findElement(By.id("skill_description")).sendKeys("skill12456");
       findElement(By.id("btnSave")).click();
	}
	
	@Test(priority=4)
	public void Test4_Logout() throws Exception
	{
		findElement(By.id("welcome")).click();
		Thread.sleep(250);
		findElement(By.linkText("Logout")).click();
	}
	
	
	
	
	
	@Test(priority=5)
	public void Test5_CloseBrowser() throws Exception
	{
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
