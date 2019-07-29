package CIPM;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class LoginPage {
	static WebDriver driver;
	public static Properties prop= new Properties();
	static String projectpath= System.getProperty("user.dir");


	@Test
	public static void userlogin() throws IOException  {

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

	}

	@Test
	public static void adminlogin() throws IOException  {

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


	}
	@Test
	public static void adminlogin2() throws IOException  {

		InputStream input = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input);
		String admin =prop.getProperty("adminlogin2");
		System.out.println(admin);

		InputStream input2 = new FileInputStream(projectpath +"/src/test/java/CIPM/loginfile");
		prop.load(input2);
		String password =prop.getProperty("password2");
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


	}
	
	@Test
	public static void Studentapproverlogin1() throws IOException  {

		InputStream input = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input);
		String admin =prop.getProperty("studentapproveradmin1");
		System.out.println(admin);

		InputStream input2 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input2);
		String password =prop.getProperty("studentapproverpassword1");
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


	}
	
	public static void Studentapproverlogin2() throws IOException  {

		InputStream input = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input);
		String admin =prop.getProperty("studentapproveradmin2");
		System.out.println(admin);

		InputStream input2 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input2);
		String password =prop.getProperty("studentapproverpassword2");
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


	}

	@AfterTest
	public static void teardown() {
		driver.quit();
	}
}
