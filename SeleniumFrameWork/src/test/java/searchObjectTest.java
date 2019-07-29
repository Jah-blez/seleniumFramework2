import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.searchObject;

public class searchObjectTest {

	public static void main(String[] args) {
		
		searchTest();
		
	}
	public static void searchTest() {
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);
		
		System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
		WebDriver conductor = new ChromeDriver();
		conductor.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		conductor.get("https://google.com");
		
		searchObject Obj = new searchObject(conductor);
		
		Obj.setTextInBox("Automated testing");
		
		Obj.clickSearchBox();
		
int Elements= conductor.findElements(By.xpath("//input")).size();
		
		
		
		System.out.println(Elements);
		
		
		
	}
	
}
