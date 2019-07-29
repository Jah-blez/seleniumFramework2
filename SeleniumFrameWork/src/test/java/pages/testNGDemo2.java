package pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGDemo2 {

	static WebDriver conductor = null;
	
	@BeforeTest
	public void setUpTest () {
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);
		
		System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		conductor = new ChromeDriver();
		conductor.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public static void searchTest() {
		
		
		conductor.get("https://google.com");
		
		searchObject Obj = new searchObject(conductor);
		
		Obj.setTextInBox("Automated testing");
		
		Obj.clickSearchBox();
		
	}
		@AfterTest
		public void tearDownTest() {
			
			conductor.close();
			conductor.quit();
			System.out.println("Test Completed sucessfully");
			
			
		}
		

	
}
