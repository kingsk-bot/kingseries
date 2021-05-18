package Day_03StaticparameterMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Addjobtitles_Test {
	
	
	
static WebDriver driver;

static String TestURL="https://opensource-demo.orangehrmlive.com/";
static String Username="Admin",Password="admin123";
static String jobTitle="software",jobDescription="IT field",jobnote="Tester";

	@Test
	public void Addskills() throws Exception
	{
		
		Addjobtitles_Test.OpenChromeBrowser();
		Addjobtitles_Test.OpenOrangeHRM(TestURL);
		Addjobtitles_Test.Login(Username,Password);
		Addjobtitles_Test.Addjobtitle(jobTitle,jobDescription,jobnote);
		Addjobtitles_Test.CloseBrowser();
	}
		
public static void OpenChromeBrowser()throws Exception
		{
	
		driver=TestBrowser.OpenChromeBrowser();
		//String TestURL="https://opensource-demo.orangehrmlive.com/";
		}	
public static void OpenOrangeHRM(String TestURL)throws Exception
{
		driver.get(TestURL);
		}
	
	public static  void Login(String Username,String Password)throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys(Username);
       findElement(By.id("txtPassword")).sendKeys(Password);
       findElement(By.id("btnLogin")).click();	
	}	
      
     public static void Addjobtitle(String jobTitle,String jobDescription,String jobnote)throws Exception
     {
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Job")).click();
       findElement(By.id("menu_admin_viewJobTitleList")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle);
       findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDescription);
       findElement(By.id("jobTitle_note")).sendKeys(jobnote);
       findElement(By.id("btnSave")).click();
     }
       
     public static void CloseBrowser()throws Exception
     {
    	 driver.quit(); 
     }
      
      
     public static  WebElement findElement(By by) throws Exception 
 	{
 				
 		 WebElement elem = driver.findElement(by);    	    
 		
 		 
 		if (driver instanceof JavascriptExecutor) 
 		{
 		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid rose'", elem);
 	 
 		}
 		
 		return elem;
 	}	
	

}
