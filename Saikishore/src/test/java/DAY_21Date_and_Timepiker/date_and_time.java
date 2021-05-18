package DAY_21Date_and_Timepiker;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class date_and_time {
	
	WebDriver driver;
	@Test
	public void Date_Time() throws Exception
	{
	driver=TestBrowser.OpenChromeBrowser();
	driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	driver.get(TestURL);
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		
		
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		driver.findElement(By.id("menu_leave_viewLeaveList")).click();
		driver.findElement(By.xpath("//*[@id=\'frmFilterLeave\']/fieldset/ol/li[1]/img")).click();
		
		Select Year=new Select(driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/div/select[2]")));
		Year.selectByVisibleText("2021");
		
		Select month=new Select(driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/div/select[1]")));
		month.selectByVisibleText("Apr");
		
		//String str1="//*[@id=\'ui-datepicker-div\']/table/tbody/tr[4]/td[5]/a";
		
		String str1="//*[text()='24']";
		
		Actions actions=new Actions(driver);
		WebElement Element=driver.findElement(By.xpath(str1));
		actions.moveToElement(Element).click().build().perform();
		
		
	
		
	}

}
