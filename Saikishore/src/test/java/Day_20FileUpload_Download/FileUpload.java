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
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class FileUpload {
	
	static WebDriver driver;
	
	public String DestinationFile;
	@Test
	public void File_Upload()throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		//driver.findElement(By.id("")).sendKeys("");
		
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
		
		
		findElement(By.id("menu_pim_viewPimModule")).click();
		findElement(By.id("menu_pim_viewEmployeeList")).click();
		findElement(By.id("empsearch_id")).sendKeys("0002");
		findElement(By.id("searchBtn")).click();
		findElement(By.xpath("//*[@id=\'resultTable\']/tbody/tr/td[2]/a")).click();
		
		
		 String str1="C:\\HTML Report\\EMP_Photos\\bsnl.txt";
		 PhotoUpload(str1);
	}
		
	
	
	
	
	
	public void PhotoUpload(String PhotoPath) throws Exception
	{
		findElement(By.id("btnAddAttachment")).click();
		
		WebElement File=driver.findElement(By.id("ufile"));
		Actions actions=new Actions(driver);
		actions.moveToElement(File).click().build().perform();
		Thread.sleep(10000);

		
		
		StringSelection sel=new StringSelection(PhotoPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection" +sel);
		 
		 
		 Robot robot=new Robot();
		 Thread.sleep(1000);
		 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(2500);
		 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(5000);
		 
		 
		 
		
		
		
		driver.findElement(By.id("txtAttDesc")).sendKeys("Text 123");
		
		driver.findElement(By.id("btnSaveAttachment")).click();
		Thread.sleep(12000);
		
		
	
		
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
