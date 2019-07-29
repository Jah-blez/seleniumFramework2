package CIPM;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ActiveDietFoundation1 {
	public static String email;
	public static String password;
	private WebDriver driver;



	@BeforeTest
	public void setUp() throws Exception {
		String projectpath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testActiveDietFoundation1() throws Exception {

		driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/login");
		driver.findElement(By.id("Email")).click();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).click();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='subtitles'])[3]/following::span[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Exam Application'])[1]/following::span[2]")).click();

		//getting diet to apply to, else create diet
		List <WebElement> applybutton = driver.findElements(By.xpath("//a[contains(text(),'Apply')]"));

		String applylist = applybutton.get(0).getText();

		if (applybutton.size() >0) {
			applybutton.get(0).click();
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
		driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();


	}
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}







}

