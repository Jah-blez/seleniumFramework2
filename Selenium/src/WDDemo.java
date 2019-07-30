import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
public class WDDemo {
 public static void main(String[] args) {
	 System.setProperty("webdriver.gecko.driver","C:\\Users\\gonyebuchi\\Downloads\\drivers_browser\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://mybankone.com/";
       
       

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        

 }
}
