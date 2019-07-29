
//package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CourseRegi {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);
		
		System.setProperty("webdriver.FireFox.driver",projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCourseReg() throws Exception {
    driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin#identifier");
    driver.findElement(By.id("identifierId")).click();
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys("godbless.onyebuchi@gmail.com");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Learn more'])[1]/following::span[1]")).click();
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("treasure77.");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Too many failed attempts'])[1]/following::span[4]")).click();
    driver.get("https://courses.ultimateqa.com/users/sign_up");
    driver.findElement(By.linkText("Sign In")).click();
    driver.findElement(By.linkText("Create a new account")).click();
    driver.findElement(By.id("user_first_name")).click();
    driver.findElement(By.id("user_first_name")).clear();
    driver.findElement(By.id("user_first_name")).sendKeys("julius");
    driver.findElement(By.id("user_last_name")).click();
    driver.findElement(By.id("user_last_name")).clear();
    driver.findElement(By.id("user_last_name")).sendKeys("Ekemeni");
    driver.findElement(By.id("user_email")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("shgsjsb@jhjf.com");
    driver.findElement(By.id("user_password")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("jude747484844");
    driver.findElement(By.id("user_terms")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='reCAPTCHA'])[1]/preceding::div[4]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.id("btn-signup")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
