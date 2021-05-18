package DAY_14TestNG_Groups;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class TestNG_Group_Test {
	
	WebDriver driver;
	
	@Test(groups= {"TestNG"})
	public void TestNg_Test() throws Exception
	{
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
	
	@Test(groups={"Google"})
	public void Google_Test() throws Exception
	{
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://www.google.co.in/?gws_rd=ssl";
		driver.get(TestURL);	
	}
	
	@Test(groups={"Fb"})
	public void Fb_Test() throws Exception
	{
		driver=TestBrowser.OpenChromeBrowser();
		String TestURL="https://www.facebook.com/";
		driver.get(TestURL);		
	}
	
	
	

}
