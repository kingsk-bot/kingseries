package Day_21Excel_Apache_POI;

import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class AddEducation_Test_XlsX {
	
public FileInputStream fis=null;
public FileOutputStream fout=null;
public XSSFWorkbook workbook=null;
public XSSFSheet sheet=null;
public XSSFRow row=null;
public XSSFCell cell=null;

	
WebDriver driver;	
String TestURL,Username,Password,educationname;

	@Test
	public void Addskills() throws Exception
	{
	
		AddEducation_Test_XlsX eat=new AddEducation_Test_XlsX();
		
		TestURL=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1",1,0);
		Username=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1",1,1);
		Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1",1,2);
		educationname=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1",1,3);
		
		driver=TestBrowser.OpenChromeBrowser();
		//String TestURL="https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
	
	
	   findElement(By.id("txtUsername")).sendKeys(Username);
       findElement(By.id("txtPassword")).sendKeys(Password);
       findElement(By.id("btnLogin")).click();	
		
      
     
       findElement(By.id("menu_admin_viewAdminModule")).click();
       findElement(By.id("menu_admin_Qualifications")).click();
       findElement(By.id("menu_admin_viewEducation")).click();
       findElement(By.id("btnAdd")).click();
       findElement(By.id("education_name")).sendKeys(educationname);
       findElement(By.id("btnSave")).click();
       
       
       
       driver.quit();
   	
	}
	 
	public String getCellData(String XlFilepath,String Sheetname,int rownum,int columnnumber)throws Exception
	{
		fis=new FileInputStream(XlFilepath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(Sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(columnnumber);
		
		if(cell.getCellTypeEnum() == CellType.STRING)
        {	
        	String str6=cell.getStringCellValue();
        	System.out.println(" str6 value : "+str6);
        	
        	workbook.close();
        	fis.close();
            return str6;
        }
        else if(cell.getCellTypeEnum() == CellType.NUMERIC)
        {	
        	
        	int i = (int)cell.getNumericCellValue(); 
        	String str6 = String.valueOf(i); 
        	workbook.close();
        	fis.close();
            return str6;
        }
        else 
        {
        	String str6=cell.getStringCellValue();
        	workbook.close();
        	fis.close();
            return str6;
        }
		
	}
	
	
	
	
	public   WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}
}
