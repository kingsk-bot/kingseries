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

public class Add_NewEmployee_Photo {
	
	WebDriver driver;
	

String Username,Password,firstName,middleName,lastName,employeeId,PhotoPath;


@DataProvider(name="AddEmployeePhoto")

public Object[][]Authentication1()throws Exception
{

  ExcelApiTest4 eat=new ExcelApiTest4();
  Object[][]testobjarray=eat.getTableArray("C://HTML Report//OrangeHRM6//TC02_Photo.xlsx","Sheet2");
  System.out.println(testobjarray.length);
  return(testobjarray);
  

}
            


	
	
	
	
	@Test(dataProvider="AddEmployeePhoto")
	public void AddNewEmployee_Photo(String Username,String Password,String firstName,String middleName,String lastName,String employeeId,String PhotoPath)throws Exception
	{
		Add_NewEmployee_Photo T1=new Add_NewEmployee_Photo();
		T1.OpenChromeBrowser();
		T1.Login(Username,Password);
		T1.AddEmployee(firstName,middleName,lastName,employeeId);
		T1.AddPhoto(PhotoPath);
		T1.CloseBrowser();
		
	}
		
		public void OpenChromeBrowser()throws Exception
		{
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		}
		
	public void Login(String Username,String Password)throws Exception
	{
		//driver.findElement(By.id("")).sendKeys("");
		findElement(By.id("txtUsername")).sendKeys(Username);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
	}
		
	public void AddEmployee(String firstName,String middleName,String lastName,String employeeId)throws Exception
	{
		findElement(By.id("menu_pim_viewPimModule")).click();
		findElement(By.id("menu_pim_addEmployee")).click();
		findElement(By.id("firstName")).sendKeys(firstName);
		findElement(By.id("middleName")).sendKeys(middleName);
		findElement(By.id("lastName")).sendKeys(lastName);
		findElement(By.id("employeeId")).sendKeys(employeeId);
		findElement(By.id("btnSave")).click();
	}
	
	public void AddPhoto(String PhotoPath)throws Exception
	{
		findElement(By.id("empPic")).click();
		
		WebElement Element=findElement(By.id("photofile"));
		Actions actions=new Actions (driver);
		actions.moveToElement(Element).click().build().perform();
		Thread.sleep(10000);
		
		
		
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
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", elem);
	 
		}
		
		return elem;
	}
}
