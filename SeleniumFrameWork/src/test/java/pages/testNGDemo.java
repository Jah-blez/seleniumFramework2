package pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFIle;

public class testNGDemo {

	static WebDriver conductor = null;
	public static String browserName = null;

	@BeforeTest
	public void setUpTest () {
		String projectpath = System.getProperty("user.dir");
		PropertiesFIle.getproperties();
		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
			conductor = new ChromeDriver();
			conductor.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",projectpath + "\\driver\\geckodriver\\geckodriver.exe");
			conductor= new FirefoxDriver();
			conductor.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
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
		//conductor.quit();
		System.out.println("Test Completed sucessfully");
		PropertiesFIle.setproperties();


	}



}
