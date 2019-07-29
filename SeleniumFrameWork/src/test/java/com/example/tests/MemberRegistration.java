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

public class MemberRegistration {
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
  
  //   
  public void testMemberRegistration() throws Exception {
    driver.get("http://192.168.200.25/CIPMMembershipPortal");
    driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("rj@gmail.com");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("password");
    driver.findElement(By.xpath("//input[@value='Log in']")).click();
    driver.findElement(By.xpath("//div[@class='row']//div[@class='container']//div[@class='container']//div[2]//div[1]//div[2]//a[1]")).click();
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='NYSC Application'])[1]/following::a[1]")).click();
    driver.findElement(By.id("paymentbtn")).click();
    
    /*
    driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
    driver.findElement(By.id("Email")).sendKeys("rj@gmail.com");
    driver.findElement(By.id("Password")).sendKeys("password");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
    
    
   driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='NYSC Application'])[1]/following::a[1]")).click();

 

    driver.findElement(By.id("paymentbtn")).click();
    
    */
    driver.findElement(By.id("TitleID")).click();
    driver.findElement(By.id("TitleID")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::span[4]")).click();
    driver.findElement(By.linkText("January 2000")).click();
    driver.findElement(By.linkText("2000")).click();
    driver.findElement(By.linkText("1999")).click();
    driver.findElement(By.linkText("Jan")).click();
    driver.findElement(By.linkText("12")).click();
    driver.findElement(By.id("MobileNo")).click();
    driver.findElement(By.id("LgaID")).click();
    driver.findElement(By.id("LgaID")).click();
    driver.findElement(By.id("StateOfOriginID")).click();
    new Select(driver.findElement(By.id("StateOfOriginID"))).selectByVisibleText("BAYELSA");
    driver.findElement(By.id("StateOfOriginID")).click();
    driver.findElement(By.id("MaritalStatusID")).click();
    new Select(driver.findElement(By.id("MaritalStatusID"))).selectByVisibleText("Divorced");
    driver.findElement(By.id("MaritalStatusID")).click();
    driver.findElement(By.id("Sex")).click();
    driver.findElement(By.id("Sex")).click();
    driver.findElement(By.id("ZoneID")).click();
    new Select(driver.findElement(By.id("ZoneID"))).selectByVisibleText("SOUTH WEST");
    driver.findElement(By.id("ZoneID")).click();
    driver.findElement(By.id("BranchID")).click();
    new Select(driver.findElement(By.id("BranchID"))).selectByVisibleText("Ondo");
    driver.findElement(By.id("BranchID")).click();
    driver.findElement(By.id("ContactAddress")).click();
    driver.findElement(By.id("ContactAddress")).clear();
    driver.findElement(By.id("ContactAddress")).sendKeys("testing");
    driver.findElement(By.id("ResidentialPhoneNo")).click();
    driver.findElement(By.id("ResidentialPhoneNo")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=ResidentialPhoneNo | ]]
    driver.findElement(By.id("ResidentialPhoneNo")).clear();
    driver.findElement(By.id("ResidentialPhoneNo")).sendKeys("09087654321");
    driver.findElement(By.id("ResidentialAddress")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=ResidentialAddress | ]]
    driver.findElement(By.id("ResidentialAddress")).clear();
    driver.findElement(By.id("ResidentialAddress")).sendKeys("testing");
    driver.findElement(By.id("NKFullName")).click();
    driver.findElement(By.id("NKFullName")).clear();
    driver.findElement(By.id("NKFullName")).sendKeys("judges");
    driver.findElement(By.id("NKRelationship")).click();
    driver.findElement(By.id("NKRelationship")).clear();
    driver.findElement(By.id("NKRelationship")).sendKeys("testing");
    driver.findElement(By.id("NKPhoneNo")).click();
    driver.findElement(By.id("NKPhoneNo")).clear();
    driver.findElement(By.id("NKPhoneNo")).sendKeys("800637282764");
    driver.findElement(By.id("NKAddress")).click();
    driver.findElement(By.id("NKAddress")).clear();
    driver.findElement(By.id("NKAddress")).sendKeys("testi");
    driver.findElement(By.id("addEducation")).click();
    driver.findElement(By.id("select2-InstitutionID-container")).click();
    new Select(driver.findElement(By.id("select2-InstitutionID-container"))).selectByIndex(2);
    driver.findElement(By.id("CourseOfStudyID")).click();
    new Select(driver.findElement(By.id("CourseOfStudyID"))).selectByVisibleText("Fisheries");
    driver.findElement(By.id("CourseOfStudyID")).click();
    driver.findElement(By.id("DegreeID")).click();
    new Select(driver.findElement(By.id("DegreeID"))).selectByVisibleText("M.SC");
    driver.findElement(By.id("DegreeID")).click();
    driver.findElement(By.id("YearAcquired")).click();
    new Select(driver.findElement(By.id("YearAcquired"))).selectByVisibleText("1979");
    driver.findElement(By.id("YearAcquired")).click();
    driver.findElement(By.id("add")).click();
    driver.findElement(By.id("RouteDocuments_0__UploadFile")).click();
    driver.findElement(By.id("RouteDocuments_0__UploadFile")).clear();
    driver.findElement(By.id("RouteDocuments_0__UploadFile")).sendKeys("C:\\Users\\gonyebuchi\\Pictures\\receipt.jpeg");
    driver.findElement(By.id("PhotoPath")).click();
    driver.findElement(By.id("PhotoPath")).clear();
    driver.findElement(By.id("PhotoPath")).sendKeys("C:\\Users\\gonyebuchi\\Pictures\\download (1).jpeg");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
    driver.findElement(By.id("LgaID")).click();
    new Select(driver.findElement(By.id("LgaID"))).selectByVisibleText("regexp:BRASS\\s+");
    driver.findElement(By.id("LgaID")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
    // ERROR: Caught exception [unknown command []]
    
    
  }

  @After
  public void tearDown() throws Exception {
	  /*
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
    */
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
