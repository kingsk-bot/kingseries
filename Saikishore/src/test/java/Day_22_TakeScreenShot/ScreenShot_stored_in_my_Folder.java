package Day_22_TakeScreenShot;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class ScreenShot_stored_in_my_Folder {
	
	
	
	WebDriver driver;
	@Test
	public void Screenshot_Test()throws Exception
	{
	driver=TestBrowser.OpenChromeBrowser();
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	driver.get(TestURL);
	TakesScreenshot scrShot1 =((TakesScreenshot)driver);
	 File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(SrcFile1, new File("C:\\Screenshot folder\\TC1_ScreenShot1.jpg"));
	
		
		
	findElement(By.id("txtUsername")).sendKeys("Admin");
	TakesScreenshot scrShot2 =((TakesScreenshot)driver);
	 File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(SrcFile2, new File("C:\\Screenshot folder\\TC1_ScreenShot2.jpg"));
	
	findElement(By.id("txtPassword")).sendKeys("admin123");
	TakesScreenshot scrShot3 =((TakesScreenshot)driver);
	 File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(SrcFile3, new File("C:\\Screenshot folder\\TC1_ScreenShot3.jpg"));
	
	findElement(By.name("Submit")).click();
	
	TakesScreenshot scrShot4 =((TakesScreenshot)driver);
	 File SrcFile4=scrShot4.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(SrcFile4, new File("C:\\Screenshot folder\\TC1_ScreenShot4.jpg"));
	

	 
	
		
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


//Steps
/*	
TakesScreenshot scrshot1=((TakesScreenshot)driver);
File SrcFile1=scnshot1.getScreenshotAs(OutputType.File);
FileUtils.copyFile(SrcFile1,new File("C:\\SAI\\Screenshot1.jpg"));*/