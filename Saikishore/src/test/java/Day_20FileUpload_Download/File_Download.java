package Day_20FileUpload_Download;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class File_Download {
	
	static WebDriver driver;
	
	public String DestinationFile;
	@Test
	public void File_download()throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		findElement(By.id("menu_pim_viewPimModule")).click();
		findElement(By.id("menu_pim_viewEmployeeList")).click();
		findElement(By.id("empsearch_id")).sendKeys("0002");
		findElement(By.id("searchBtn")).click();
		findElement(By.xpath("//*[@id=\'resultTable\']/tbody/tr[1]/td[2]/a")).click();
		
//		//*[@id="tblAttachments"]/tbody/tr/td[2]/a..........txt document xpath
		
		
		String str1="//*[@id=\'tblAttachments\']/tbody/tr/td[2]/a"; 
		
		WebElement Element=findElement(By.xpath(str1));
		String fname=Element.getText();
		 findElement(By.linkText(fname)).click();
		 
		 
		 String SrcFile="C:\\Users\\USER\\Downloads\\"+fname;
	 	 String DestinationFile="C:\\HTML Report\\"+fname;

	 	Thread.sleep(6000);
	 	moveFile(SrcFile, DestinationFile);
		
	}
	
	
	
	 public static void moveFile(String src, String dest ) throws InterruptedException {
	        Path result = null;
	        try {
	           result =  Files.move(Paths.get(src), Paths.get(dest));
	           
	           
	           Thread.sleep(5000);
	        } catch (IOException e) {
	           System.out.println("Exception while moving file: " + e.getMessage());
	        }
	        if(result != null) {
	           System.out.println("File moved successfully.");
	        }else{
	           System.out.println("File movement failed.");
	        }  
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
