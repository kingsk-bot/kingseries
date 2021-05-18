package Day_06Dataprovider_excel_mutltibrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddEducation_Test2 {
	
	
	
WebDriver driver;	


String Browser;
String TestURL="https://opensource-demo.orangehrmlive.com/";
String Username="Admin",Password="admin123";
String education_name="BMW";

@DataProvider(name="AddEducation")

public Object[][]DpTest()throws Exception
{
	Object[][] data=new Object[2][5];
	data[0][0]="Chrome";
	data[0][1]="https://opensource-demo.orangehrmlive.com/";
	data[0][2]="Admin";
	data[0][3]="admin123";
	data[0][4]="BMW";
	
	
	data[1][0]="Firefox";	
	data[1][1]="https://opensource-demo.orangehrmlive.com/";
	data[1][2]="Admin";
	data[1][3]="admin123";
	data[1][4]="BMW";
	
	return data;
	
}



	@Test(dataProvider="AddEducation")
	public void Addskills(String Browser,String TestURL,String Username,String Password,String education_name) throws Exception
	{
		AddEducation_Test2 T1=new AddEducation_Test2();
		
		               T1.OpenChromeBrowser(Browser);
		               T1.OpenOrangeHRM(TestURL);
		               T1.Login(Username,Password);
		               T1.AddEducation( education_name);
		               T1.CloseBrowser();
		
	}
		
		
		
		
		
public void OpenChromeBrowser(String Browser)throws Exception
{
	
	if(Browser.equalsIgnoreCase("Chrome"))
	{
		driver=TestBrowser.OpenChromeBrowser();
		//String TestURL="https://opensource-demo.orangehrmlive.com/";
	}
	
	if(Browser.equalsIgnoreCase("Firefox"))
		{
		driver=TestBrowser.OpenFirefoxBrowser();
		}
	
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


