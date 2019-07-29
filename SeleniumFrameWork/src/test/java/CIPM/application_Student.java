package CIPM;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class application_Student {


	public static Properties prop= new Properties();
	static String projectpath= System.getProperty("user.dir");
	private WebDriver driver;




	@Test
	public void testMembershipReg() throws Exception {

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


		Thread.sleep(2000);

		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Student Application'])[1]/following::a[1]")).click();

		Thread.sleep(2000);


		driver.findElement(By.xpath("//button[@id='paymentbtn']")).click();

		Thread.sleep(2000);


		InputStream input3 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input3);
		String filepath =prop.getProperty("filepath");


		InputStream input4 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input4);
		String imagepath =prop.getProperty("imagepath");
		driver.findElement(By.xpath("//*[@id=\"PhotoPath\"]")).sendKeys(imagepath);
		driver.findElement(By.id("TitleID")).click();
		new Select(driver.findElement(By.id("TitleID"))).selectByVisibleText("Mr");


		driver.findElement(By.id("DateOfBirth")).sendKeys("2009-04-16");

		driver.findElement(By.id("MobileNo")).click();
		driver.findElement(By.id("MobileNo")).clear();
		driver.findElement(By.id("MobileNo")).sendKeys("78799838908");

		driver.findElement(By.id("Sex")).click();
		new Select(driver.findElement(By.id("Sex"))).selectByVisibleText("Male");

		driver.findElement(By.id("MaritalStatusID")).click();
		new Select(driver.findElement(By.id("MaritalStatusID"))).selectByVisibleText("Single");
		driver.findElement(By.id("MaritalStatusID")).click();

		driver.findElement(By.id("StateOfOriginID")).click();
		new Select(driver.findElement(By.id("StateOfOriginID"))).selectByVisibleText("EDO");

		driver.findElement(By.id("LgaID")).sendKeys("OREDO");	


		driver.findElement(By.id("ZoneID")).click();
		new Select(driver.findElement(By.id("ZoneID"))).selectByVisibleText("NORTH WEST");

		driver.findElement(By.id("BranchID")).click();
		new Select(driver.findElement(By.id("BranchID"))).selectByVisibleText("Kaduna");

		driver.findElement(By.name("StateOfRegistrationID")).click();
		new Select(driver.findElement(By.name("StateOfRegistrationID"))).selectByVisibleText("EBONYI");

		driver.findElement(By.id("ResidentialPhoneNo")).click();
		driver.findElement(By.id("ResidentialPhoneNo")).clear();
		driver.findElement(By.id("ResidentialPhoneNo")).sendKeys("09900999009");

		driver.findElement(By.id("ContactAddress")).click();
		driver.findElement(By.id("ContactAddress")).clear();
		driver.findElement(By.id("ContactAddress")).sendKeys("34, Boladale Street");

		driver.findElement(By.id("NKFullName")).clear();
		driver.findElement(By.id("NKFullName")).sendKeys("Jackie Appiah");

		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contact Address'])[1]/following::div[2]")).click();
		driver.findElement(By.id("ResidentialAddress")).click();
		driver.findElement(By.id("ResidentialAddress")).clear();
		driver.findElement(By.id("ResidentialAddress")).sendKeys("Nanna Estate");
		driver.findElement(By.id("NKRelationship")).click();
		driver.findElement(By.id("NKRelationship")).clear();
		driver.findElement(By.id("NKRelationship")).sendKeys("word");
		driver.findElement(By.id("NKEmail")).click();
		driver.findElement(By.id("NKEmail")).clear();
		driver.findElement(By.id("NKEmail")).sendKeys("gzyblizy@gmail.com");
		driver.findElement(By.id("NKAddress")).click();
		driver.findElement(By.id("NKAddress")).clear();
		driver.findElement(By.id("NKAddress")).sendKeys("34, Boladale Street");
		driver.findElement(By.id("NKPhoneNo")).click();
		driver.findElement(By.id("NKPhoneNo")).clear();
		driver.findElement(By.id("NKPhoneNo")).sendKeys("09087654321");

		driver.findElement(By.id("addEducation")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("InstitutionID")).click();
		new Select(driver.findElement(By.id("InstitutionID"))).selectByVisibleText("Gombe State University of Science and Technology");
		driver.findElement(By.id("InstitutionID")).click();

		driver.findElement(By.id("CourseOfStudyID")).click();
		new Select(driver.findElement(By.id("CourseOfStudyID"))).selectByVisibleText("Archeology and Tourism");
		driver.findElement(By.id("CourseOfStudyID")).click();
		driver.findElement(By.id("DegreeID")).click();
		new Select(driver.findElement(By.id("DegreeID"))).selectByVisibleText("M.SC");
		driver.findElement(By.id("DegreeID")).click();
		driver.findElement(By.id("YearAcquired")).click();
		new Select(driver.findElement(By.id("YearAcquired"))).selectByVisibleText("1974");
		driver.findElement(By.id("YearAcquired")).click();


		driver.findElement(By.id("add")).click();



		driver.findElement(By.id("RouteDocuments_0__UploadFile")).sendKeys(filepath);
		driver.findElement(By.id("RouteDocuments_1__UploadFile")).sendKeys(filepath);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Continue to Payment")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Payment Options'])[1]/following::input[3]")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("paymentbtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-circle btn-success']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='editable']")).click();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Close")).click();

		driver.quit();

		application_Student_Approval.testApprovingApplication();
		AcceptanceFee.testAcceptanceFee();
		activeDiet.testActiveDietFoundation1();
	}




}

