package CIPM;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;




	public class PractitionerApplication {
		public Properties prop= new Properties();
		String projectpath= System.getProperty("user.dir");
		private WebDriver driver;

		

		@Test
		public void testPractitionerApplication() throws Exception {
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
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"pricing\"]/div/div[2]/div/div[3]/div/div[2]/a")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("paymentbtn")).click();
			
			Thread.sleep(5000);
			
			
			driver.findElement(By.id("PhotoPath")).sendKeys(imagepath);
			driver.findElement(By.id("TitleID")).click();
			new Select(driver.findElement(By.id("TitleID"))).selectByVisibleText("Dr");
			driver.findElement(By.id("TitleID")).click();
			driver.findElement(By.id("DateOfBirth")).sendKeys("2005-04-16");
			
			driver.findElement(By.id("MobileNo")).click();
			driver.findElement(By.id("MobileNo")).clear();
			driver.findElement(By.id("MobileNo")).sendKeys("09088989087");
			driver.findElement(By.id("Sex")).click();
			new Select(driver.findElement(By.id("Sex"))).selectByVisibleText("Male");
			driver.findElement(By.id("Sex")).click();
			driver.findElement(By.id("MaritalStatusID")).click();
			new Select(driver.findElement(By.id("MaritalStatusID"))).selectByVisibleText("Divorced");
			driver.findElement(By.id("MaritalStatusID")).click();
			driver.findElement(By.id("StateOfOriginID")).click();
			new Select(driver.findElement(By.id("StateOfOriginID"))).selectByVisibleText("GOMBE");
			
			driver.findElement(By.id("LgaID")).sendKeys("NAFADA");
			
			driver.findElement(By.name("StateOfRegistrationID")).click();
			new Select(driver.findElement(By.name("StateOfRegistrationID"))).selectByVisibleText("ENUGU");
			driver.findElement(By.name("StateOfRegistrationID")).click();
			driver.findElement(By.id("ResidentialPhoneNo")).click();
			driver.findElement(By.id("ResidentialPhoneNo")).clear();
			driver.findElement(By.id("ResidentialPhoneNo")).sendKeys("95959560606");
			driver.findElement(By.id("ContactAddress")).click();
			driver.findElement(By.id("ContactAddress")).clear();
			driver.findElement(By.id("ContactAddress")).sendKeys("34, Boladale Street");
			driver.findElement(By.id("EmployerAddress")).clear();
			driver.findElement(By.id("EmployerAddress")).sendKeys("34, Boladale Street");
			driver.findElement(By.id("NKFullName")).clear();
			driver.findElement(By.id("NKFullName")).sendKeys("Godbless Chinemerem Onyebuchi");
			
			driver.findElement(By.id("ResidentialAddress")).sendKeys("nfkfkfkj;nf n'bfm gbm 'bngjbnmb nl' fgnfgmmk");
			
			driver.findElement(By.id("PresentEmployer")).click();
			driver.findElement(By.id("PresentEmployer")).clear();
			driver.findElement(By.id("PresentEmployer")).sendKeys("ok");
			driver.findElement(By.id("NoOfTotalEmployee")).click();
			driver.findElement(By.id("NoOfTotalEmployee")).clear();
			driver.findElement(By.id("NoOfTotalEmployee")).sendKeys("7799");
			driver.findElement(By.id("NatureOfBusiness")).click();
			driver.findElement(By.id("NatureOfBusiness")).clear();
			driver.findElement(By.id("NatureOfBusiness")).sendKeys("hjkglhgbp;bghuo");
			driver.findElement(By.id("SectorID")).click();
			new Select(driver.findElement(By.id("SectorID"))).selectByVisibleText("Others");
			driver.findElement(By.id("SectorID")).click();
			driver.findElement(By.id("PresentEmploymentTitle")).click();
			driver.findElement(By.id("PresentEmploymentTitle")).clear();
			driver.findElement(By.id("PresentEmploymentTitle")).sendKeys("change");
			driver.findElement(By.id("EmployerLastYearTurnOver")).click();
			driver.findElement(By.id("EmployerLastYearTurnOver")).clear();
			driver.findElement(By.id("EmployerLastYearTurnOver")).sendKeys("232009");
			driver.findElement(By.id("CurrentGradeLevel")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Appointment'])[1]/following::span[4]")).click();
			driver.findElement(By.id("CurrentGradeLevel")).clear();
			driver.findElement(By.id("CurrentGradeLevel")).sendKeys("7");
			
			
			String[] monthName = {"January", "February",
		            "March", "April", "May", "June", "July",
		            "August", "September", "October", "November",
		            "December"};
			
			Calendar cal = Calendar.getInstance();
		    String month = monthName[cal.get(Calendar.MONTH)];
		    
		int year= cal.get(Calendar.YEAR);
		int year22= year-30;

		    String newyear =Integer.toString(year);
		    String newyear2 =Integer.toString(year22);
		    
			Thread.sleep(2000);
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Appointment'])[1]/following::span[4]")).click();
		    
		    Thread.sleep(2000);
		    driver.findElement(By.linkText(month+" "+cal.get(Calendar.YEAR))).click();
		    Thread.sleep(2000);
		    
		    driver.findElement(By.linkText(newyear)).click();
		    Thread.sleep(2000);
		    
		    driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-left']")).click();
		    Thread.sleep(2000);
		    
		    driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-left']")).click();
		    Thread.sleep(2000);
		    
		    driver.findElement(By.linkText(newyear2)).click();
		    
		    Thread.sleep(2000);
		    driver.findElement(By.linkText("Feb")).click();
		    
		    Thread.sleep(2000);
		    driver.findElement(By.linkText("17")).click();
			
			driver.findElement(By.id("NoOfSeniorEmployee")).sendKeys("45");
			driver.findElement(By.id("PresentDutiesScope")).click();
			driver.findElement(By.id("PresentDutiesScope")).clear();
			driver.findElement(By.id("PresentDutiesScope")).sendKeys("dcjvbhjdjbhdjhdlkj cb jd hudkj jdckj gdvkjdvkj dvkjdckj");
			driver.findElement(By.id("NoOfJuniorEmployee")).click();
			driver.findElement(By.id("NoOfJuniorEmployee")).clear();
			driver.findElement(By.id("NoOfJuniorEmployee")).sendKeys("7754");
			driver.findElement(By.id("NKRelationship")).click();
			driver.findElement(By.id("NKRelationship")).clear();
			driver.findElement(By.id("NKRelationship")).sendKeys("word");
			driver.findElement(By.id("NKFullName")).click();
			driver.findElement(By.id("NKEmail")).click();
			driver.findElement(By.id("NKEmail")).clear();
			driver.findElement(By.id("NKEmail")).sendKeys("gzyblizy@gmail.com");
			driver.findElement(By.id("NKPhoneNo")).click();
			driver.findElement(By.id("NKPhoneNo")).clear();
			driver.findElement(By.id("NKPhoneNo")).sendKeys("09087654321");
			driver.findElement(By.id("NKAddress")).click();
			driver.findElement(By.id("NKAddress")).clear();
			driver.findElement(By.id("NKAddress")).sendKeys("34, Boladale Street");
			
			for (int i=0; i<2; i++) {
			
			driver.findElement(By.id("addReferee")).click();
			
			Thread.sleep(7000);
			if (i==0) {
		
			driver.findElement(By.id("FullName")).sendKeys("macarena");
			driver.findElement(By.id("Organization")).sendKeys("movement");
			driver.findElement(By.id("Designation")).sendKeys("deploy");
			}
			else {
				driver.findElement(By.id("FullName")).sendKeys("alangba");
				driver.findElement(By.id("Organization")).sendKeys("zanku");
				driver.findElement(By.id("Designation")).sendKeys("izuogu");
			}
			
			
			driver.findElement(By.id("BusinessAddress")).clear();
			driver.findElement(By.id("BusinessAddress")).sendKeys("jkfkfkq"+ i);
			driver.findElement(By.id("RefereeEmail")).clear();
			driver.findElement(By.id("RefereeEmail")).sendKeys("fjkbkjn@sdjhb.djhek"+i);
			driver.findElement(By.id("PhoneNo")).click();
			driver.findElement(By.id("PhoneNo")).clear();
			driver.findElement(By.id("PhoneNo")).sendKeys("0098980779"+i);
			driver.findElement(By.id("add")).click();
			
			Thread.sleep(3000);
			}
			driver.findElement(By.id("addEducation")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Education'])[1]/following::div[6]")).click();
			new Select(driver.findElement(By.id("InstitutionID"))).selectByVisibleText("Afe Babalola University, Ado-Ekiti - Ekiti State");
			driver.findElement(By.id("InstitutionID")).click();
			driver.findElement(By.id("CourseOfStudyID")).click();
			new Select(driver.findElement(By.id("CourseOfStudyID"))).selectByVisibleText("Soil Science");
			driver.findElement(By.id("CourseOfStudyID")).click();
			driver.findElement(By.id("DegreeID")).click();
			new Select(driver.findElement(By.id("DegreeID"))).selectByVisibleText("M.SC");
			driver.findElement(By.id("DegreeID")).click();
			driver.findElement(By.id("YearAcquired")).click();
			new Select(driver.findElement(By.id("YearAcquired"))).selectByVisibleText("1978");
			driver.findElement(By.id("YearAcquired")).click();
			driver.findElement(By.id("add")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("addJob")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("EmployerName")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Start Date'])[1]/following::span[3]")).click();
			driver.findElement(By.id("EmployerName")).clear();
			driver.findElement(By.id("EmployerName")).sendKeys("jhgjhgjhg");
			
			driver.findElement(By.id("StartDate")).sendKeys("2012-01-03");
			Thread.sleep(3000);
			driver.findElement(By.id("IsCurrent")).click();
			driver.findElement(By.id("add")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("addProfessionalBody")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.id("ProfessionalBody")).click();
			driver.findElement(By.id("ProfessionalBody")).clear();
			driver.findElement(By.id("ProfessionalBody")).sendKeys("love");
			driver.findElement(By.id("MemberShipGrade")).click();
			driver.findElement(By.id("MemberShipGrade")).clear();
			driver.findElement(By.id("MemberShipGrade")).sendKeys("748");
			
			
			driver.findElement(By.id("FileValue")).sendKeys(imagepath);
			
			WebElement  electionfield= driver.findElement(By.id("ElectionDate"));
			electionfield.sendKeys("2017-01-01");
			
			//driver.findElement(By.id("ElectionDate")).sendKeys(dtf.format(newdate.getTime()));
			
			driver.findElement(By.id("add")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("addCoreHrExperience")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("Activity")).click();
			driver.findElement(By.id("Activity")).clear();
			driver.findElement(By.id("Activity")).sendKeys("silent");
			driver.findElement(By.id("Period")).click();
			driver.findElement(By.id("Period")).clear();
			driver.findElement(By.id("Period")).sendKeys("ejhfjdj");
			driver.findElement(By.id("add")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("addCoreHrExperience")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("Activity")).click();
			driver.findElement(By.id("Activity")).clear();
			driver.findElement(By.id("Activity")).sendKeys("mnes");
			driver.findElement(By.id("Period")).click();
			driver.findElement(By.id("Period")).clear();
			driver.findElement(By.id("Period")).sendKeys("djhdbjudv");
			driver.findElement(By.id("add")).click();
			Thread.sleep(3000);
			
			for(int i=0; i<5;i++) {
			
			driver.findElement(By.id("addHumanResource")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("TrainingTitle")).click();
			driver.findElement(By.id("TrainingTitle")).clear();
			driver.findElement(By.id("TrainingTitle")).sendKeys("Software Tester "+ i);
			driver.findElement(By.id("Training")).click();
			driver.findElement(By.id("Training")).clear();
			driver.findElement(By.id("Training")).sendKeys("coming "+ i);
		
			driver.findElement(By.id("FileValue")).sendKeys(imagepath);
			driver.findElement(By.id("TrainingDate")).sendKeys("2009-04-16");
			
			Thread.sleep(3000);
			driver.findElement(By.id("add")).click();
			
			Thread.sleep(3000);
			}
		
			for(int i=0; i<3;i++) {
			
			
			driver.findElement(By.id("RouteDocuments_"+i+"__UploadFile")).sendKeys(filepath);
			
			}
			
			Thread.sleep(3000);
			
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Continue to Payment")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Payment Options'])[1]/following::input[3]")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("paymentbtn")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='btn btn-circle btn-success']")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='editable']")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Close")).click();
			
			driver.quit();
			
			practitionerApproval.testPractionerApproval();
			AcceptanceFee.testAcceptanceFee();
			
		}

		
	

}
	

