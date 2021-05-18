package Day_22_TakeScreenShot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class TakeScreenShot {
	
	WebDriver driver;
	@Test
	public void TakeScreenShot_Test()throws Exception
	{
	driver=TestBrowser.OpenChromeBrowser();
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	driver.get(TestURL);
	takeSnapShot(driver,"C:\\HTML Report\\test-output\\Test2\\ScreenShot1.png") ;
	
	findElement(By.id("txtUsername")).sendKeys("Admin");
	takeSnapShot(driver,"C:\\HTML Report\\test-output\\Test2\\ScreenShot2.png") ;
	
	
	
	
	findElement(By.id("txtPassword")).sendKeys("admin123");
	takeSnapShot(driver,"C:\\HTML Report\\test-output\\Test2\\ScreenShot3.png") ;
	
	
	
	
	findElement(By.name("Submit")).click();
	takeSnapShot(driver,"C:\\HTML Report\\test-output\\Test2\\ScreenShot4.png") ;
	
	driver.quit();
	}
	 public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot
	        TakesScreenshot scrShot =((TakesScreenshot)driver);

	        //Call getScreenshotAs method to create image file
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	        //Move image file to new destination
	        File DestFile=new File(fileWithPath);

	        //Copy file at destination
	        FileUtils.copyFile(SrcFile, DestFile);
	        
	        String ScreenShotPath = DestFile.getAbsolutePath();
			 ScreenShotPath = ScreenShotPath.replace("\\", "/");
			 
			 System.out.println("Screen Shot Path : "+ScreenShotPath);
	}

	
	
	
	

	
	
	
	
	public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", elem);
	 
		}
		
		return elem;
	}
			
}





/*step1: import java.io.file, OutputFile,FileUtils,TakeScreenshot files
//step:2 write syntax as takeSnapShot(driver,"c:\\HTML\\Screenshot.png");
//step:3 Declare public void takeSnapshot(WebDriver,String FileWithpath) throws Exception
{
//Convert web driver object to TakeScreenshot
TakesScreenshot scrShot =((TakesScreenshot)driver);

//Call getScreenshotAs method to create image file
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

//Move image file to new destination
File DestFile=new File(fileWithPath);

//Copy file at destination
FileUtils.copyFile(SrcFile, DestFile);

String ScreenShotPath = DestFile.getAbsolutePath();
 ScreenShotPath = ScreenShotPath.replace("\\", "/");
 
 System.out.println("Screen Shot Path : "+ScreenShotPath);
}*/

