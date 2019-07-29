package CIPM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class getPassword {

	@Test
	public static void test() throws Exception {
		
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		WebDriver driver;
		Properties prop= new Properties();
		String projectpath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
	
		
		
		InputStream input3 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input3);
		String excelPath =prop.getProperty("excelpath");
		
		Thread.sleep(4000);
		
		InputStream input4 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input4);
		String sheetname =prop.getProperty("Sheetname");
		
		

		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetname);
		
		for(int i=0; i<10; i++) {

		XSSFCell cell = sheet.getRow(i+1).getCell(4);
		
		String ID = cell.toString();

	

	
	driver.get("http://192.168.8.124/cipm/amaka.aspx");
	driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(ID);
	driver.findElement(By.xpath("//input[@id='txtsecure']")).clear();
	driver.findElement(By.xpath("//input[@id='txtsecure']")).sendKeys("j");
	driver.findElement(By.xpath("//input[@id='btnFtech']")).click();
	
	WebElement passwordderived = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]"));
	String password1 = passwordderived.getText();
	
	Thread.sleep(10000);
	
	driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/login");
	driver.findElement(By.id("Email")).clear();
	driver.findElement(By.id("Email")).sendKeys(ID);
	driver.findElement(By.id("Password")).clear();
	driver.findElement(By.id("Password")).sendKeys(password1);
	
	
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
		
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(text(),'My Profile')]")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CIPM'])[1]/following::span[1]")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.linkText("Log Out")).click();
	}
	
	
		
		
		driver.close();
		driver.quit();
	}
	
	
}
