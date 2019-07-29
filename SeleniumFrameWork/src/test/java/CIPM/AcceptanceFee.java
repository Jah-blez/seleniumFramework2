package CIPM;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AcceptanceFee {

	public static Properties prop= new Properties();
	static String projectpath= System.getProperty("user.dir");
	private static WebDriver driver;	

	@Test
	public static void testAcceptanceFee() throws Exception {
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
		
		
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Payment Options'])[1]/following::label[3]")).click();
		driver.findElement(By.id("paymentbtn")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@class='editable']")).click();
		
		driver.quit();
	}



}
