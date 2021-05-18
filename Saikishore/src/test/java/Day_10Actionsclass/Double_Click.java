package Day_10Actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Double_Click {
	
	WebDriver driver;
	
	@Test
	public void doubleclick() throws Exception
	{
		
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="http://testautomationpractice.blogspot.com/";
		driver.get(TestURL);
		
		WebElement Copy_Text=driver.findElement(By.xpath("//*[@id=\'HTML10\']/div[1]/button"));
		
		Actions actions=new Actions(driver);
		actions.doubleClick(Copy_Text).click().build().perform();
		
	}

}
