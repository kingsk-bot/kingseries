package Day_19PageFactory_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Jobs {
	
	WebDriver driver;
	
	public void Jobs(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement Admin ;
	
	@FindBy(id="menu_admin_Job")
	WebElement Job ;
	
	@FindBy(id="menu_admin_viewJobTitleList")
	WebElement JobTitles ;
	
	@FindBy(id="btnAdd")
	WebElement Add ;
	
	@FindBy(id="jobTitle_jobTitle")
	WebElement JobTitle ;
	
	@FindBy(id="jobTitle_jobDescription")
	WebElement JobDescription ;
	
	@FindBy(id="jobTitle_note")
	WebElement JobNote ;
	
	@FindBy(id="btnSave")
	WebElement Save ;
	
	@Test
	public void AddJobs() throws Exception
	{
		
		Admin.click();
		
		Job.click();
		
		JobTitles.click();
		
		Add.click();
		
		JobTitle.sendKeys("KGF");
		
		JobDescription.sendKeys("Humble");
		
		
		JobNote.sendKeys("WONDER");
		
		Save.click();
		
		
		
		
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
