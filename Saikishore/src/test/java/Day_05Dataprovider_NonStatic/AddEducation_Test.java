package Day_05Dataprovider_NonStatic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddEducation_Test {
	
	
	
WebDriver driver;	



String TestURL="https://opensource-demo.orangehrmlive.com/";
String Username="Admin",Password="admin123";
String education_name="BMW";

@DataProvider(name="AddEducation")

public Object[][]DpTest()throws Exception
{
	return new Object[][] {
		{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","BBM"},
		
		{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","BBM1"},
		{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","BBM2"},
		
		
	};
}



	@Test(dataProvider="AddEducation")
	public void Addskills(String TestURL,String Username,String Password,String education_name) throws Exception
	{
		AddEducation_Test T1=new AddEducation_Test();
		
		               T1.OpenChromeBrowser();
		               T1.OpenOrangeHRM(TestURL);
		               T1.Login(Username,Password);
		               T1.AddEducation( education_name);
		               T1.CloseBrowser();
		
	}
		
		
		
		
		
public void OpenChromeBrowser()throws Exception
{
	
		driver=TestBrowser.OpenChromeBrowser();
		//String TestURL="https://opensource-demo.orangehrmlive.com/";
}	
		
		public void OpenOrangeHRM(String TestURL)throws Exception
		{
		driver.get(TestURL);
}

	
	public void Login(String Username ,String Password) throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys(Username);
       findElement(By.id("txtPassword")).sendKeys(Password);
       findElement(By.id("btnLogin")).click();	
		
	}  
       
      
      
       
       
       
    public void AddEducation(String education_name)throws Exception
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


