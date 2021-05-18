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

import CommonUtil.OR;
import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest3;
import ExcelUtil.ExcelApiTest4;

public class Addphoto_NewEmployee {
	
	
	WebDriver driver;
	
	public static String Username,Password;
	public static String firstName,middleName,lastName, employeeId,photopath;
	//public static int iRow=0;
	
	
	@DataProvider(name="uploadphoto")
public   Object[][] Authentication1() throws Exception{
		
		ExcelApiTest4 eat= new ExcelApiTest4();
        Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC02_Photo.xlsx","Sheet2");
         System.out.println(testObjArray.length);
          return (testObjArray); 
	}
	
	
	@Test(dataProvider="uploadphoto")
	public void NewEmployee_photoUpload(String Username,String Password,String firstName,String middleName,String lastName,String employeeId,String photopath )throws Exception
	{
		
		OpenChromeBrowser();
		Login(Username,Password);
		AddEmployeeid(firstName,middleName,lastName,employeeId);
		photoupload(photopath);
        CloseBrowser();
	}	       
	public  void OpenChromeBrowser() throws Exception
	{
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	public  void Login(String Username,String Password)throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(Username);
		findElement(By.name("txtPassword")).sendKeys(Password);
		findElement(By.name("Submit")).click();	
	}
		
	public void AddEmployeeid(String firstName,String middleName,String lastName,String employeeId)throws Exception
	{
		findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b")).click();
		findElement(By.xpath("//*[@id='menu_pim_addEmployee']")).click();
		
		findElement(By.name("firstName")).sendKeys(firstName);
		findElement(By.name("middleName")).sendKeys(middleName);
		findElement(By.name("lastName")).sendKeys(lastName);
		findElement(By.name("employeeId")).sendKeys(employeeId);	
	}
		
		
	public  void photoupload(String photopath)throws Exception
	{
		WebElement ele1= findElement(By.xpath("//*[@id='photofile']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(ele1).click().build().perform();
		
		

			
			Thread.sleep(1000);
		StringSelection sel = new StringSelection(photopath);
		   // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection" +sel);
		 
		 // Create object of Robot class
		 Robot robot = new Robot();
		 Thread.sleep(2000);

		 
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
		Thread.sleep(8000);
		
	
	}
	
	
	public  void CloseBrowser() throws Exception
	{
		driver.quit();	
	}
	
	
	
	
	
	public   WebElement findElement(By by)throws Exception {
	    WebElement elem = driver.findElement(by);
	 
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", elem);
	    } 
	    Thread.sleep(10);
	    
	    return elem;
	}
	
}
