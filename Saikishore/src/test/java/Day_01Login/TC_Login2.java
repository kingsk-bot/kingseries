package Day_01Login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class TC_Login2 {
	
	
	
	WebDriver driver;
	
	@Test
	public void Login_Test()throws Exception
	{
		//launch browser method1
	/*System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");*/
	
	//launch browser method2
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
	
	
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();
    
    
    driver.findElement(By.linkText("Admin")).click();
    
    
    
  
    
    JavascriptExecutor js=(JavascriptExecutor)driver;
    WebElement Element=driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[42]/td[4]"));
    js.executeScript("arguments[0].scrollIntoView()",Element);
    js.executeScript("arguments[0].style.border='3px solid blue'",Element);
    
    
  
    //JavascriptExecutor js=(JavascriptExecutor)driver;
    WebElement Element1=driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[48]/td[3]"));
    js.executeScript("arguments[0].scrollIntoView()",Element1);
    js.executeScript("arguments[0].style.border='3px solid blue'",Element1);
    
    
  
    
    WebElement Element2=driver.findElement(By.xpath("//*[@id=\'resultTable\']/tbody/tr[36]/td[2]"));
    js.executeScript("arguments[0].scrollIntoView()",Element2);
    js.executeScript("arguments[0].style.border='3px solid blue'",Element2);
    
    
    
    
	}

}
