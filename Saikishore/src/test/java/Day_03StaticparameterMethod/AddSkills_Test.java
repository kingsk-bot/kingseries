package Day_03StaticparameterMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddSkills_Test {
	
	
	
static WebDriver driver;

static String TestURL="https://opensource-demo.orangehrmlive.com/";
static String Username="Admin",Password="admin123";

static String skillname="MECHANICAL",skilldescription="MECH DES";


	@Test
	public void Addskills_() throws Exception
	{
		
		AddSkills_Test.OpenChromeBrowser();
		AddSkills_Test.OpenOrangeHRM(TestURL);
		AddSkills_Test.Login(Username,Password);
		AddSkills_Test.Addskills(skillname,skilldescription);
		AddSkills_Test.CloseBrowser();
		
		
	}
	public static  void OpenChromeBrowser() throws Exception
	{
		driver=TestBrowser.OpenChromeBrowser();
		//String TestURL="https://opensource-demo.orangehrmlive.com/";
	}
	public static void OpenOrangeHRM(String TestURL) throws Exception
	{
		driver.get(TestURL);
	}
	
	public static void Login(String Username,String Password) throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys(Username);
       findElement(By.id("txtPassword")).sendKeys(Password);
       findElement(By.id("btnLogin")).click();	
	}
	public static void Addskills(String skillname,String skilldescription) throws Exception
	{
		
      
       findElement(By.id("menu_admin_viewAdminModule")).click();
      findElement(By.id("menu_admin_Qualifications")).click();
       findElement(By.id("menu_admin_viewSkills")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("skill_name")).sendKeys(skillname);
       findElement(By.id("skill_description")).sendKeys(skilldescription);
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
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid purple'", elem);
		 
			}
			
			return elem;
		}
	}


