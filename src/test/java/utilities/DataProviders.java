package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {


	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{	
		String LoginSheetName = "Login";
		String path=".\\testData\\Opencart_TestData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);		
		int totalrows=xlutil.getRowCount(LoginSheetName);	
		int totalcols=xlutil.getCellCount(LoginSheetName,1);
		String logindata[][]=new String[totalrows][totalcols];	
		for(int i=1;i<=totalrows;i++)
		{		
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]= xlutil.getCellData(LoginSheetName,i, j);
			}
		}
	return logindata;
				
	}
}
