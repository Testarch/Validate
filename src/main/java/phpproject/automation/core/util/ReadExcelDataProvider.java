package phpproject.automation.core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataProvider 

{
	
	//static Logger log = Logger.getLogger(ReadExcelDataProvider.class);
	
	public static String[][] getExcelData(String fileName, String sheetName , String TestName) 

	
	{
		String Active = "Y";
		String[][] arrayExcelData = null;
		int count = 0;
		int k = 0;
		try 
		
		{
			
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
	
		// Check whether excel sheet with test data is empty or not	
			
			if(null!=SuiteUtil.TCList && !SuiteUtil.TCList.isEmpty())
			{
			//Get the No. of Rows with Condition
			for (int x= 0 ; x < totalNoOfRows; x++) 
			
			{
				

				if(SuiteUtil.TCList.contains(sh.getCell(0, x).getContents()) && sh.getCell(1, x).getContents().equalsIgnoreCase(Active))
				{
					
			
					if(sh.getCell(3, x).getContents().equalsIgnoreCase(TestName) && sh.getCell(1, x).getContents().equalsIgnoreCase(Active))
					
					{
						count++;
					}
				}
				
			}
			
			}
			
			
			arrayExcelData = new String[count][totalNoOfCols];
			if(null!=SuiteUtil.TCList && !SuiteUtil.TCList.isEmpty())
			
			{
			for (int i= 0 ; i < totalNoOfRows; i++) 
			
			{
				
				if(SuiteUtil.TCList.contains(sh.getCell(0, i).getContents()) && sh.getCell(1, i).getContents().equalsIgnoreCase(Active))
				{
				 
					if(sh.getCell(3, i).getContents().equalsIgnoreCase(TestName) && sh.getCell(1, i).getContents().equalsIgnoreCase(Active))
				
				{
				for (int j=0; j < totalNoOfCols; j++) 
				
				{
					arrayExcelData[k][j] = sh.getCell(j, i).getContents().trim();
				}   
				
				k++;
				
				}
				
				}
			}
			}
		} 
		
		catch (FileNotFoundException e) 
		
		{
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		
		{
			e.printStackTrace();
			e.printStackTrace();
		} 
		
		catch (BiffException e) 
		
		{
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	// To read all rows and columns of the excel sheet
	
	@SuppressWarnings({ "resource", "unused", "rawtypes" })

	public static String[][] getExcelDataxlsx(String fileName, String sheetName , String TestName) 
	
	{
		String Active = "Y";
		String[][] arrayExcelData = null;
		int count = 0;
		int k = 0;
		try {
			
			InputStream fs = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = 0;
			int totalNoOfRows = sh.getLastRowNum();
			totalNoOfRows= totalNoOfRows +1;
			XSSFRow row; 
			XSSFCell cell;

			Iterator rows = sh.rowIterator();
			
			
						
			if(null!=SuiteUtil.TCList && !SuiteUtil.TCList.isEmpty())
			{
			//Get the No. of Rows with Condition
			for (int x= 0 ; x < totalNoOfRows; x++) 
			
			{
				
				String getSuitName=sh.getRow(x).getCell(0).getStringCellValue();
				String getStatus=sh.getRow(x).getCell(1).getStringCellValue();
				if(SuiteUtil.TCList.contains(getSuitName) && Active.equals(getStatus))
				{
					
					
					if(sh.getRow(x).getCell(3).getStringCellValue().equals(TestName) && sh.getRow(x).getCell(1).getStringCellValue().equals(Active))
					{
						totalNoOfCols = sh.getRow(x).getLastCellNum();
						count++;
					}
				}
				
			}
			
			}
			
			
			arrayExcelData = new String[count][totalNoOfCols];
			if(null!=SuiteUtil.TCList && !SuiteUtil.TCList.isEmpty())
			
			{
			for (int i= 0 ; i < totalNoOfRows; i++) 
			
			{
				if(SuiteUtil.TCList.contains(sh.getRow(i).getCell(0).getStringCellValue()) && sh.getRow(i).getCell(1).getStringCellValue().equals(Active))
				{
					
	
				if(sh.getRow(i).getCell(3).getStringCellValue().equals(TestName) && sh.getRow(i).getCell(1).getStringCellValue().equals(Active))
				{
				for (int j=0; j < totalNoOfCols; j++) 
				
				{
					arrayExcelData[k][j] = sh.getRow(i).getCell(j).getStringCellValue();
				} 
				
				k++;
				
				}
				}
			}
			}
		} 
		
		catch (FileNotFoundException e) 
		
		{
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		
		{
			e.printStackTrace();
			e.printStackTrace();
		}
		return arrayExcelData;
	}

}