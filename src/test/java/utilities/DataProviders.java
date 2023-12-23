package utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	String path=".\\testData\\OpenCartTestData.xlsx";
	public String [][] getData(String SheetName) throws IOException
	{	
		ExcelUtility xlutil=new ExcelUtility(path);		
		int totalrows=xlutil.getRowCount(SheetName);	
		int totalcols=xlutil.getCellCount(SheetName,1);
		String data[][]=new String[totalrows][totalcols];	
		for(int i=1;i<=totalrows;i++)
		{		
			for(int j=0;j<totalcols;j++)
			{
				data[i-1][j]= xlutil.getCellData(SheetName,i, j);
			}
		}
	return data;
				
	}

	@DataProvider(name="LoginData")
	public String [][] getLoginData() throws IOException
	{	
		return getData("Login");
				
	}

	@DataProvider(name="LogoutData")
	public String [][] getLogoutData() throws IOException
	{	
		return getData("Logout");
				
	}
	
	@DataProvider(name = "RegistrationData")
	public String[][] getRegistrationData() throws IOException {
	    return getData("Registration");
	}
	
	@DataProvider(name = "SearchData")
	public String[][] getSearchData() throws IOException {
	    return getData("Search");
	}
}
