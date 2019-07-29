package CIPM;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class application_Student_Approval {
	private static WebDriver driver;
	public static Properties prop= new Properties();
	static String projectpath= System.getProperty("user.dir");

	@Test
	public static void testApprovingApplication() throws Exception {
		InputStream input = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input);
		String admin =prop.getProperty("studentapproveradmin1");
	

		InputStream input2 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input2);
		String password =prop.getProperty("studentapproverpassword1");
		

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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"remove-scroll\"]/ul/li[2]/a/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"remove-scroll\"]/ul/li[2]/ul/li[1]/a/span")).click();
		driver.findElement(By.id("routeId")).click();
		new Select(driver.findElement(By.id("routeId"))).selectByVisibleText("Student Application");
		driver.findElement(By.id("routeId")).click();
		driver.findElement(By.id("statusId")).click();
		new Select(driver.findElement(By.id("statusId"))).selectByVisibleText("Pending");
		driver.findElement(By.id("statusId")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Student Application List'])[2]/following::button[1]")).click();

		//getting diet to apply to, else create diet
		List <WebElement> actionbutton = driver.findElements(By.xpath("//tr//td[6]//div[1]//button[1]"));
		int actionlist= actionbutton.size();
		actionbutton.get(actionlist-1).click();


		driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-left show']//li//a[@href='javascript:void(0)'][contains(text(),'Process')]")).click();

		Thread.sleep(7000);

		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Actions'])[1]/following::label[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("CommentForApplicant")).click();
		driver.findElement(By.id("CommentForApplicant")).clear();
		driver.findElement(By.id("CommentForApplicant")).sendKeys("jhhkjn");
		driver.findElement(By.id("CommentForInternal")).clear();
		driver.findElement(By.id("CommentForInternal")).sendKeys("jhbkjn");
		driver.findElement(By.id("ProgramId")).click();
		new Select(driver.findElement(By.id("ProgramId"))).selectByVisibleText("FOUNDATION I CIPM Student Program");
		driver.findElement(By.id("ProgramId")).click();
		driver.findElement(By.id("submit-action")).click();

		Thread.sleep(10000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CIPM'])[1]/following::span[1]")).click();
		driver.findElement(By.linkText("Log Out")).click();

		InputStream input3 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input3);
		String admin2 =prop.getProperty("studentapproveradmin2");
		
		InputStream input4 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input4);
		String password2 =prop.getProperty("studentapproverpassword2");
		
		Thread.sleep(2000);
		
		driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/login");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(admin2);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password2);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();


		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"remove-scroll\"]/ul/li[2]/a/span[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"remove-scroll\"]/ul/li[2]/ul/li[1]/a/span")).click();
		driver.findElement(By.id("routeId")).click();
		new Select(driver.findElement(By.id("routeId"))).selectByVisibleText("Student Application");
		driver.findElement(By.id("routeId")).click();
		driver.findElement(By.id("statusId")).click();
		new Select(driver.findElement(By.id("statusId"))).selectByVisibleText("Processing");
		driver.findElement(By.id("statusId")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Student Application List'])[2]/following::button[1]")).click();

		List <WebElement> actionbutton2 = driver.findElements(By.xpath("//tr//td[6]//div[1]//button[1]"));
		int actionlist2= actionbutton2.size();
		actionbutton2.get(actionlist2-1).click();
		//driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+email+"'])[1]/following::button[1]")).click();
		driver.findElement(By.linkText("Process")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rejected'])[1]/following::label[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("CommentForApplicant")).click();
		driver.findElement(By.id("CommentForApplicant")).clear();
		driver.findElement(By.id("CommentForApplicant")).sendKeys("test");
		driver.findElement(By.id("CommentForInternal")).click();
		driver.findElement(By.id("CommentForInternal")).clear();
		driver.findElement(By.id("CommentForInternal")).sendKeys("yes");
		driver.findElement(By.id("submit-action")).click();

		Thread.sleep(18000);

		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CIPM'])[1]/following::span[1]")).click();
		driver.findElement(By.linkText("Log Out")).click();
		
		//AcceptanceFee.testAcceptanceFee();
		//activeDiet.testActiveDietFoundation1();

		
	}

	 @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    
	    }
	  

}

