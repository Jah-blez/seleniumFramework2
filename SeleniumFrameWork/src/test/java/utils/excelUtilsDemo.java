package utils;

public class excelUtilsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	String projectpath= System.getProperty("user.dir");
		excelUtils2 excel = new excelUtils2(projectpath+"/excel/data.xlsx", "Sheet1");
		
		excel.getCellDataNum(1, 1);
		excel.getCellDataString(0, 0);
		excel.getRowCount();
		excel.getcolCount();


	}

}
