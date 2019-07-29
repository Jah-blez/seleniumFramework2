package pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);
		
		System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		WebDriver conductor= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver",projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		//WebDriver conductor= new FirefoxDriver();
		
		conductor.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//System.setProperty("webdriver.edge.driver","C:\\SeleniumFrameWork\\driver\\edgedriver\\MicrosoftWebDriver.exe");
		//WebDriver conductor= new EdgeDriver();
		
		conductor.get("http://facebook.com");
		
		conductor.findElement(By.id("email")).sendKeys("gzyblizy@yahoo.ca");
		
		int Elements= conductor.findElements(By.xpath("//input")).size();
		
		
		
		System.out.println(Elements);
		
	}
}
