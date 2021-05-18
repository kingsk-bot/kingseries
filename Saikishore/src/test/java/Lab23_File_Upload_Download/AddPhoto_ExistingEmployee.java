package Lab23_File_Upload_Download;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

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
	
	
	WebDriver driver;
	
	@DataProvider (name = "TC01_Add_Employee_Data")
    public static  Object[][] Authentication1() throws Exception{
		
		ExcelApiTest4 eat= new ExcelApiTest4();
        Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC02_Photo.xlsx","Sheet1");
         System.out.println(testObjArray.length);
          return (testObjArray); 
	}
	
	@Test(dataProvider="TC01_Add_Employee_Data")
	public  static void AddEmployee_call_allmethods(
			String UserName,String Password,String EmployeeId,String PhotoPath )throws Exception
	{  
		AddPhoto_ExistingEmployee T1=new AddPhoto_ExistingEmployee();
		T1.OpenChromeBrowser();
		T1. Login(UserName,Password);
		T1.  AddEployeeId(EmployeeId);
		T1. PhotoUpload(PhotoPath);
		T1. CloseBrowser();
	}
		
		
		
		
		
		
		
		public void OpenChromeBrowser()throws Exception
		{
	   
		driver=TestBrowser.OpenChromeBrowser();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		}
		
		public void Login(String Username, String Password)throws Exception
		{
		findElement(By.xpath("//*[@id=\'txtUsername\']")).sendKeys(Username);
		findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(Password);
		findElement(By.xpath("//*[@id='btnLogin']")).click();
		}
		
		public void AddEployeeId(String empsearchid)throws Exception
		{
			findElement(By.linkText("PIM")).click();	
			 findElement(By.linkText("Employee List")).click();
			 findElement(By.id("empsearch_id")).sendKeys(empsearchid);
			 findElement(By.id("searchBtn")).click();
			 findElement(By.linkText(empsearchid)).click();
			 findElement(By.id("empPic")).click();
			 
				//*[@id="photofile"]
			 WebElement Ele=  findElement(By.xpath("//*[@id='photofile']"));
			   Thread.sleep(1000);
			   
				Actions actions = new Actions(driver);
				
				 actions.moveToElement(Ele).click().build().perform();
				
		}
		
		public   void PhotoUpload(String PhotoPath)throws Exception
		{
			//Specify the file location with extension
			//StringSelection sel = new StringSelection("C:\\Users\\Sudhakar\\Desktop\\download1.jpg");
			 
			 StringSelection sel = new StringSelection(PhotoPath);
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
			
			 
			 // Create object of Robot class
			 Robot robot = new Robot();
			 //Thread.sleep(2000);
			 
			  // Press CTRL+V
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 
			// Release CTRL+V
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyRelease(KeyEvent.VK_V);
			 Thread.sleep(2000);
			        
			       //  Press Enter 
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 
			 
			 Thread.sleep(8000);
		
			findElement(By.id("btnSave")).click();
			
			
			Thread.sleep(10000);
			 

			 
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void CloseBrowser()throws Exception
		{
		driver.quit();
		}
		
	

	
	
	
	
	public  WebElement findElement(By by)throws Exception {
	    WebElement elem = driver.findElement(by);
	 
	    
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", elem);
	    } 
	    Thread.sleep(10);
	    
	    return elem;
	}
	}
