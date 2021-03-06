package CIPM;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ResultUploadIntermediate1 {
	private WebDriver driver;


	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		String projectpath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testResultUploadIntermediate1() throws Exception {
		driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/Login");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("oteebest@yahoo.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("pass");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='cloud_upload'])[1]/following::span[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Result Upload'])[1]/following::span[2]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Open'])[6]/following::a[1]")).click();
		
		//input path without clicking on the dialog box
		driver.findElement(By.id("ResultFile")).clear();
		driver.findElement(By.id("ResultFile")).sendKeys("C:\\Users\\gonyebuchi\\downloads\\result INT.xlsx");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Download Template'])[1]/following::button[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='P'])[1]/following::button[1]")).click();

		//slow down for alert to disappear
		Thread.sleep(8000);

		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CIPM'])[1]/following::span[1]")).click();
		driver.findElement(By.linkText("Log Out")).click();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("jibegbulam44@vatebra.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("pass");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='dashboard'])[5]/following::span[1]")).click();
		driver.findElement(By.id("ExamDietRegID")).click();
		new Select(driver.findElement(By.id("ExamDietRegID"))).selectByVisibleText("Test22");
		driver.findElement(By.id("ExamDietRegID")).click();
		driver.findElement(By.id("Year")).click();
		new Select(driver.findElement(By.id("Year"))).selectByVisibleText("2019");
		driver.findElement(By.id("Year")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Exam Year'])[1]/following::button[1]")).click();
		
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}


}
