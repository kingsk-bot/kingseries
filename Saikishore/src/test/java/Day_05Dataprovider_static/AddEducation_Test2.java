package Day_05Dataprovider_static;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddEducation_Test2 {
	
	
	
static WebDriver driver;	



static String TestURL="https://opensource-demo.orangehrmlive.com/";
static String Username="Admin",Password="admin123";
static String education_name="BMW";

@DataProvider(name="AddEducation")


public Object[][]dptest()throws Exception
{
	Object[][] data=new Object[2][4];
	data[0][0]="https://opensource-demo.orangehrmlive.com/";
	data[0][1]="Admin";
	data[0][2]="admin123";
	data[0][3]="BMW";
	
	
	data[0][0]="https://opensource-demo.orangehrmlive.com/";
	data[0][1]="Admin";
	data[0][2]="admin123";
	data[0][3]="BMW";
	
	
	return data;
	
	
	
}
	@Test(dataProvider="AddEducation")
	public void Addskills(String TestURL,String Username,String Password,String education_name ) throws Exception
	{
		
		
		AddEducation_Test2.OpenChromeBrowser();
		AddEducation_Test2.OpenOrangeHRM(TestURL);
		AddEducation_Test2.Login(Username,Password);
		AddEducation_Test2.AddEducation(education_name);
		AddEducation_Test2.CloseBrowser();
		
	}
		
		
		
		
		
public static void OpenChromeBrowser()throws Exception
{
		driver=TestBrowser.OpenChromeBrowser();
		//String TestURL="https://opensource-demo.orangehrmlive.com/";
}	
		
		public static  void OpenOrangeHRM(String TestURL)throws Exception
		{
		driver.get(TestURL);
}

	
	public static void Login(String Username ,String Password) throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys(Username);
       findElement(By.id("txtPassword")).sendKeys(Password);
       findElement(By.id("btnLogin")).click();	
		
	}  
       
      
      
       
       
       
    public static void AddEducation(String education_name)throws Exception
    {
       
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Qualifications")).click();
       findElement(By.id("menu_admin_viewEducation")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("education_name")).sendKeys(education_name);
       findElement(By.id("btnSave")).click();
       
    }
    
    public static void CloseBrowser() throws Exception
    {
       
       driver.quit();
    }  
      
	
    public static  WebElement findElement(By by) throws Exception 
   	{
   				
   		 WebElement elem = driver.findElement(by);    	    
   		
   		 
   		if (driver instanceof JavascriptExecutor) 
   		{
   		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", elem);
   	 
   		}
   		
   		return elem;
   	}
    
    
	}


