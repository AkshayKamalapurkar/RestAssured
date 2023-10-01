package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProvidersTest {

	@DataProvider(name = "test")
	public String[][] AllDataProvider()
	{
		String fname = System.getProperty("user.dir")+"//resources//UserData";
		int ttlRowCount = ReadExcelFile.getRowCount(fname, "Sheet1");
		int ttlColcount = ReadExcelFile.getColCount(fname, "Sheet1");
		String userData[][] = new String [ttlRowCount][ttlColcount];
		
		for(int rowNo=1;rowNo<ttlRowCount;rowNo++)
		{
			for(int colNo=0;colNo<ttlColcount;colNo++)
			{
				userData[rowNo-1][colNo] = ReadExcelFile.getcellValue(fname, "Sheet1", rowNo, colNo);
			}
		}
		return userData;
	}
	
	@DataProvider(name = "UserNames")
	public String[] UserNameDataProvider()
	{
		String fname = System.getProperty("user.dir")+"//resources//UserData";
		int ttlRowCount = ReadExcelFile.getRowCount(fname, "Sheet1");
		//int ttlColcount = ReadExcelFile.getColCount(fname, "Sheet1");
		String userData[] = new String [ttlRowCount];
		
		for(int rowNo=1;rowNo<ttlRowCount-1;rowNo++)
		{
				userData[rowNo-1] = ReadExcelFile.getcellValue(fname, "Sheet1", rowNo, 1);
		}
		return userData;
	}
}
