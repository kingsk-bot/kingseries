package Day_21Excel_Apache_POI;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class AddSkills_Test_exportdata_to_excel_from_Ecllipse {
	
	
	
WebDriver driver;
public FileInputStream fis=null;
public FileOutputStream fout=null;
public XSSFWorkbook workbook=null;
public XSSFSheet sheet=null;
public XSSFRow row=null;
public XSSFCell cell=null;


	@Test
	public void Addskills() throws Exception
	{
		AddSkills_Test_exportdata_to_excel_from_Ecllipse eat=new AddSkills_Test_exportdata_to_excel_from_Ecllipse();
		eat.PutCellData("C://HTML Report//OrangeHRM6//TC01_EMPExport3.xlsx","Sheet1",1,0,"sai");
		eat.PutCellData("C://HTML Report//OrangeHRM6//TC01_EMPExport3.xlsx","Sheet1",1,1,"sai123");
		eat.PutCellData("C://HTML Report//OrangeHRM6//TC01_EMPExport3.xlsx","Sheet1",1,2,"sai123");
		
	}
	
	public  void PutCellData(String xlFilePath,String sheetName,int rowNum,int column,String Text)
    		throws Exception
    {
   
   	 
   	 	fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
    	sheet = workbook.getSheet(sheetName);
    	
    	if(sheet.getRow(rowNum)==null)
    	{
    		row=sheet.createRow(rowNum);
    	}
    	else
    	{
    		row=sheet.getRow(rowNum);
    	}
    	
    	
    	if(row.getCell(column)==null)
    	{
    		cell=row.createCell(column);
    	}
    	else
    	{
    		cell=row.getCell(column);
    	}

   	
    	cell = sheet.getRow(rowNum).getCell(column);  
    	cell.setCellValue(Text);
    	
         
         CellStyle cs1 = workbook.createCellStyle(); 
         cs1.setFillForegroundColor(IndexedColors.WHITE.getIndex()); 
         cs1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
     
         Font font = workbook.createFont();
         font.setColor(IndexedColors.BLUE.getIndex());
         font.setBold(false);
         cs1.setFont(font);
   
    	
    	System.out.println("Text:"+Text);
    	cell.setCellStyle(cs1);
    	cell.setCellValue(Text);
    	
  
    	
    	fout= new FileOutputStream(xlFilePath);
    	workbook.write(fout);
     
        fout.flush();
        fout.close();
        workbook.close();
        fis.close();
 
    }
    
    
    
    	
	
	 public  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid black'", elem);
		 
			}
			
			return elem;
		}
}
