
	import com.thoughtworks.selenium.Selenium
	import org.openqa.selenium.firefox.FirefoxDriver
	import org.openqa.selenium.WebDriver
	import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
	import static org.junit.Assert.*
	import java.util.regex.Pattern
	import static org.apache.commons.lang3.StringUtils.join

public class KatalonProject {
	
	WebUI.openBrowser('https://www.katalon.com/')
	def driver = DriverFactory.getWebDriver()
	String baseUrl = "https://www.katalon.com/"
	selenium = new WebDriverBackedSelenium(driver, baseUrl)
	selenium.open("https://www.google.com.ng/search?source=hp&ei=DZSkW46_F8HRrgTYgYKYBA&q=waec&oq=waec&gs_l=psy-ab.3..0l8j0i131k1j0.3040.3891.0.4214.4.3.0.1.1.0.376.376.3-1.1.0....0...1c..64.psy-ab..2.2.394....0.BL-e4Q1EToI")
	selenium.click("id=lst-ib")
	selenium.doubleClick("id=lst-ib")
	selenium.doubleClick("id=lst-ib")
	selenium.click("id=lst-ib")
	selenium.doubleClick("id=lst-ib")
	selenium.type("id=lst-ib", "update iyayin")
	selenium.sendKeys("id=lst-ib", "${KEY_ENTER}")
}
