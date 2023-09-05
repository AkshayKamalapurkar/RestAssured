package api.utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProvidersExample {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	@DataProvider(name = "test")
	public Object[][] getData() {
		Object[][] data = { { "1111", "testuser1", "KimWick", "Kim@gmail.com", "test@1", "23423" },
				{ "1122", "testuser2", "Wang", "Han@gmail.com", "rest@2", "23433" } };
		return data;
	}

	@DataProvider(name = "test1")
	public Object[][] getData1() throws Exception {
		DataFormatter formatter = new DataFormatter();

		String filepath = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
		fis = new FileInputStream(filepath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		row = sheet.getRow(0);
		int colcount = row.getLastCellNum();

		Object data[][] = new Object[rowcount - 1][colcount];

		for (int i = 0; i < rowcount - 1; i++) {
			row = sheet.getRow(i + 1);
			if (row != null)
			{
			for (int j = 1; j < colcount; j++) {
				cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
			}
		}

		return data;
	}

}
