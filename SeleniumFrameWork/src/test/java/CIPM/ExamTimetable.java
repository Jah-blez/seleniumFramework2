package CIPM;


import java.util.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ExamTimetable {
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
	public void testExamTimetable() throws Exception {
		setUp();
		
		driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/login");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("oteebest@yahoo.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("pass");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cooperate Application Processing'])[1]/following::a[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change Student Examination Category'])[1]/following::span[1]")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();

		DecimalFormat df = new DecimalFormat("###.##");

		String name= "AutomatedExam" ;

		name = name + df.format(Math.random()*304+1);

		driver.findElement(By.id("Name")).click();
		driver.findElement(By.id("Name")).clear();


		driver.findElement(By.id("Name")).sendKeys(name);
		String codename= "AEX" ;
		codename = codename + df.format(Math.random()*304 +1);
		driver.findElement(By.id("Prefix")).click();
		driver.findElement(By.id("Prefix")).clear();
		driver.findElement(By.id("Prefix")).sendKeys(codename);
		driver.findElement(By.id("DietID")).click();
		new Select(driver.findElement(By.id("DietID"))).selectByVisibleText("FEBRUARY");
		driver.findElement(By.id("DietID")).click();
		driver.findElement(By.id("Year")).sendKeys("2019");

		DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();

		Calendar enddate = Calendar.getInstance();    
		enddate.add(Calendar.DATE, 30);
		Calendar lateregstartdate = Calendar.getInstance();
		lateregstartdate.add(Calendar.DATE, 60);
		Calendar lateregenddate = Calendar.getInstance();
		lateregenddate.add(Calendar.DATE, 90);


		driver.findElement(By.xpath("//input[@id='StartDate']")).clear();
		driver.findElement(By.xpath("//input[@id='StartDate']")).sendKeys(dtf.format(now));

		driver.findElement(By.xpath("//input[@id='EndDate']")).clear();
		driver.findElement(By.xpath("//input[@id='EndDate']")).sendKeys(dtf.format(enddate.getTime()));

		driver.findElement(By.xpath("//input[@id='LateRegStartDate']")).clear();
		driver.findElement(By.xpath("//input[@id='LateRegStartDate']")).sendKeys(dtf.format(lateregstartdate.getTime()));

		driver.findElement(By.xpath("//input[@id='LateRegEndDate']")).clear();
		driver.findElement(By.xpath("//input[@id='LateRegEndDate']")).sendKeys(dtf.format(lateregenddate.getTime()));

		driver.findElement(By.id("LateRegFee")).click();
		driver.findElement(By.id("LateRegFee")).clear();
		driver.findElement(By.id("LateRegFee")).sendKeys("2300");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LAGOS'])[1]/following::input[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ENUGU'])[1]/following::input[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ABUJA'])[1]/following::input[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KADUNA'])[1]/following::button[1]")).click();
		
		//asserting by getting last value of the list
		List <WebElement> examlist = driver.findElements(By.xpath("//*[@id=\"applicant-list\"]/tbody/tr/td[2]"));
		int examlist2 = examlist.size();
		String dietname = examlist.get(examlist2-1).getText();
		Assert.assertEquals(dietname,name);
		
		//importing level timetable created
		DietTimetable diet= new DietTimetable();
		diet.testDietTimetable();
		
		tearDown();

	}



	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}


}
