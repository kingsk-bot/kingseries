package Day_13Priority;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import CommonUtil.TestBrowser;

public class Addjobtitles_Test {
	
	
	
 static WebDriver driver;	

 @Test(priority=1)
	public void Test1_OpenChromeBrowser() throws Exception
	{
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    
	}

	@Test(priority=2)
	public void Test2_OpenOrangeHRM() throws Exception
	{
	driver.get("https://opensource-demo.orangehrmlive.com/");	
	}
	
	@Test(priority=3)
	public void Test3_Login() throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys("Admin");
       findElement(By.id("txtPassword")).sendKeys("admin123");
       findElement(By.id("btnLogin")).click();	
	}	
     
	@Test(priority=4)
   public void Test4_Addjobs() throws Exception
   {
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Job")).click();
       findElement(By.id("menu_admin_viewJobTitleList")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("jobTitle_jobTitle")).sendKeys("st");
       findElement(By.id("jobTitle_jobDescription")).sendKeys("Iit");
       findElement(By.id("jobTitle_note")).sendKeys("ktm");
       findElement(By.id("btnSave")).click();
   }   
    
	@Test(priority=5)
   public void Test5_CloseBrowser() throws Exception
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
