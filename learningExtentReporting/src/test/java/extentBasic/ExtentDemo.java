package extentBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setReportName("Automation Test Result");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nilesh Tripathi");
		System.out.println("GIT Changes");
		System.out.println("GIT Changes Second");
		
		System.out.println("GIT Changes develop");
		System.out.println("GIT Changes develop1");
		System.out.println("GIT Changes develop2");
		System.out.println("GIT Changes develop3");
	}
	
	@Test
	public void initialDemo() {
		
		ExtentTest test = extent.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nilesh\\Desktop\\Udemy Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		
		test.fail("Result do not match");
		driver.quit();
		extent.flush();
	}
}
