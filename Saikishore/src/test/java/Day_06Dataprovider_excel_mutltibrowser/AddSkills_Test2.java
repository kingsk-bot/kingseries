package Day_06Dataprovider_excel_mutltibrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddSkills_Test2 {
	
	
	
WebDriver driver;
String Browser;
String TestURL="https://opensource-demo.orangehrmlive.com/";
String Username="Admin",Password="admin123";

String skillname="MECHANICAL",skilldescription="MECH DES";


@DataProvider(name="AddSkills")

public Object[][] Dptest()throws Exception
{
	Object[][]data=new Object[3][6];
	
	data[0][0]="Chrome";
	data[0][1]="https://opensource-demo.orangehrmlive.com/";
	data[0][2]="Admin";
	data[0][3]="admin123";
	data[0][4]="MECHANICAL";
	data[0][5]="MECH DES";
	
	
	data[0][0]="Chrome";
	data[1][1]="https://opensource-demo.orangehrmlive.com/";
	data[1][2]="Admin";
	data[1][3]="admin123";
	data[1][4]="MECHANICAL1";
	data[1][5]="MECH DES1";
	
	
	data[0][0]="Firefox";
	data[2][1]="https://opensource-demo.orangehrmlive.com/";
	data[2][2]="Admin";
	data[2][3]="admin123";
	data[2][4]="MECHANICAL2";
	data[2][5]="MECH DES2";
	
	
	
return data;

}



	@Test(dataProvider="AddSkills")
	public void Addskills_(String Browser,String TestURL,String Username,String Password,String skillname,String skilldescription ) throws Exception
	{
		AddSkills_Test2 T3=new AddSkills_Test2();
		T3.OpenChromeBrowser(Browser);
		T3.OpenOrangeHRM(TestURL);
		T3.Login(Username,Password);
		T3.Addskills(skillname,skilldescription);
		T3.CloseBrowser();
		
		
	}
	public void OpenChromeBrowser(String Browser) throws Exception
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
	public void OpenOrangeHRM(String TestURL) throws Exception
	{
		driver.get(TestURL);
	}
	
	public void Login(String Username,String Password) throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys(Username);
       findElement(By.id("txtPassword")).sendKeys(Password);
       findElement(By.id("btnLogin")).click();	
	}
	public void Addskills(String skillname,String skilldescription) throws Exception
	{
		
      
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Qualifications")).click();
       findElement(By.id("menu_admin_viewSkills")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("skill_name")).sendKeys(skillname);
       findElement(By.id("skill_description")).sendKeys(skilldescription);
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
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid orange'", elem);
		 
			}
			
			return elem;
		}
	}


