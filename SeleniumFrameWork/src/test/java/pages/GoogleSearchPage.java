package pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GoogleSearchPage {
	

	public static void main(String[] args) throws InterruptedException {
		
		googlesearch();
	}
	
	public static void googlesearch() {
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);
		
		System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		WebDriver conductor = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver",projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		//WebDriver conductor= new FirefoxDriver();
		//conductor.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//System.setProperty("webdriver.edge.driver","C:\\SeleniumFrameWork\\driver\\edgedriver\\MicrosoftWebDriver.exe");
		//WebDriver conductor= new EdgeDriver();
		
		conductor.get("https://www.google.com");
		
		
		//conductor.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation step by step");
		
		googlSearchTest.textbox_search1(conductor).clear();
		googlSearchTest.textbox_search(conductor).sendKeys("Automation step by step");
		
		googlSearchTest.textbox_search2(conductor).click();
		
		//conductor.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		googlSearchTest.button_search(conductor).click();
		
		int Elements= conductor.findElements(By.xpath("//input")).size();
		
		
		
		System.out.println(Elements);
		
	}
}
