package listeners;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenersDemo2 {

	@Test
	public void test4() {
		System.out.println("I am inside Test 4");
	}

	@Test
	public void test5() {
		System.out.println("I am inside Test 5");

		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);

		System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		WebDriver conductor= new ChromeDriver();
		conductor.get("http://facebook.com");

		conductor.findElement(By.id("email")).sendKeys("gzyblizy@yahoo.ca");
		conductor.findElement(By.id("eail")).sendKeys("gzyblizy@yahoo.ca");
	}

	@Test
	public void test6() {
		System.out.println("I am inside Test 6");
		throw new SkipException("This test is skipped");
	}

}

