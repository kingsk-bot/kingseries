package Day_09ExtentEmaialble_Report;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonUtil.TestBrowser;



public class AddSkills_Test {
	
	
	
WebDriver driver;

ExtentTest logger;
ExtentReports extent;
String screenShotPath;
public static String TestScriptName = "Addskills";
public static String TestName;





	@Test
	public void Addskills() throws Exception
	{
	
		driver=TestBrowser.OpenChromeBrowser();
// step3 start here - ExtendsHtmlReport starts
				 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
				 Date now = new Date();
				 String strDate = sdfDate.format(now);
				 
				 TestName=TestScriptName+"_"+strDate+".html";
				 TestScriptName=TestScriptName+"_"+strDate;
				  String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
				  
 //String TestHtmlName=TestName;
				 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
				 
				 System.out.println("Html Report path is : "+TestHtmlName);
				 
				 extent=new ExtentReports();
				 extent.attachReporter(reporter);
				 logger=extent.createTest(TestName);
				//step3 ends here ExtendsHtmlReport ends
				 
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
	
	
	   findElement(By.id("txtUsername")).sendKeys("Admin");
	   screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered user Name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
       findElement(By.id("txtPassword")).sendKeys("admin123");
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered Password",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
       
       findElement(By.id("btnLogin")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - clicked on Login",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
      
       findElement(By.id("menu_admin_viewAdminModule")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - clicked on Admin ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
       findElement(By.id("menu_admin_Qualifications")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - clicked on Qualifications",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
       findElement(By.id("menu_admin_viewSkills")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - clicked on skills",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
       findElement(By.id("btnAdd")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Home Page - clicked on Add",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
       findElement(By.id("skill_name")).sendKeys("skillname");
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered skill name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
       findElement(By.id("skill_description")).sendKeys("skill desc");
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered skill description",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
       findElement(By.id("btnSave")).click();
       screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - clicked on Save",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
       
      driver.quit();
		
	}
	 public  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid black'", elem);
		 
			}
			
			return elem;
		}
}
