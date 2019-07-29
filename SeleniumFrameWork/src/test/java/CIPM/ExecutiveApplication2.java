package CIPM;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class ExecutiveApplication2 {

  private static WebDriver driver;
  
  public static Properties prop= new Properties();
	static String projectpath= System.getProperty("user.dir");
	

  @Test
  public static void testExecutiveApplication() throws Exception {
	  InputStream input = new FileInputStream(projectpath +"/src/test/java/CIPM/loginfile");
		prop.load(input);
		String username =prop.getProperty("username");
		
		InputStream input2 = new FileInputStream(projectpath +"/src/test/java/CIPM/loginfile");
		prop.load(input2);
		String password =prop.getProperty("password");
		

		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		
		InputStream input3 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input3);
		String filepath =prop.getProperty("filepath");


		InputStream input4 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
		prop.load(input4);
		String imagepath =prop.getProperty("imagepath");

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
		
		driver.findElement(By.xpath("//*[@id=\"pricing\"]/div/div[2]/div/div[1]/div/div[2]/a")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("paymentbtn")).click();
		
		Thread.sleep(2000);
		

		driver.findElement(By.id("PhotoPath")).sendKeys(imagepath);
    driver.findElement(By.id("Title")).click();
    new Select(driver.findElement(By.id("Title"))).selectByVisibleText("Miss");
    driver.findElement(By.id("Title")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::span[3]")).click();
    
    String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};
	
	Calendar cal = Calendar.getInstance();
    String month = monthName[cal.get(Calendar.MONTH)];
int year= cal.get(Calendar.YEAR);
int year22= year-30;

int year44= year-10;
    String newyear =Integer.toString(year);
    String newyear2 =Integer.toString(year22);
    
    String newyear4 =Integer.toString(year44);
    
    driver.findElement(By.linkText(month+" 2009")).click();
    driver.findElement(By.linkText("2009")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Admin Login'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Admin Login'])[1]/following::span[1]")).click();
    driver.findElement(By.linkText("1979")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.linkText("Feb")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.linkText("14")).click();
    driver.findElement(By.id("MobileNo")).click();
    driver.findElement(By.id("MobileNo")).clear();
    driver.findElement(By.id("MobileNo")).sendKeys("898809030983");
    driver.findElement(By.id("Sex")).click();
    new Select(driver.findElement(By.id("Sex"))).selectByVisibleText("Female");
    driver.findElement(By.id("Sex")).click();
    driver.findElement(By.id("MaritalStatusID")).click();
    new Select(driver.findElement(By.id("MaritalStatusID"))).selectByVisibleText("Widow");
    driver.findElement(By.id("MaritalStatusID")).click();
    driver.findElement(By.id("StateOfOriginID")).click();
    new Select(driver.findElement(By.id("StateOfOriginID"))).selectByVisibleText("JIGAWA");
    driver.findElement(By.id("StateOfOriginID")).click();
    driver.findElement(By.id("LgaID")).click();
    driver.findElement(By.id("LgaID")).sendKeys("KAZUARE");
    driver.findElement(By.id("LgaID")).click();
    driver.findElement(By.id("ZoneID")).click();
    new Select(driver.findElement(By.id("ZoneID"))).selectByVisibleText("NORTH CENTRAL");
    driver.findElement(By.id("ZoneID")).click();
    driver.findElement(By.id("BranchID")).click();
    new Select(driver.findElement(By.id("BranchID"))).selectByVisibleText("Benue");
    driver.findElement(By.id("BranchID")).click();
    driver.findElement(By.name("StateOfRegistrationID")).click();
    new Select(driver.findElement(By.name("StateOfRegistrationID"))).selectByVisibleText("JIGAWA");
    driver.findElement(By.name("StateOfRegistrationID")).click();
    driver.findElement(By.id("ResidentialPhoneNo")).click();
    driver.findElement(By.id("ResidentialPhoneNo")).clear();
    driver.findElement(By.id("ResidentialPhoneNo")).sendKeys("0988788888");
    driver.findElement(By.id("ContactAddress")).click();
    driver.findElement(By.id("ContactAddress")).clear();
    driver.findElement(By.id("ContactAddress")).sendKeys("738yhfh bf bffgfb lvbkjblhvflhbfbfhgf");
    driver.findElement(By.id("ResidentialAddress")).click();
    driver.findElement(By.id("ResidentialAddress")).clear();
    driver.findElement(By.id("ResidentialAddress")).sendKeys("fjfhibpfhhfgpygryfogb h gr ryrgrpbgfrbi");
    driver.findElement(By.id("PresentEmployer")).click();
    driver.findElement(By.id("PresentEmployer")).clear();
    driver.findElement(By.id("PresentEmployer")).sendKeys("dhfuhdiu");
    driver.findElement(By.id("LineManagerDesignation")).clear();
    driver.findElement(By.id("LineManagerDesignation")).sendKeys("duyug");
    driver.findElement(By.id("EmployerAddress")).clear();
    driver.findElement(By.id("EmployerAddress")).sendKeys("udgd");
    driver.findElement(By.id("NatureOfBusiness")).clear();
    driver.findElement(By.id("NatureOfBusiness")).sendKeys("uigui");
    driver.findElement(By.id("SectorID")).click();
    new Select(driver.findElement(By.id("SectorID"))).selectByVisibleText("Enforcer leave");
    driver.findElement(By.id("SectorID")).click();
   // driver.findElement(By.id("OtherBusinessCategory")).click();
   // driver.findElement(By.id("OtherBusinessCategory")).clear();
   // driver.findElement(By.id("OtherBusinessCategory")).sendKeys("jurhuiroie");
    driver.findElement(By.id("PresentEmploymentTitle")).click();
    driver.findElement(By.id("PresentEmploymentTitle")).clear();
    driver.findElement(By.id("PresentEmploymentTitle")).sendKeys("ruyrieie");
    driver.findElement(By.id("CurrentGradeLevel")).click();
    driver.findElement(By.id("CurrentGradeLevel")).clear();
    driver.findElement(By.id("CurrentGradeLevel")).sendKeys("eiur8iryiyeyeieyityiegiegie");
    driver.findElement(By.id("EmployerLastYearTurnOver")).click();
    
    driver.findElement(By.id("EmployerLastYearTurnOver")).clear();
    driver.findElement(By.id("EmployerLastYearTurnOver")).sendKeys("737993");
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Appointment'])[1]/following::span[4]")).click();
   // driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Appointment'])[1]/following::span[4]")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText(month+" "+cal.get(Calendar.YEAR))).click();
    Thread.sleep(2000);
    
    driver.findElement(By.linkText(newyear)).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[1]/following::span[1]")).click();
    driver.findElement(By.linkText(newyear2)).click();
    
    Thread.sleep(2000);
    driver.findElement(By.linkText("Feb")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[2]/following::a[17]")).click();
    driver.findElement(By.id("NoofPermanentEmployees")).click();
    driver.findElement(By.id("NoofPermanentEmployees")).clear();
    driver.findElement(By.id("NoofPermanentEmployees")).sendKeys("739839");
    driver.findElement(By.id("PresentDutiesScope")).click();
    driver.findElement(By.id("PresentDutiesScope")).clear();
    driver.findElement(By.id("PresentDutiesScope")).sendKeys("kggfoegeiep eie eue evgie egeigoegreu");
    driver.findElement(By.id("NoofContractEmployees")).click();
    driver.findElement(By.id("NoofContractEmployees")).clear();
    driver.findElement(By.id("NoofContractEmployees")).sendKeys("8779");
    driver.findElement(By.id("NKFullName")).click();
    driver.findElement(By.id("NKFullName")).clear();
    driver.findElement(By.id("NKFullName")).sendKeys("dhgjwikwuwuweu");
    driver.findElement(By.id("NKRelationship")).click();
    driver.findElement(By.id("NKRelationship")).clear();
    driver.findElement(By.id("NKRelationship")).sendKeys("btother");
    driver.findElement(By.id("NKEmail")).click();
    driver.findElement(By.id("NKEmail")).clear();
    driver.findElement(By.id("NKEmail")).sendKeys("iyo@hd.djd");
    driver.findElement(By.id("NKPhoneNo")).click();
    driver.findElement(By.id("NKPhoneNo")).clear();
    driver.findElement(By.id("NKPhoneNo")).sendKeys("0877272722");
    driver.findElement(By.id("NKAddress")).click();
    driver.findElement(By.id("NKAddress")).clear();
    driver.findElement(By.id("NKAddress")).sendKeys("jhdjhdfhjfdl rd golrrgpbgfe woeororf");
    Thread.sleep(2000);
    driver.findElement(By.id("addEducation")).click();
    Thread.sleep(4000);
    
    driver.findElement(By.id("InstitutionID")).click();
    new Select(driver.findElement(By.id("InstitutionID"))).selectByVisibleText("African University of Science & Technology, Abuja");
    driver.findElement(By.id("InstitutionID")).click();
    driver.findElement(By.id("CourseOfStudyID")).click();
    new Select(driver.findElement(By.id("CourseOfStudyID"))).selectByVisibleText("Food Science and Technology");
    driver.findElement(By.id("CourseOfStudyID")).click();
    driver.findElement(By.id("DegreeID")).click();
    new Select(driver.findElement(By.id("DegreeID"))).selectByVisibleText("B.Sc");
    driver.findElement(By.id("DegreeID")).click();
    driver.findElement(By.id("YearAcquired")).click();
    new Select(driver.findElement(By.id("YearAcquired"))).selectByVisibleText("1976");
    driver.findElement(By.id("YearAcquired")).click();
    driver.findElement(By.id("add")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.id("addJob")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.id("EmployerName")).click();
   
    driver.findElement(By.id("EmployerName")).clear();
    driver.findElement(By.id("EmployerName")).sendKeys("jhfejhrfejhfduhfiurekfuye");
    
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Start Date'])[1]/following::span[4]")).click();
    driver.findElement(By.linkText("April 2019")).click();
    driver.findElement(By.linkText("2019")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[2]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[2]/following::span[1]")).click();
    driver.findElement(By.linkText("1989")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.linkText("Feb")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[3]/following::a[17]")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.id("IsCurrent")).click();
    driver.findElement(By.id("add")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.id("addProfessionalBody")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.id("ProfessionalBody")).click();
    driver.findElement(By.id("ProfessionalBody")).clear();
    driver.findElement(By.id("ProfessionalBody")).sendKeys("ijele");
    driver.findElement(By.id("MemberShipGrade")).click();
    driver.findElement(By.id("MemberShipGrade")).clear();
    driver.findElement(By.id("MemberShipGrade")).sendKeys("hyeuiwiw");
    
    
    driver.findElement(By.id("FileValue")).sendKeys(imagepath);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Admission Date'])[1]/following::span[4]")).click();
    driver.findElement(By.linkText(month+" "+cal.get(Calendar.YEAR))).click();
    driver.findElement(By.linkText(newyear)).click();
    driver.findElement(By.linkText(newyear4)).click();
    
    Thread.sleep(2000);
    driver.findElement(By.linkText("Feb")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[4]/following::a[14]")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.id("add")).click();
    
    Thread.sleep(2000);
    for (int i=0; i<3;i++) {
    
    driver.findElement(By.id("addCoreHrExperience")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.id("Activity")).click();
    driver.findElement(By.id("Activity")).clear();
    driver.findElement(By.id("Activity")).sendKeys("gdkjgeu"+i);
    driver.findElement(By.id("Period")).click();
    driver.findElement(By.id("Period")).clear();
    driver.findElement(By.id("Period")).sendKeys("jdhee"+i);
    
    driver.findElement(By.id("add")).click();
    Thread.sleep(2000);
    }
    
    for (int i=0; i<5;i++) {
    driver.findElement(By.id("addHumanResource")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.id("TrainingTitle")).click();
    driver.findElement(By.id("TrainingTitle")).clear();
    driver.findElement(By.id("TrainingTitle")).sendKeys("ehjgdvj"+i);
    driver.findElement(By.id("Training")).clear();
    driver.findElement(By.id("Training")).sendKeys("jdbjubhd"+i);
    
    int year33= year-(5-i);
    String newyear3 =Integer.toString(year33);
    driver.findElement(By.id("FileValue")).sendKeys(imagepath);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Training Date'])[1]/following::span[3]")).click();
    driver.findElement(By.linkText(month+" "+cal.get(Calendar.YEAR))).click();
    driver.findElement(By.linkText(newyear)).click();
    driver.findElement(By.linkText(newyear3)).click();
    Thread.sleep(2000);
    
    driver.findElement(By.linkText("Jun")).click();
    Thread.sleep(4000);
    
    driver.findElement(By.linkText("24")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.id("add")).click();
    Thread.sleep(2000);
    }
    
    Thread.sleep(2000);
    
    for (int i=0; i<3;i++) {
    driver.findElement(By.id("addStrategicProject")).click();
    
    Thread.sleep(2000);
    
    driver.findElement(By.id("StrategicProject")).click();
    driver.findElement(By.id("StrategicProject")).clear();
    driver.findElement(By.id("StrategicProject")).sendKeys("Intetest"+i);
    driver.findElement(By.id("add")).click();
    Thread.sleep(2000);
    
    }
    for (int i=0; i<3;i++) {
 
    driver.findElement(By.id("RouteDocuments_"+i+"__UploadFile")).sendKeys(filepath);
    Thread.sleep(2000);
    }
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
	executiveApproval.testExecutiveApproval();
	AcceptanceFee.testAcceptanceFee();
  }

 

 
  }

