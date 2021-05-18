package Day_07TestNG_Parameters_nonstatic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Addjobtitles_Test {
	
	
	
WebDriver driver;
//String Browser;..............this data is taken from testng.xml
//String TestURL="https://opensource-demo.orangehrmlive.com/";
//String Username="Admin",Password="admin123";
//String jobTitle="software",jobDescription="IT field",jobnote="Tester";



@Parameters({"Browser","TestURL","Username","Password","jobTitle","jobDescription","jobnote"})
	@Test
	public void Addskills(String Browser,String TestURL,String Username,String Password,String jobTitle,String jobDescription,String jobnote ) throws Exception
	{
		Addjobtitles_Test T2=new Addjobtitles_Test();
		T2.OpenChromeBrowser(Browser);
		T2.OpenOrangeHRM(TestURL);
		T2.Login(Username,Password);
		T2.Addjobtitle(jobTitle,jobDescription,jobnote);
		T2.CloseBrowser();
	}
		
public void OpenChromeBrowser(String Browser)throws Exception
		{
	
		driver=TestBrowser.OpenChromeBrowser();
		//String TestURL="https://opensource-demo.orangehrmlive.com/";
		}	
public void OpenOrangeHRM(String TestURL)throws Exception
{
		driver.get(TestURL);
		}
	
	public void Login(String Username,String Password)throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys(Username);
       findElement(By.id("txtPassword")).sendKeys(Password);
       findElement(By.id("btnLogin")).click();	
	}	
      
     public void Addjobtitle(String jobTitle,String jobDescription,String jobnote)throws Exception
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
       
     public void CloseBrowser()throws Exception
     {
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
