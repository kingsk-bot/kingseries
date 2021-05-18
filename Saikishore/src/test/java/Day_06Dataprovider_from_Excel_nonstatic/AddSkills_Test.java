package Day_06Dataprovider_from_Excel_nonstatic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class AddSkills_Test {
	
	
	
WebDriver driver;

//String TestURL="https://opensource-demo.orangehrmlive.com/";
//String Username="Admin",Password="admin123";

//String skillname="MECHANICAL",skilldescription="MECH DES";

@DataProvider(name="AddSkills")

public Object[][] Authentication1()throws Exception
{
	ExcelApiTest4 eat=new ExcelApiTest4();
	Object[][] testObjarray=eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx", "Sheet3");
	System.out.println(testObjarray.length);
	return testObjarray;
	
}






	@Test(dataProvider="AddSkills")
	public void Addskills_(String TestURL,String Username,String Password,String skillname,String skilldescription  ) throws Exception
	{
		AddSkills_Test T3=new AddSkills_Test();
		T3.OpenChromeBrowser();
		T3.OpenOrangeHRM(TestURL);
		T3.Login(Username,Password);
		T3.Addskills(skillname,skilldescription);
		T3.CloseBrowser();
		
		
	}
	public void OpenChromeBrowser() throws Exception
	{
		driver=TestBrowser.OpenChromeBrowser();
		//String TestURL="https://opensource-demo.orangehrmlive.com/";
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


