package Day_10Actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Drag_Drop {
	
	WebDriver driver;
	
	@Test
	public void doubleclick() throws Exception
	{
		
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="http://testautomationpractice.blogspot.com/";
		driver.get(TestURL);
		
		

		
		
	//drag&drop
		
		
		
		
		
		WebElement Drag=driver.findElement(By.xpath("//*[@id=\'draggable\']"));
		WebElement Drop=driver.findElement(By.xpath("//*[@id=\'droppable\']"));
		
		Actions actions=new Actions(driver);
		actions.dragAndDrop(Drag,Drop).click().build().perform();
		
		
		
	}

}
