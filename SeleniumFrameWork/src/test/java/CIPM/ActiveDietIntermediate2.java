package CIPM;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ActiveDietIntermediate2 {
	public static String email;
	public static String password;
	private WebDriver driver;


	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		String projectpath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//maximize window
		driver.manage().window().maximize();
	}

	@Test
	public void testActiveDietIntermediate2() throws Exception {
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

		if (applybutton.size() >3) {
			applybutton.get(4).click();
		}
		else {
			ExamTimetable examtimetable = new ExamTimetable();
			examtimetable.testExamTimetable();
		}
		
		driver.findElement(By.id("CenterId")).click();
		new Select(driver.findElement(By.id("CenterId"))).selectByVisibleText("ENUGU");
		driver.findElement(By.id("CenterId")).click();
		driver.findElement(By.name("StudyCentre")).click();
		new Select(driver.findElement(By.name("StudyCentre"))).selectByVisibleText("Azure Management Services");
		driver.findElement(By.name("StudyCentre")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Study Centers'])[1]/following::button[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Payment Options'])[1]/following::input[3]")).click();
		driver.findElement(By.id("paymentbtn")).click();

		//click payment link
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//click continue link
		driver.findElement(By.xpath("//a[@class='editable']")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='dashboard'])[4]/following::span[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Collabo'])[1]/following::a[1]")).click();

		//click download
		driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}


}

