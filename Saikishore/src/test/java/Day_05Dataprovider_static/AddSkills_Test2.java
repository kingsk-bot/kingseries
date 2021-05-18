package Day_05Dataprovider_static;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddSkills_Test2 {
	
	
	
static WebDriver driver;

static String TestURL="https://opensource-demo.orangehrmlive.com/";
static String Username="Admin",Password="admin123";

static String skillname="MECHANICAL",skilldescription="MECH DES";


@DataProvider(name="AddSkills")


public Object[][] Dptest() throws Exception
{
      Object[][] data=new Object[2][5];
	  
	data[0][0]="https://opensource-demo.orangehrmlive.com/";
	data[0][1]=	"Admin";
	data[0][2]="admin123";
	data[0][3]="MECHANICAL";
	data[0][4]="MECH DES";
	
	data[1][0]="https://opensource-demo.orangehrmlive.com/";
	data[1][1]=	"Admin";
	data[1][2]="admin123";
	data[1][3]="MECHANICAL";
	data[1][4]="MECH DES";
	return data;
	};
	
	
	






	@Test(dataProvider="AddSkills")
	public void Addskills_(String TestURL,String Username,String Password,String skillname,String skilldescription ) throws Exception
	{
		
		AddSkills_Test2.OpenChromeBrowser();
		AddSkills_Test2.OpenOrangeHRM(TestURL);
		AddSkills_Test2.Login(Username,Password);
		AddSkills_Test2.Addskills(skillname,skilldescription);
		AddSkills_Test2.CloseBrowser();
		
		
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


