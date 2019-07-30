package mentor.qa.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WDTest {
   public static void main(String []args) {
	   System.setProperty("webdriver.gecko.driver", "C:\\Users\\gonyebuchi\\Downloads\\drivers_browser\\geckodriver.exe");
	   WebDriver WT= new FirefoxDriver();
	  // System.setProperty("webdriver.chrome.driver","C:\\Users\\gonyebuchi\\Downloads\\drivers_browser\\chromedriver.exe");
	  // WebDriver WT = new ChromeDriver();
	 //  WebDriverWait wait = new WebDriverWait(WT,120);
	  // WT.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  String baseURL= "http://localhost/VatBrochure/";
	   
	  WT.get(baseURL);
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
	 // WT.findElement(By.id("Email")).clear();
	  WT.findElement(By.id("Email")).sendKeys("godbless.onyebuchi@gmail.com");
	 // WT.findElement(By.id("Password")).clear();
	  WT.findElement(By.id("Password")).sendKeys("Treasure77.");
	  WT.findElement(By.xpath("//input[@value='Log in']")).click();
	  WT.findElement(By.cssSelector("h5.text-white")).click();
	  WT.findElement(By.linkText("Logout")).click();
	    WT.close();
   }
}

