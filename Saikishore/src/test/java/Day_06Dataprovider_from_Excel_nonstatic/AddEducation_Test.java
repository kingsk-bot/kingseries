package Day_06Dataprovider_from_Excel_nonstatic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class AddEducation_Test {
	
	
	
WebDriver driver;	



//String TestURL="https://opensource-demo.orangehrmlive.com/";.......this data is getting from excel
//String Username="Admin",Password="admin123";
//String education_name="BMW";



@DataProvider(name="AddEducation")

public Object[][] Authentication1()throws Exception
{
	ExcelApiTest4 eat=new ExcelApiTest4();
	Object[][] testObjarray=eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx", "Sheet2");
	System.out.println(testObjarray.length)	;
	return testObjarray;
	
}







	@Test(dataProvider="AddEducation")
	public void Addskills(String TestURL,String Username,String Password,String education_name ) throws Exception
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


