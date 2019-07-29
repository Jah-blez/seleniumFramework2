package demo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) throws Exception {
		test();
	}
	public static void test() throws Exception {

		String projectpath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");

		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linktext= driver.findElement(By.linkText("Learning Colors, Alphabet and Numbers with Chicks and ABCD ..."));

				return linktext;
			}
		});

		element.click();

		driver.close();
		driver.quit();
	}
}
