package CIPM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class DietTimetable {

	private WebDriver driver;


	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		String projectpath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//maximize browser
		driver.manage().window().maximize();
	}

	@Test
	public void testDietTimetable() throws Exception {
		setUp();
		driver.get("http://192.168.8.43/CIPMMembershipPortal/Portal/login");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("oteebest@yahoo.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("pass");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LogIn'])[1]/following::input[6]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cooperate Application Processing'])[1]/following::a[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change Student Examination Category'])[1]/following::span[1]")).click();

		//action option






		//asserting by getting last value of the list of exam created to be clicked upon
		List <WebElement> optionlist = driver.findElements(By.xpath("//*[@id=\"applicant-list\"]/tbody/tr/td[11]"));
		int optionsize = optionlist.size();
		optionlist.get(optionsize-1).click();

		//click timetable option
		driver.findElement(By.xpath("//*[@id=\"applicant-list\"]/tbody/tr["+optionsize+"]/td[11]/div/ul/li[2]/a")).click();




		//to insert name of the timetable being set
		for (int i=1; i<7; i++) {
			DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();
			Calendar examstartdate = Calendar.getInstance();
			examstartdate.add(Calendar.DATE, 91);
			if (i==1) {
				new Select(driver.findElement(By.name("ProgramLevelId"))).selectByVisibleText("FOUNDATION I");
				//first course
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//second course
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//third course
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//fourth course
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//fifth course
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));


				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//resit course
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));
			}
			else if (i==2) {
				new Select(driver.findElement(By.name("ProgramLevelId"))).selectByVisibleText("FOUNDATION II");
				//first course
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//second course
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//third course
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//fourth course
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//fifth course
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));


				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//resit course
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));
			}
			else if (i==3) {
				new Select(driver.findElement(By.name("ProgramLevelId"))).selectByVisibleText("INTERMEDIATE I");
				//first course
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//second course
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//third course
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//fourth course
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));


				//resit course
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));
			}
			else if (i==4) {
				new Select(driver.findElement(By.name("ProgramLevelId"))).selectByVisibleText("INTERMEDIATE II");
				//first course
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//second course
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//third course
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//fourth course
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//resit course
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));
			}
			else if (i==5) {
				new Select(driver.findElement(By.name("ProgramLevelId"))).selectByVisibleText("PROFESSIONAL EXAMINATION I");
				//first course
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//second course
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//third course
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//fourth course
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//fifth course
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));


				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_4__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//resit course
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));
			}

			else if (i==6) {
				new Select(driver.findElement(By.name("ProgramLevelId"))).selectByVisibleText("PROFESSIONAL EXAMINATION II");
				//first course
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//second course
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_1__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//third course
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_2__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//fourth course
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"TableList_3__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				//resit course
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_Start_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));

				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"Resit_0__Exam_End_DateTime\"]")).sendKeys(dtf.format(examstartdate.getTime()));
			}

		}





		driver.findElement(By.id("btnSubmit")).click();


		//asserting by getting last value of the list to toggle
		List <WebElement> togglelist = driver.findElements(By.xpath("//*[@id=\"applicant-list\"]/tbody/tr/td[10]"));
		int togglesize = togglelist.size();
		togglelist.get(togglesize-1).click();
		
		//to close browser when called
		tearDown();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}




}
