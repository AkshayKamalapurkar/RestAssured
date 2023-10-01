package api.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static FileInputStream fileinputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getcellValue(String fileName,String sheetName,int rowNo,int cellNo)
	{
		try {
			
			fileinputstream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fileinputstream);
			sheet = workbook.getSheet(sheetName);
			cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			
			workbook.close();
			return cell.getStringCellValue();
		}
		
		catch (Exception e) {
			return "";
		}
	}
	
	public static int getRowCount(String fileName,String sheetName)
	{
		try
		{
			fileinputstream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fileinputstream);
			sheet = workbook.getSheet(sheetName);
			
			//get total no of rows
			int ttlRows = sheet.getLastRowNum()+1;
			workbook.close();
			return ttlRows;
			
		}
		catch (Exception e) {
			return 0;
		}
	}
	public static int getColCount(String fileName,String sheetName)
	{
		try
		{
			fileinputstream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fileinputstream);
			sheet = workbook.getSheet(sheetName);
			
			//get total no of cells
			int ttlCells = sheet.getRow(0).getLastCellNum();
			workbook.close();
			return ttlCells;
			
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	
}
