package CIPM;



import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class registration {
	private WebDriver driver;
	public static Properties prop= new Properties();
	static String projectpath= System.getProperty("user.dir");
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {


		//System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		//driver = new ChromeDriver();

		String projectpath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	@Parameters({"Fname", "Lname", "email" , "password", "adminemail"})
	public void testApplicantRegistration(@Optional ("Jobs") String Fname, String Lname, String email, String password, String adminemail) throws Exception {
		driver.get("http://192.168.8.43/CIPMMembershipPortal/home/index?ReturnUrl=%2fCIPMMembershipPortal%2f");
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='NYSC Application'])[1]/following::a[1]")).click();

		DecimalFormat df = new DecimalFormat("###.##");

		Fname= Fname + df.format(Math.random()*37898);
		Lname= Lname + df.format(Math.random()*37898);
		email= email + df.format(Math.random()*37898) + "@gmail.com";

		Thread.sleep(3000);

		driver.findElement(By.id("FirstName")).click();
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("FirstName")).sendKeys(Fname);
		driver.findElement(By.id("LastName")).click();
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("LastName")).sendKeys(Lname);
		driver.findElement(By.id("Email")).click();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("ConfirmEmail")).click();
		driver.findElement(By.id("ConfirmEmail")).clear();
		driver.findElement(By.id("ConfirmEmail")).sendKeys(email);
		driver.findElement(By.id("Password")).click();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Clear'])[1]/following::button[1]")).click();

		driver.get("http://192.168.8.43/CIPMMembershipPortal/portal/login");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(adminemail);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("pass");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='card_travel'])[2]/following::span[1]")).click();
		driver.findElement(By.id("Email")).click();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email'])[1]/following::button[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change Email'])[1]/following::button[1]")).click();

		//Assert.assertTrue(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[1]/following::div[1]"))); 

		Thread.sleep(8000);

		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CIPM'])[1]/following::span[1]")).click();
		driver.findElement(By.linkText("Log Out")).click();

		OutputStream output = new FileOutputStream(projectpath +"/src/test/java/CIPM/loginfile");
		prop.setProperty("username", email);
		prop.setProperty("password", password);
		prop.store(output, null);

	
		System.out.println("email is: "+ email + " password is : " + password);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}


}
