package Day_11Frames;







import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class switch_into_frame_by_index{
	
	static WebDriver driver;
	@Test
	
	public void frame_by_index() throws Exception
	{
	
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.bhavasri.com/Frames/AllContacts.html");
		
		
		
			List<WebElement>frames=driver.findElements(By.tagName("iframe"));
			 
			System.out.println("number of frames in homepage="+frames.size());
		
			
			
			driver.switchTo().frame(frames.get(0));
			
			driver.findElement(By.name("firstname")).sendKeys("sai");
			driver.findElement(By.name("lastname")).sendKeys("kishore");
			driver.findElement(By.id("subject1")).sendKeys("tester");
			
			
			
			driver.switchTo().defaultContent();
			
			
			
			
			
			driver.switchTo().frame(frames.get(1));
			driver.findElement(By.name("firstname")).sendKeys("sai");
			driver.findElement(By.name("lastname")).sendKeys("kishore");
			driver.findElement(By.id("subject")).sendKeys("tester");
			driver.switchTo().defaultContent();
			
			
			driver.quit();
			
		
	}

}
