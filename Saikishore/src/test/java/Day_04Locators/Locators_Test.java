package Day_04Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators_Test {
	
	WebDriver driver;

	@Test
	public void Locator_Test()throws Exception
	{
	   
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	/*Locators......the webelements can be identified by through its 
	              1.id...........most commonly used to finding the  webelement through its id
	              2.name........most commonly used to finding the  webelement through its name
	         **** 3.xpath......some times webelement cannot to be finded by using its id or name..that time prefer xpath because every webelement having xpath
	              4.cssSelector.......some times used by cssselector
	              5.linkText......every time we inspecting the webpage.webelement properties changes rapidly.so hyperlinks are used to find the webelement
	              6.partial linktext....webelement properties changes dynamically so prefer partial link text
	              7.classname.....
	              8.tag .......the total number of hyperlinks are presented in the webpage can be finded by using the tag name  */
	
	//id 
	
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
	//name
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		
	//xpath
		
		driver.findElement(By.xpath("//*[@id=\'txtUsername\']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id=\'txtPassword\']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).click();
		
	//cssSelector
		driver.findElement(By.name("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("input#txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("input#btnLogin")).click();
	//linkText
		driver.findElement(By.name("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("input#txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("input#btnLogin")).click();
		
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Time")).click();
		
		//partial LinkText
		driver.findElement(By.partialLinkText("Admi")).click();
		driver.findElement(By.partialLinkText("Nationali")).click();
		driver.findElement(By.partialLinkText("Leav")).click();
		
		
		//className
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();
		
		
//tagName.........	link and partial linktext and tagname undercomes same category......it indiacates the hyperlinks(@,#,span,div,input,a,b..etc)
//the total number of links are presented on a webpage can be calcualted by using the tagname
		
		//List<WebElement>links1=driver.findElements(By.tagName(""));......for username...input
		//int links_count=links1.size();
		//;System.out.println("Number of hyperlinks in Homepage="+links_count);
		
		
	List<WebElement>links1=	driver.findElements(By.tagName("input"));
	int links_count=links1.size();
	System.out.println("number of Hyperlinks in Homepage="+links_count);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*List<WebElement>links1= driver.findElements(By.tagName("input"));
		int links_count=links1.size();
		System.out.println("Number of hyperlinks on Homepage :"+links_count);*/
		
		
		
		
	}

}
