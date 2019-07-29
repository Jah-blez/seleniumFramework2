package CIPM;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class CIPMExcel {
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public void excelUtils2 (String excelPath, String sheetname){

		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		//getRowCount();
		//getCellDataString(0,0);
		//getCellDataNum(1,1);
	}


	public static int  getRowCount() {

		int rowCount= 0;

		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("no of rows is: " + rowCount);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage());
			System.out.println( e.getCause());
			e.printStackTrace();
		}

		return rowCount;

	}

	public static String getCellDataString(int rowNum, int colNum) {
		String celldatastring = null;

		try {

			celldatastring = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(celldatastring);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage());
			System.out.println( e.getCause());
			e.printStackTrace();
		}
		return celldatastring;

	}
	public static void getCellDataNum(int rowNum, int colNum ) {

		try {

			double cellDataNum = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println(cellDataNum);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage());
			System.out.println( e.getCause());
			e.printStackTrace();
		}

	}
	public static int getcolCount() {

		int colCount= 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("no of column is: " + colCount);
		}catch(Exception e) {
			e.printStackTrace();	
		}
		return colCount;
	}


}
