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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class executiveApproval {
	private static WebDriver driver;
	  
	  public static Properties prop= new Properties();
		static String projectpath= System.getProperty("user.dir");
	  

	  @Test
	  public static void testExecutiveApproval() throws Exception {
		  InputStream input = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
			prop.load(input);
			String admin =prop.getProperty("executiveapproveradmin1");
			
			InputStream input2 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
			prop.load(input2);
			String password =prop.getProperty("executiveapproverpassword1");
			 InputStream input5 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
				prop.load(input5);
				String admin2 =prop.getProperty("adminlogin1");
				
				InputStream input6 = new FileInputStream(projectpath +"/src/test/java/CIPM/datafile");
				prop.load(input6);
				String password2 =prop.getProperty("password1");
				
				InputStream input3 = new FileInputStream(projectpath +"/src/test/java/CIPM/loginfile");
				prop.load(input3);
				String useremail =prop.getProperty("username");

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
			
	    driver.findElement(By.xpath("//a[@class='nav-link nav-toggle']")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Executive Application Processing')]")).click();
	    driver.findElement(By.id("statusId")).click();
	    new Select(driver.findElement(By.id("statusId"))).selectByVisibleText("Pending");
	    driver.findElement(By.id("statusId")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//button[@class='btn-primary btn-lg btn-block']")).click();
	    List <WebElement> actionbutton = driver.findElements(By.xpath("//tr//td[6]//div[1]//button[1]"));
	   	int actionlist= actionbutton.size();
	   	actionbutton.get(actionlist-1).click();
	   
	    driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-left show']//a[contains(text(),'Process')]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Actions'])[1]/following::label[1]")).click();
	    
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_0__CriteriaSuppliedByApplicant")).click();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_0__CriteriaSuppliedByApplicant")).clear();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_0__CriteriaSuppliedByApplicant")).sendKeys("yes");
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_0__Score")).click();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_0__Score")).clear();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_0__Score")).sendKeys("12");
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_1__CriteriaSuppliedByApplicant")).click();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_1__CriteriaSuppliedByApplicant")).clear();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_1__CriteriaSuppliedByApplicant")).sendKeys("yes 2");
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_1__Score")).click();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_1__Score")).clear();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_1__Score")).sendKeys("17");
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_2__CriteriaSuppliedByApplicant")).click();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_2__CriteriaSuppliedByApplicant")).clear();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_2__CriteriaSuppliedByApplicant")).sendKeys("yes 3");
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_2__Score")).click();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_2__Score")).clear();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_2__Score")).sendKeys("37");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='HR WORK EXPERIENCE'])[1]/following::td[2]")).click();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_3__CriteriaSuppliedByApplicant")).click();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_3__CriteriaSuppliedByApplicant")).clear();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_3__CriteriaSuppliedByApplicant")).sendKeys("yes 4");
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_3__Score")).click();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_3__Score")).clear();
	    driver.findElement(By.id("FltApplicantCriteriaPointLists_3__Score")).sendKeys("10");
	    driver.findElement(By.id("MembershipLevelID")).click();
	    new Select(driver.findElement(By.id("MembershipLevelID"))).selectByVisibleText("AFFILIATE");
	    driver.findElement(By.id("MembershipLevelID")).click();
	    driver.findElement(By.id("CommentForApplicant")).click();
	    driver.findElement(By.id("CommentForApplicant")).clear();
	    driver.findElement(By.id("CommentForApplicant")).sendKeys("okay");
	    driver.findElement(By.id("CommentForInternal")).click();
	    driver.findElement(By.id("CommentForInternal")).clear();
	    driver.findElement(By.id("CommentForInternal")).sendKeys("okay");
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("submit-action")).click();
	    
	    Thread.sleep(8000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CIPM'])[1]/following::span[1]")).click();
	    driver.findElement(By.linkText("Log Out")).click();
	    
	   Thread.sleep(3000);
	   
		driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/login");
		Thread.sleep(3000);
		
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(admin2);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password2);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
		 Thread.sleep(2000);
	   
		 driver.findElement(By.xpath("//a[@class='nav-link nav-toggle']//span[@class='title'][contains(text(),'Application Processing')]")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//span[contains(text(),'Executive Application Processing')]")).click();
	    
		 Thread.sleep(2000);
		 driver.findElement(By.id("statusId")).click();
	    new Select(driver.findElement(By.id("statusId"))).selectByVisibleText("Processing");
	    driver.findElement(By.id("statusId")).click();
	    driver.findElement(By.xpath("//button[@class='btn-primary btn-lg btn-block']")).click();
	    
	    List <WebElement> actionbutton2 = driver.findElements(By.xpath("//tr//td[6]//div[1]//button[1]"));
	   	int actionlist2= actionbutton2.size();
	   	actionbutton2.get(actionlist2 -1).click();
	   
	    driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-left show']//a[contains(text(),'Process')]")).click();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rejected'])[1]/following::label[1]")).click();
	    driver.findElement(By.id("CommentForApplicant")).click();
	    driver.findElement(By.id("CommentForApplicant")).clear();
	    driver.findElement(By.id("CommentForApplicant")).sendKeys("okay");
	    driver.findElement(By.id("CommentForInternal")).click();
	    driver.findElement(By.id("CommentForInternal")).clear();
	    driver.findElement(By.id("CommentForInternal")).sendKeys("okay");
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("submit-action")).click();
	    
	    Thread.sleep(18000);
	   
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CIPM'])[1]/following::span[1]")).click();
	    driver.findElement(By.linkText("Log Out")).click();
	    
	    driver.quit();
	  }

	 
	  
	}
