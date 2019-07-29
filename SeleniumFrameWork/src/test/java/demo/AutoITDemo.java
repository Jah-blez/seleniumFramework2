package demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {
	public static void main(String[] args) throws Exception {
		test();
	}
	public static void test() throws IOException, Exception {
	String projectpath= System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");


	
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
		driver.get("http://www.tinyupload.com/");
		
		driver.findElement(By.xpath("//input[@name='uploaded_file']")).click();
		
		Runtime.getRuntime().exec("F:\\Application Installed\\fileuploadscript.exe");
		
		Thread.sleep(3000);
		
		driver.close();
	}
}
