package Day_05Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Dp_Test {
	 WebDriver driver;
	
	
	@DataProvider(name="AddEducation")
	
	public  Object [][] Dptest()throws Exception
	{
		return new Object[][] {
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","BMW"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","BMW12"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","BMW13"},
			
		};
	}
	
	
	
	
	
	@Test(dataProvider="AddEducation")
	public void DPtest(String TestURL,String Username,String Password,String education_name)throws Exception
	{
	driver=TestBrowser.OpenChromeBrowser();
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	driver.get(TestURL);
	

    findElement(By.id("txtUsername")).sendKeys(Username);
    findElement(By.id("txtPassword")).sendKeys(Password);
    findElement(By.id("btnLogin")).click();	
		
   
    
    findElement(By.id("menu_admin_viewAdminModule")).click();
    findElement(By.id("menu_admin_Qualifications")).click();
    findElement(By.id("menu_admin_viewEducation")).click();
    findElement(By.id("btnAdd")).click();
    findElement(By.id("education_name")).sendKeys(education_name);
    findElement(By.id("btnSave")).click();
    
    
    
    driver.quit();
	
	
	}
	
	
	
	
	public  WebElement findElement(By by) throws Exception {
		
	          WebElement elem = driver.findElement(by);
	    	    
	    
	         if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", elem);
	        
	    }
	    return elem;
	}
	

}
