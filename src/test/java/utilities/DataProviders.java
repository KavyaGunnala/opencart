package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException
	{
		String path=".\\testData\\OpencartLoginData.xlsx";
		ExcelUtility xl=new ExcelUtility(path);
		int totalrows= xl.getRowCount("Sheet1");
		int totalcols= xl.getCellCount("Sheet1", 1);
		String logindata[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
	
}
