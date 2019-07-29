package CIPM;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;

public class activeDiet {

	private static WebDriver driver;
	static String projectpath_excel;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public static Properties prop= new Properties();
	static String projectpath= System.getProperty("user.dir");


	@Test
	public static void testActiveDietFoundation1() throws Exception {
		InputStream input = new FileInputStream(projectpath +"/src/test/java/CIPM/loginfile");
		prop.load(input);
		String username =prop.getProperty("username");
		
		InputStream input2 = new FileInputStream(projectpath +"/src/test/java/CIPM/loginfile");
		prop.load(input2);
		String password =prop.getProperty("password");
		

		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/login");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();


		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='subtitles'])[3]/following::span[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Exam Application'])[1]/following::span[2]")).click();

		for (int i=0;i<6;i++) {

			//getting diet to apply to, else create diet
			List <WebElement> applybutton = driver.findElements(By.xpath("//a[contains(text(),'Apply')]"));
			List <WebElement> applyheader = driver.findElements(By.xpath("//*[@id=\"bar-parent1\"]/div/div/div/div/div/div/div/table/tbody/tr/td[2]"));
			String headeritem = applyheader.get(i).getText();
			
			String applylist = applybutton.get(i).getText();

			if (applybutton.size() >0) {
				applybutton.get(i).click();
			}
			else {
				ExamTimetable examtimetable = new ExamTimetable();
				examtimetable.testExamTimetable();
			}


			driver.findElement(By.id("CenterId")).click();
			new Select(driver.findElement(By.id("CenterId"))).selectByVisibleText("IBADAN");
			driver.findElement(By.id("CenterId")).click();
			driver.findElement(By.name("StudyCentre")).click();
			new Select(driver.findElement(By.name("StudyCentre"))).selectByVisibleText("GSS, Garki, Area 10.");
			driver.findElement(By.name("StudyCentre")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Study Centers'])[1]/following::button[1]")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Payment Options'])[1]/following::input[3]")).click();
			driver.findElement(By.id("paymentbtn")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.xpath("//a[@class='editable']")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='dashboard'])[4]/following::span[1]")).click();
			driver.findElement(By.xpath("//i[@class='fa fa-vcard']")).click();
			

			//getting the exam number from the photocard generated to update excel sheet
			WebElement element = driver.findElement(By.xpath("//*[@id=\"bar-parent1\"]/form/div[2]/div/div[1]/div[2]/div"));
			String text = element.getText();

			InputStream input3 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
			prop.load(input3);
			String excelPath =prop.getProperty("excelpath"+(i+1));
			System.out.println(excelPath);

			Thread.sleep(4000);
			
			InputStream input4 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
			prop.load(input4);
			String sheetname =prop.getProperty("Sheetname"+(i+1));
			System.out.println(sheetname);
			

			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetname);

			XSSFCell cell = sheet.getRow(1).getCell(0);
			System.out.println(cell);
            cell.setCellValue(text);
            System.out.println(text);
        	System.out.println(cell);
        	
        	
        	
        	resultUpload.checkitem=headeritem;
        	   
        	
        	resultUpload.testResultUpload(i);
        	

        	


        	}
        	
        

		}


	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}







}


