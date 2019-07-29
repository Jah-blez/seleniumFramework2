package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class searchObject {

	public searchObject (WebDriver conductor){
		this.conductor= conductor;
	}
	
	WebDriver conductor= null;
	By textbox = By.name("q");
	By button = By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']");
	
	public void setTextInBox (String text) {
		conductor.findElement(textbox).sendKeys(text);
	}
	
	public void clickSearchBox () {
		conductor.findElement(button).sendKeys(Keys.RETURN);
	}
}
