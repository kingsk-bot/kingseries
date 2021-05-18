package Day_18PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddSkills {

	WebDriver driver;
@BeforeTest
public void OpenChromeBrowser() throws Exception
{
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
}
	
	
	
	@Test
	public void AddSkills() throws Exception
	{
		
		LoginPage L1=new LoginPage();
		L1.LoginPage(driver);
		L1.Login();
		
		
		Skills S1=new Skills();
		S1.Skills(driver);
		S1.AddSkills();
		
		
		
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
	 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
 
	}
	return elem;
}
	
}
