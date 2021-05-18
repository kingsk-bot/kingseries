package Day_10Actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Mouse_Hover {
	
	WebDriver driver;
	
	@Test
	public void Mouse_HouseTest() throws Exception
	{
		
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		
		
	   findElement(By.id("btnLogin")).click();
		
		
	   
	  
	   
		
		/*WebElement Admin=findElement(By.id("menu_admin_viewAdminModule"));
	   WebElement UserManagement=findElement(By.id("menu_admin_UserManagement"));
	   WebElement Users=findElement(By.id("menu_admin_viewSystemUsers"));
	   
	   
	   
	   Actions actions=new Actions(driver);
	   actions.moveToElement(Admin);
	   actions.moveToElement(UserManagement);
	   actions.moveToElement(Users).click().build().perform();*/
	   
	   
	   
	   
	  
	   
	   
		
		
	   WebElement Admin=findElement(By.id("menu_admin_viewAdminModule"));
	   WebElement Job=findElement(By.id("menu_admin_Job"));
	   WebElement JobTitles=findElement(By.id("menu_admin_viewJobTitleList"));
	   WebElement PayGrades=findElement(By.id("menu_admin_viewPayGrades"));
		
		Actions actions= new Actions(driver);
		actions.moveToElement(Admin);
		actions.moveToElement(Job);
		actions.moveToElement(JobTitles);
		actions.moveToElement(PayGrades).click().build().perform();
		
		
	}
	 public  WebElement findElement(By by) throws Exception 
		{
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}

}
