package Day_21Excel_Apache_POI;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest3;
import ExcelUtil.ExcelApiTest4;

public class Addjobtitles_Test_import_To_Excel_xls_multipledata {
	
public FileInputStream fis=null;
public FileOutputStream fout=null;
public HSSFWorkbook workbook=null;
public HSSFSheet sheet=null;
public HSSFRow row=null;
public HSSFCell cell=null;

	
WebDriver driver;
String  TestURL,Username,Password,jobTitle,jobDescription,jobnote;

	@Test
	public void Addskills() throws Exception
	{
		
		
		  ExcelApiTest4 eat=new ExcelApiTest4();
		  
          int RowCount=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1");
    	
 		System.out.println("Row Count  :"+RowCount);
 		RowCount=RowCount-1;
 		
 		
	 		for (int i=1;i<=RowCount;i++)
	 		{
	 			TestURL=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet4",i,0);
		    	 Username=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet4",i,1);
				 Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet4",i,2);
				 
		       jobTitle=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet4",i,3);
		     jobDescription=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet4",i,4);
		     jobnote=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet4",i,5);
		
		
		
		
		
	
		driver=TestBrowser.OpenChromeBrowser();
		//String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
	
	
	   findElement(By.id("txtUsername")).sendKeys("Admin");
       findElement(By.id("txtPassword")).sendKeys("admin123");
       findElement(By.id("btnLogin")).click();	
		
      
       
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Job")).click();
       findElement(By.id("menu_admin_viewJobTitleList")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("jobTitle_jobTitle")).sendKeys("software");
       findElement(By.id("jobTitle_jobDescription")).sendKeys("ITfield");
       findElement(By.id("jobTitle_note")).sendKeys("ITfield note");
       findElement(By.id("btnSave")).click();
       
       
       driver.quit();
      
		
	 		}
	}
	 public   WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
		 
			}
			
			return elem;
		}
}
