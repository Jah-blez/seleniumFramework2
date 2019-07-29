package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class desiredCapability {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignorePotectedModeSettings", true);
		
		
		System.setProperty("webdriver.ie.driver", projectpath + "\\driver\\iedriver\\IEDriverServer.exe");
		WebDriver conductor= new InternetExplorerDriver(caps);
		//System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		//WebDriver conductor = new ChromeDriver();
		conductor.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		conductor.get("https://google.com");
				
		conductor.findElement(By.name("q")).sendKeys("abcd");
		
		conductor.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input2[@value='Google Search']")).sendKeys(Keys.RETURN);
		
	
		conductor.close();
		conductor.quit();
	}

}
