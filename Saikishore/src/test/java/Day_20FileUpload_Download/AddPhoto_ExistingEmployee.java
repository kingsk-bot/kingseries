package Day_20FileUpload_Download;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class AddPhoto_ExistingEmployee {
	
   static WebDriver driver;
   
   
  //static String Username,Password,empsearchid; 
   
   @DataProvider(name="PhotoUpload")
   
   public static Object[][]Authentication1() throws Exception
   {
	  ExcelApiTest4 eat= new ExcelApiTest4(); 
	  Object[][]testobjarray=eat.getTableArray("C://HTML Report//OrangeHRM6//TC02_Photo.xlsx","Sheet1");
	  System.out.println(testobjarray.length);
	  return (testobjarray);
   }
   
   
	@Test(dataProvider="PhotoUpload")
	public void AddPhoto_Existing_Employee(String Username,String Password,String empsearchid,String PhotoPath) throws Exception
	{
		AddPhoto_ExistingEmployee.OpenChromeBrowser();
		AddPhoto_ExistingEmployee.OpenOrangeHRM();
		AddPhoto_ExistingEmployee.Login(Username,Password);
		AddPhoto_ExistingEmployee.AddExistingEmployee(empsearchid);
		AddPhoto_ExistingEmployee.AddPhoto(PhotoPath);
		AddPhoto_ExistingEmployee.CloseBrowser();
		
		
	}	
		
		public static void OpenChromeBrowser() throws Exception
		{
	    driver=TestBrowser.OpenChromeBrowser();
		}
		public static void OpenOrangeHRM() throws Exception
		{
	    String TestURL="https://opensource-demo.orangehrmlive.com/";
	    driver.get(TestURL);
		}
	    
		public static void Login(String Username,String Password) throws Exception
		{
			
		
	   // driver.findElement(By.id("")).sendKeys("");	
	    findElement(By.id("txtUsername")).sendKeys(Username);	
	    findElement(By.id("txtPassword")).sendKeys(Password);	
	    findElement(By.id("btnLogin")).click();
	    
		}
	    
	   public static void AddExistingEmployee(String empsearchid) throws Exception
	   {
	    findElement(By.id("menu_pim_viewPimModule")).click();
	    findElement(By.id("menu_pim_viewEmployeeList")).click();
	    findElement(By.id("empsearch_id")).sendKeys(empsearchid);
	    findElement(By.id("searchBtn")).click();
	    findElement(By.xpath("//*[@id=\'resultTable\']/tbody/tr[1]/td[2]/a")).click();
	    findElement(By.id("empPic")).click();
	    
	    WebElement Element=findElement(By.id("photofile"));
	    Actions actions=new Actions(driver);
	    actions.moveToElement(Element).click().build().perform();
	    Thread.sleep(10000);
	    
	    
	   }
	   
	   public static void AddPhoto(String PhotoPath) throws Exception
	   {
		   
		   
		   StringSelection sel=new StringSelection(PhotoPath);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		   
		   Robot robot=new Robot();
		   
		   robot.keyPress(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_V);
		   
		   robot.keyRelease(KeyEvent.VK_CONTROL);
		   robot.keyRelease(KeyEvent.VK_V);
		   Thread.sleep(2000);
		   
		   robot.keyPress(KeyEvent.VK_ENTER);
		   robot.keyRelease(KeyEvent.VK_ENTER);
		   Thread.sleep(10000);
		   
		   findElement(By.id("btnSave")).click();
		   Thread.sleep(10000);
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
