package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

	WebDriver conductor= null;
	String projectpath= System.getProperty("user.dir");

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		
		System.out.println("The name of the BROSWER is :" + browserName);
		System.out.println("thread number is :" + Thread.currentThread().getId() );

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
			conductor= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",projectpath + "\\driver\\geckodriver\\geckodriver.exe");
			conductor= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",projectpath + "driver\\iedriver\\IEDriverServer.exe");
			conductor= new InternetExplorerDriver();
		}


	}

	@Test
	public void test1() throws Exception {

		conductor.get("https://google.com");
			Thread.sleep(4000);

	}

	@AfterTest
	public void three() {
		conductor.close();
		System.out.println("test completed");
	}

}
