package mentor.qa.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class VatBrochureIDE {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\gonyebuchi\\Downloads\\drivers_browser\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://localhost/";
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testVat3() throws Exception {
    driver.get(baseUrl + "/VatBrochure/Account/Login?ReturnUrl=%2FVatBrochure%2F");
    
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("godbless.onyebuchi@gmail.com");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("Treasure77.");
    driver.findElement(By.xpath("//input[@value='Log in']")).click();
    driver.findElement(By.cssSelector("h5.text-white")).click();
    driver.findElement(By.linkText("Logout")).click();
  }

  
  }

