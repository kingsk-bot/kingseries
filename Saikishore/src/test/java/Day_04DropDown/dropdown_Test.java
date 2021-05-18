package Day_04DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class dropdown_Test {
	WebDriver driver;
	
	@Test
	public void DropDown_Test()throws Exception
	{
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();
	
   
   
    driver.findElement(By.id("menu_admin_viewAdminModule")).click();
    driver.findElement(By.id("menu_admin_Organization")).click();
    driver.findElement(By.id("menu_admin_viewLocations")).click();
    
    
 // driver.findElement(By.id("searchLocation_country")).click();
   
   /* Select dropdown1= new Select(driver.findElement(By.id("searchLocation_country")));
       dropdown1.selectByVisibleText("India");*/
       
                              //or
     // Select dropdown2=new Select(driver.findElement(By.id("searchLocation_country")));
          // dropdown2.selectByIndex(2);
           
           
          Select dropdown3=new Select(driver.findElement(By.id("searchLocation_country")));
             dropdown3.selectByValue("1");
   
    driver.findElement(By.id("btnSearch")).click();
    
    
    
    
	}

}
