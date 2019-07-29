package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils {
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0,0);
		getCellDataNum(1,1);
	}


	public static void  getRowCount() {

		try {
			projectpath= System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectpath+"/excel/data.xlsx");
			sheet = workbook.getSheet("sheet1");
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("no of rows is: " + rowCount);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage());
			System.out.println( e.getCause());
			e.printStackTrace();
		}

	}

	public static void getCellDataString(int rowNum, int colNum) {

		try {
			projectpath= System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectpath+"/excel/data.xlsx");
			sheet = workbook.getSheet("sheet1");
			String celldatastring = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(celldatastring);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage());
			System.out.println( e.getCause());
			e.printStackTrace();
		}

	}
	public static void getCellDataNum(int rowNum, int colNum ) {

		try {
			projectpath= System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectpath+"/excel/data.xlsx");
			sheet = workbook.getSheet("sheet1");
			double cellDataNum = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellDataNum);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage());
			System.out.println( e.getCause());
			e.printStackTrace();
		}

	}
}
