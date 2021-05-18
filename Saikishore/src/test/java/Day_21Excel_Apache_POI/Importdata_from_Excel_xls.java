package Day_21Excel_Apache_POI;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Importdata_from_Excel_xls {
	
	WebDriver driver;
	public FileInputStream fis=null;
	public FileOutputStream fout=null;
	public HSSFWorkbook workbook=null;
	public HSSFSheet sheet=null;
	public HSSFRow row=null;
	public HSSFCell cell=null;
	
	
	String TestURL,Username,Password,languagename;
	
	@Test
	public void Importdata_xls() throws Exception
	{
		
		  
		  
            Importdata_from_Excel_xls eat=new  Importdata_from_Excel_xls(); 
		  
		
	
		    TestURL=eat.getCellData("C://SaiHTMLReport//SaiOrangeHRM12//TC01_Languages.xls","Sheet1",1,0);
			Username=eat.getCellData("C://SaiHTMLReport//SaiOrangeHRM12//TC01_Languages.xls","Sheet1",1,1);
			Password=eat.getCellData("C://SaiHTMLReport//SaiOrangeHRM12//TC01_Languages.xls","Sheet1",1,2);
			languagename=eat.getCellData("C://SaiHTMLReport//SaiOrangeHRM12//TC01_Languages.xls","Sheet1",1,3);
		
	        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	       driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get(TestURL);
		
		
		
	      driver.findElement(By.name("txtUsername")).sendKeys(Username);
	      driver.findElement(By.name("txtPassword")).sendKeys(Password);
	      driver.findElement(By.name("Submit")).click();
		
		
		
	      driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	      driver.findElement(By.id("menu_admin_Qualifications")).click();
	      driver.findElement(By.id("menu_admin_viewLanguages")).click();
	      driver.findElement(By.id("btnAdd")).click();
	      driver.findElement(By.id("language_name")).sendKeys(languagename);
	      driver.findElement(By.id("btnSave")).click();
		
	      driver.quit();
		
	}
	
public String getCellData(String XlFilePath,String Sheetname,int Rownum,int Columnnumber)throws Exception
{
	  fis=new FileInputStream(XlFilePath);
	  workbook=new HSSFWorkbook(fis);
	  sheet=workbook.getSheet(Sheetname);
	  row=sheet.getRow(Rownum);
	  cell=row.getCell(Columnnumber);
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
}




