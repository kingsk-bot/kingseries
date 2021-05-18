package Day_19PageFactory_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddJobs {
	WebDriver driver;
	
	
	
	@BeforeTest
	public void OpenChromeBrowser() throws Exception
	{
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
	
	
	
	
	
	
	@Test
	public void AddJobs_Test() throws Exception
	{
		LoginPage L1=new LoginPage();
		L1.LoginPage(driver);
		L1.Login();
		
		
		Jobs J1=new Jobs();
		J1.Jobs(driver);
		J1.AddJobs();
		
		HomePage H1=new HomePage();
		H1.HomePage(driver);
		H1.Logout();
		
		
	}

	
	
	
	@AfterTest
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
