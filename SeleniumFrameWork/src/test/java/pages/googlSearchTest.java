package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googlSearchTest {
	
	static WebElement element = null;
	
	public static WebElement textbox_search (WebDriver conductor) {
		
	 element = conductor.findElement(By.name("q"));
	 return element;
	}
	
	public static WebElement textbox_search2 (WebDriver conductor) {
		
		 element = conductor.findElement(By.id("hplogo"));
		 return element;
		}
	
 public static WebElement button_search (WebDriver conductor) {
	 
	 element = conductor.findElement(By.name("btnK"));
	 return element;
 }

public static WebElement textbox_search1(WebDriver conductor) {
	element = conductor.findElement(By.name("q"));
	 return element;
}
	

}
