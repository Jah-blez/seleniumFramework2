package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	/*public static void main(String[] args) {

	//String projectpath= System.getProperty("user.dir");
	//testData(projectpath+"/excel/data.xlsx", "Sheet1");

}*/
	@Test(dataProvider="test1data")
	public void test1(String username, String password) {
		System.out.println(username+ "|" + password);
	}

	@DataProvider(name = "test1data")
	public static Object[][] getData() {
		String projectpath= System.getProperty("user.dir");
		Object data [][] = testData(projectpath+"/excel/data.xlsx", "Sheet1");
		return data;
	}

	public static Object[][] testData(String excelPath, String sheetName) {

		excelUtils2 excel = new excelUtils2(excelPath, sheetName);

		int rowCount =excel.getRowCount();
		int colCount = excel.getcolCount();

		//initializing array excluding the header "username" and "password"
		Object data[][] = new Object [rowCount-1][colCount];

		for (int i=1; i< rowCount; i++) {
			for (int j=0; j< colCount; j++) {
				String celldata = excel.getCellDataString(i, j);
				//System.out.print(celldata + "|");

				//saving into array
				data[i-1][j]=celldata;
				//System.out.println(data);

			}//System.out.println();
		}return data;
	} 

}
