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

public class Addjobtitles_Test {
	
	//String Browser;
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String Username="Admin",Password="admin123";
	//String jobTitle="software",jobDescription="IT field",jobnote="Tester";	
	
	
	
	
	
	
	
	
static WebDriver driver;
public static  int iRow=0;


@Parameters({"Browser"})
@BeforeTest
public static void OpenChromeBrowser(String Browser)throws Exception
{


driver=TestBrowser.OpenChromeBrowser();


}	







@DataProvider(name="AddJobs")
  public static Object[][] Authentication1()throws Exception
  {
	  
	ExcelApiTest4 eat=new ExcelApiTest4();
	Object[][] testObjarray=eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet4");
	System.out.println(testObjarray.length);
	return testObjarray;
	
	
  }






	@Test(dataProvider="AddJobs")
	public static void Addskills(String TestURL,String Username,String Password,String jobTitle,String jobDescription,String jobnote ) throws Exception
	{
		//Addjobtitles_Test T2=new Addjobtitles_Test();
		//T2.OpenChromeBrowser(Browser);
		//T2.OpenOrangeHRM(TestURL);
		//T2.Login(Username,Password);
		//T2.Addjobtitle(jobTitle,jobDescription,jobnote);
		//T2.CloseBrowser();
		
		
		if(iRow==0)
		{
			iRow=iRow+1;
			String str="AddJobsTest".concat("_iterration_").concat(String.valueOf(iRow));
			driver.get(TestURL);
			
			
			Login(Username,Password);
			Addjobtitle(jobTitle,jobDescription,jobnote);
		}
		else
		{
			iRow=iRow+1;
			String str="AddJobsTest".concat("_iterration_").concat(String.valueOf(iRow));
			Addjobtitle(jobTitle,jobDescription,jobnote);
		}
	}
		

public static void OpenOrangeHRM(String TestURL)throws Exception
{
		driver.get(TestURL);
		}
	
	public static void Login(String Username,String Password)throws Exception
	{
	   findElement(By.id("txtUsername")).sendKeys(Username);
       findElement(By.id("txtPassword")).sendKeys(Password);
       findElement(By.id("btnLogin")).click();	
	}	
      
     public static void Addjobtitle(String jobTitle,String jobDescription,String jobnote)throws Exception
     {
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Job")).click();
       findElement(By.id("menu_admin_viewJobTitleList")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle);
       findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDescription);
       findElement(By.id("jobTitle_note")).sendKeys(jobnote);
       findElement(By.id("btnSave")).click();
     }
       
     
     
     
     
     @AfterTest
     public static void CloseBrowser()throws Exception
     {
    	 driver.quit(); 
     }
      
      
     public  static  WebElement findElement(By by) throws Exception 
 	{
 				
 		 WebElement elem = driver.findElement(by);    	    
 		
 		 
 		if (driver instanceof JavascriptExecutor) 
 		{
 		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
 	 
 		}
 		
 		return elem;
 	}	
	

}
