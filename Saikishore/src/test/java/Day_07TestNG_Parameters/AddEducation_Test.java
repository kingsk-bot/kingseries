package Day_07TestNG_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddEducation_Test {
	
	
	
WebDriver driver;

//the following input data is given in TestNG.xml in TestNG PARAMETERS 

/*String Browser;
String TestURL="https://opensource-demo.orangehrmlive.com/";
String Username="Admin",Password="admin123";
String education_name="BMW";*/

@Parameters({"Browser","TestURL","Username","Password","education_name"})
	@Test
	public void AddEducation(String Browser,String TestURL,String Username,String Password,String education_name) throws Exception
	{
	
		AddEducation_Test T1=new AddEducation_Test();
		
		            T1.OpenChromeBrowser(Browser);
		            T1.OpenOrangeHRM(TestURL);
		            T1.Login(Username,Password);
		            T1.AddEducation(education_name);
		            T1.CloseBrowser();
	
	}	
		
		
  public void OpenChromeBrowser(String Browser) throws Exception
  {
		driver=TestBrowser.OpenChromeBrowser();
		
  }
  
  
  public void OpenOrangeHRM(String TestURL) throws Exception
  {
	 // String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
  }
	
  
  
  public void Login(String Username,String Password ) throws Exception
  {
	   findElement(By.id("txtUsername")).sendKeys(Username);
       findElement(By.id("txtPassword")).sendKeys(Password);
       findElement(By.id("btnLogin")).click();	
  }	
      
       
    
  
  public void AddEducation(String education_name ) throws Exception
  {
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Qualifications")).click();
       findElement(By.id("menu_admin_viewEducation")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("education_name")).sendKeys(education_name);
       findElement(By.id("btnSave")).click();
       
  } 
  
  
  
  
  public void CloseBrowser() throws Exception
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
