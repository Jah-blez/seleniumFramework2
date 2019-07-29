package CIPM;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.testng.internal.annotations.TestOrConfiguration;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



public class corporateApplication {
	private static WebDriver driver;
	public static Properties prop= new Properties();
	static String projectpath= System.getProperty("user.dir");

	@Test
	public static void testCorporateApplication() throws Exception {
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
		
		
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Corporate Application'])[1]/following::a[1]")).click();

		Thread.sleep(3000);
		driver.findElement(By.id("paymentbtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Organization")).click();
		driver.findElement(By.id("Organization")).clear();
		driver.findElement(By.id("Organization")).sendKeys("Orgasm");
		driver.findElement(By.id("BusinessAddress")).click();
		driver.findElement(By.id("BusinessAddress")).clear();
		driver.findElement(By.id("BusinessAddress")).sendKeys("PH");
		driver.findElement(By.id("PhoneNo")).click();
		driver.findElement(By.id("PhoneNo")).clear();
		driver.findElement(By.id("PhoneNo")).sendKeys("09087654321");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Mobile No'])[1]/following::div[2]")).click();
		driver.findElement(By.id("RepresentativeApplicant")).click();
		driver.findElement(By.id("RepresentativeApplicant")).clear();
		driver.findElement(By.id("RepresentativeApplicant")).sendKeys("ray");
		driver.findElement(By.id("Designation")).click();
		driver.findElement(By.id("Designation")).clear();
		driver.findElement(By.id("Designation")).sendKeys("Graphics");
		driver.findElement(By.id("NatureofBusiness")).click();
		driver.findElement(By.id("NatureofBusiness")).clear();
		driver.findElement(By.id("NatureofBusiness")).sendKeys("Shooting");
		
		InputStream input3 = new FileInputStream(projectpath +"/src/test/java/CIPM/loginfile");
		prop.load(input3);
		String filepath =prop.getProperty("filepath");


		driver.findElement(By.id("CertificateOfIncorporationPath")).sendKeys(filepath);

		driver.findElement(By.id("CompanyProfilePath")).sendKeys(filepath);

		driver.findElement(By.id("CurrentAnnualReportFinancialStatementPath")).sendKeys(filepath);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Save and Edit Later'])[1]/following::button[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Payment Options'])[1]/following::input[3]")).click();
		driver.findElement(By.id("paymentbtn")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-circle btn-success']")).click();
		driver.findElement(By.xpath("//a[@class='editable']")).click();
		driver.findElement(By.linkText("Close")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}


}

