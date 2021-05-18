package Day_07TestNG_Parameter_Excel_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class AddSkills_Test {
	
	
static WebDriver driver;

public  static int iRow=0;


@Parameters({"Browser"})


@BeforeTest
public static void OpenChromeBrowser(String Browser) throws Exception
{
	
	driver=TestBrowser.OpenChromeBrowser();
	
}




@DataProvider(name="AddSkills")

public static Object[][] Authentication1() throws Exception
{
	ExcelApiTest4 eat=new ExcelApiTest4();
	Object[][] testObjarray=eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet3");
	System.out.println(testObjarray.length);
	return testObjarray;
	
}



	@Test(dataProvider="AddSkills")
	
	public  static  void Addskills(String TestURL,String Username,String Password,String skillname,String skilldescription ) throws Exception
	{
		
		if(iRow==0)
		{
			iRow=iRow+1;
			String str="AddSkillsTest".concat("_iterration_").concat(String.valueOf(iRow));
			driver.get(TestURL);
			Login(Username,Password);
			Addskills(skillname,skilldescription);
			
		}
		else
		{
			iRow=iRow+1;
			String str="AddSkillsTest".concat("_iterration_").concat(String.valueOf(iRow));
			Addskills(skillname,skilldescription);
		}
		
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
	
	
	
	
	
	@AfterTest
	public void CloseBrowser() throws Exception
	{
       
      driver.quit();
	}
	
	
	
	
	
	
	
	
	 public static  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid orange'", elem);
		 
			}
			
			return elem;
		}
	}


