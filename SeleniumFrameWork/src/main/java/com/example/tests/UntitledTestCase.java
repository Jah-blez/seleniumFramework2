package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
 private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath :" + projectpath);
	  System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://192.168.200.25/CIPMMembershipPortal/home/index?ReturnUrl=%2fCIPMMembershipPortal%2f");
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.linkText("New Profile")).click();
    driver.findElement(By.id("FirstName")).click();
    driver.findElement(By.id("FirstName")).clear();
    driver.findElement(By.id("FirstName")).sendKeys("Timi");
    driver.findElement(By.id("LastName")).click();
    driver.findElement(By.id("LastName")).clear();
    driver.findElement(By.id("LastName")).sendKeys("Smoke");
    driver.findElement(By.id("Email")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("ttt@gmail.com");
    driver.findElement(By.id("ConfirmEmail")).clear();
    driver.findElement(By.id("ConfirmEmail")).sendKeys("ttt@gmail.com");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("password");
    driver.findElement(By.id("ConfirmPassword")).clear();
    driver.findElement(By.id("ConfirmPassword")).sendKeys("password");
    driver.findElement(By.id("ConfirmPassword")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("Email")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("oteebest@yahoo.com");
    driver.findElement(By.id("Password")).click();
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("pass");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='card_travel'])[2]/following::span[1]")).click();
    driver.findElement(By.id("Email")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("ttt@gmail.com");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change Email'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CIPM'])[1]/following::span[1]")).click();
    driver.findElement(By.linkText("Log Out")).click();
    driver.findElement(By.id("Email")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("ttt@gmail.com");
    driver.findElement(By.id("Password")).click();
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("password");
    driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='NYSC Application'])[1]/following::a[1]")).click();
    driver.findElement(By.id("paymentbtn")).click();
    driver.findElement(By.id("TitleID")).click();
    new Select(driver.findElement(By.id("TitleID"))).selectByVisibleText("Mr");
    driver.findElement(By.id("TitleID")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::span[4]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Continue'])[1]/following::a[2]")).click();
   driver.findElement(By.linkText("January 2009")).click();
    driver.findElement(By.linkText("2009")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Continue'])[1]/following::td[1]")).click();
    driver.findElement(By.linkText("Jan")).click();
    driver.findElement(By.linkText("3")).click();
    driver.findElement(By.id("MobileNo")).click();
    driver.findElement(By.id("MobileNo")).clear();
    driver.findElement(By.id("MobileNo")).sendKeys("09087654321");
    driver.findElement(By.id("Sex")).click();
    new Select(driver.findElement(By.id("Sex"))).selectByVisibleText("Male");
    driver.findElement(By.id("Sex")).click();
    driver.findElement(By.id("MaritalStatusID")).click();
    new Select(driver.findElement(By.id("MaritalStatusID"))).selectByVisibleText("Single");
    driver.findElement(By.id("MaritalStatusID")).click();
    driver.findElement(By.id("StateOfOriginID")).click();
    new Select(driver.findElement(By.id("StateOfOriginID"))).selectByVisibleText("EDO");
    driver.findElement(By.id("StateOfOriginID")).click();
    new Select(driver.findElement(By.id("LgaID"))).selectByVisibleText("regexp:IGUEGBEN\\s+");
    driver.findElement(By.id("LgaID")).click();
    driver.findElement(By.id("ZoneID")).click();
    new Select(driver.findElement(By.id("ZoneID"))).selectByVisibleText("NORTH EAST");
    driver.findElement(By.id("ZoneID")).click();
    driver.findElement(By.id("BranchID")).click();
    new Select(driver.findElement(By.id("BranchID"))).selectByVisibleText("Borno");
    driver.findElement(By.id("BranchID")).click();
    driver.findElement(By.name("StateOfRegistrationID")).click();
    new Select(driver.findElement(By.name("StateOfRegistrationID"))).selectByVisibleText("GOMBE");
    driver.findElement(By.name("StateOfRegistrationID")).click();
    driver.findElement(By.id("ResidentialPhoneNo")).click();
    driver.findElement(By.id("ResidentialPhoneNo")).clear();
    driver.findElement(By.id("ResidentialPhoneNo")).sendKeys("08097654321");
    driver.findElement(By.id("ContactAddress")).click();
    driver.findElement(By.id("ContactAddress")).clear();
    driver.findElement(By.id("ContactAddress")).sendKeys("test");
    driver.findElement(By.id("ResidentialAddress")).click();
    driver.findElement(By.id("ResidentialAddress")).clear();
    driver.findElement(By.id("ResidentialAddress")).sendKeys("ekwensu");
    driver.findElement(By.id("NKFullName")).click();
    driver.findElement(By.id("NKFullName")).clear();
    driver.findElement(By.id("NKFullName")).sendKeys("test");
    driver.findElement(By.id("NKRelationship")).click();
    driver.findElement(By.id("NKRelationship")).clear();
    driver.findElement(By.id("NKRelationship")).sendKeys("bros");
    driver.findElement(By.id("NKEmail")).click();
    driver.findElement(By.id("NKEmail")).clear();
    driver.findElement(By.id("NKEmail")).sendKeys("yo@gmail.com");
    driver.findElement(By.id("NKPhoneNo")).clear();
    driver.findElement(By.id("NKPhoneNo")).sendKeys("07098965432");
    driver.findElement(By.id("NKAddress")).click();
    driver.findElement(By.id("NKAddress")).clear();
    driver.findElement(By.id("NKAddress")).sendKeys("test");
    driver.findElement(By.id("addEducation")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='--Select Institution--'])[2]/following::span[1]")).click();
    driver.findElement(By.id("CourseOfStudyID")).click();
    new Select(driver.findElement(By.id("CourseOfStudyID"))).selectByVisibleText("Fisheries");
    driver.findElement(By.id("CourseOfStudyID")).click();
    driver.findElement(By.id("DegreeID")).click();
    new Select(driver.findElement(By.id("DegreeID"))).selectByVisibleText("B.Sc");
    driver.findElement(By.id("DegreeID")).click();
    driver.findElement(By.id("YearAcquired")).click();
    new Select(driver.findElement(By.id("YearAcquired"))).selectByVisibleText("1976");
    driver.findElement(By.id("YearAcquired")).click();
    driver.findElement(By.id("add")).click();
    driver.findElement(By.id("RouteDocuments_0__UploadFile")).click();
    driver.findElement(By.id("RouteDocuments_0__UploadFile")).clear();
    driver.findElement(By.id("RouteDocuments_0__UploadFile")).sendKeys("C:\\fakepath\\2.png");
    driver.findElement(By.id("PhotoPath")).click();
    driver.findElement(By.id("PhotoPath")).click();
    driver.findElement(By.id("PhotoPath")).clear();
    driver.findElement(By.id("PhotoPath")).sendKeys("C:\\fakepath\\2.png");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
    driver.findElement(By.linkText("Continue to Payment")).click();
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

