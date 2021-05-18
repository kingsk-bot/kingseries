package Day_15TestNG_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations_Test {
	
	WebDriver driver;
	
	
@BeforeSuite
public void Test1() throws Exception
{
	System.out.println("1");
}
	
@BeforeTest
public void  Test2() throws Exception
{
	System.out.println("2");
}

@BeforeClass
public void Test3() throws Exception
{
	System.out.println("3");
}
@BeforeMethod
public void Test4() throws Exception
{
System.out.println("4");	
}
	

	
	@Test
	public void Annotations_Test5() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	
	}
	@AfterMethod
	public void Test6() throws Exception
	{
		System.out.println("6");
	}

	@AfterClass
	public void Test7() throws Exception
	{
	System.out.println("7");	
	}
	
	@AfterTest
	public void Test8() throws Exception
	{
	System.out.println("8");	
	}
	
	@AfterSuite
	public void Test9() throws Exception
	{
	System.out.println("9");	
	}
}
