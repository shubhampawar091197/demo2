package Library;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	protected static WebDriver driver;

	static ExtentTest test;
	static ExtentReports report;
	
	public void setupMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");  //get the connection with chrome driver
		driver = new ChromeDriver();  //chromer driver from above line will trigger the instance. //abstraction upcasting
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //to load the elements
		driver.manage().window().maximize();  //enlarge the window

	}
	
	public static void startTest()
	{
	report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\Goibibo\\FailedSS\\"+"ExtentReportResults.html");
	test = report.startTest("MyScript");
	}

		
	public void navigateToTheURL(String URL) throws InterruptedException {
		driver.navigate().to(URL);
		Thread.sleep(7000);
	}

	public void quitBrowser() {
		driver.quit();

	}

	public void refreshPge() {
		driver.navigate().refresh();
	}

	public void closeBrowser() {
		driver.close(); 
	}

	public BaseClass(WebDriver driver) {//initialize the value 
		this.driver = driver;
	}

	public static WebDriver getDriver() {//to carry forward it....what ever properties are stored in the driver need to be taken till the script class.
		return driver;
	}

}
