package CIPM;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class resultUpload {

	private static WebDriver driver;
	public static Properties prop= new Properties();
	static String projectpath= System.getProperty("user.dir");
	public static String checkitem;

	@Test
	public static void testResultUpload(int i) throws Exception {
		
		
		InputStream input = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input);
		String admin =prop.getProperty("adminlogin1");
		System.out.println(admin);

		InputStream input2 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input2);
		String password =prop.getProperty("password1");
		System.out.println(password);
		
		

		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/login");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(admin);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();

		
		Thread.sleep(3200);
		driver.findElement(By.xpath("//a[@class='nav-link nav-toggle']//span[@class='title'][contains(text(),'Result Upload')]")).click();
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Member Result Upload')]")).click();
		
		List <WebElement> uploadbutton = driver.findElements(By.xpath("//*[@id=\"applicant-list\"]/tbody/tr/td[2]"));
		int uploadsize = uploadbutton.size();
		for(int j=0; j< (uploadsize+1); j++) {
			
			String container= uploadbutton.get(j).getText();
			
			
			System.out.println("Container Outside = " + container);
			System.out.println("checkitem Outside = " + checkitem);
			
		//	String comparetext;
			
		//	for(int kk=0; kk< checkitem.length(); kk++) {
			//	comparetext = comparetext + checkitem[kk];
			//}
			
			if (checkitem == container) {
				
				System.out.println("Container Inside = " + container);
				System.out.println("checkitem Inside = " + checkitem);
				
				driver.findElement(By.xpath("//*[@id=\"applicant-list\"]/tbody/tr["+(j+1)+"]/td[6]/a[1]")).click();
			}
		
		}
		

		//getting excel path so file can be uploaded
		InputStream input3 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input3);
		String excelPath =prop.getProperty("excelpath"+(i+1));



		driver.findElement(By.id("ResultFile")).clear();
		driver.findElement(By.id("ResultFile")).sendKeys(excelPath);



		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Download Template'])[1]/following::button[1]")).click();



		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='P'])[2]/following::button[1]")).click();

		Thread.sleep(8000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CIPM'])[1]/following::span[1]")).click();


		driver.findElement(By.linkText("Log Out")).click();
		/*
		//student login
		InputStream input4 = new FileInputStream(projectpath +"/src/test/java/CIPM/loginfile");
		prop.load(input4);
		String username =prop.getProperty("username");
		
		InputStream input5 = new FileInputStream(projectpath +"/src/test/java/CIPM/loginfile");
		prop.load(input5);
		String password3 =prop.getProperty("password");
		

		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/login");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password3);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();

		
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='dashboard'])[5]/following::span[1]")).click();
		driver.findElement(By.id("ExamDietRegID")).click();
		new Select(driver.findElement(By.id("ExamDietRegID"))).selectByVisibleText("new diet");
		driver.findElement(By.id("ExamDietRegID")).click();
		driver.findElement(By.id("Year")).click();
		new Select(driver.findElement(By.id("Year"))).selectByVisibleText("2019");
		driver.findElement(By.id("Year")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Exam Year'])[1]/following::button[1]")).click();
	*/
	
	}


	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}



}



