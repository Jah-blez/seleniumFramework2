package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoWithTestNG {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver conductor= null;
	
	
	@BeforeSuite
	public void SetUpTest() {
		
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	@BeforeTest
	public void BeforeTest() {
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);
		
		System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		conductor = new ChromeDriver();
		conductor.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws Exception {
		ExtentTest test = extent.createTest("Google search", "to validate functionality");
		
		conductor.get("https://google.com");
		test.pass("go to google");

		test.log(Status.INFO, "starting test case");
		test.info("starting test case");
		test.fail("starting test case");
		test.addScreenCaptureFromPath ("starting test case");
		
	}
	
	@AfterTest
	public void TearDown() {
		conductor.close();
		conductor.quit();
		System.out.println("Test Completed sucessfully");
	}
	
	@AfterSuite
	
	public void TearDownTest() {
		extent.flush();
	}
	
}
