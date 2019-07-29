package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasicDemo {
	
	private static WebDriver conductor = null;

	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreport.html");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test = extent.createTest("Google search", "to validate functionality");
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);
		
		System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		conductor = new ChromeDriver();
		conductor.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test.log(Status.INFO, "starting test case");
		
		conductor.get("https://google.com");
		test.pass("Navigate to google");
		
		conductor.findElement(By.name("q")).sendKeys("Automated testing");;
		test.pass("enter text");
		
		conductor.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).sendKeys(Keys.RETURN);
		test.pass("click button");
		
		conductor.close();
		conductor.quit();
		
		extent.flush();
	
		
	}
}
