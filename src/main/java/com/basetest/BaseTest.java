package com.basetest;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.context.WebDriverContext;
import com.util.EmailConfig;
import com.util.LoggerUtil;
import com.util.TestProperties;

/** Every test class should extend this class. */

//@Listeners({ ReportListener.class, LogListener.class })  //i used this on "FuntionalTest.xml" file, that's y commanded here...

public class BaseTest {

	public String excelpath = System.getProperty("user.dir") + "\\ExcelData\\excel.xls";

	protected WebDriver driver;

	@Parameters({ "browser", "url" })
//	@BeforeMethod(groups = { "First Set" }, alwaysRun = true)  //without first set grouping it's working. anyway keep it if any issue uncommand it.
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String browser, String url) {
		System.out.println("\033[1mBefore Method Test Started!\033[0m");
		if (browser.equalsIgnoreCase("chrome")
				&& TestProperties.getProperty("headlessBoolean").equalsIgnoreCase("true")) {
			ChromeOptions cops = new ChromeOptions();
			cops.addArguments("--disable-notifications");
			cops.addArguments("--headless");
			cops.addArguments("--disable-gpu");
			cops.addArguments("--window-size=1920,1080");
//**********These are additional chrome options methods, but not use now**************          			
//			ops.addArguments("--disable-dev-shm-usage");
//			ops.addArguments("--no-sandbox");
//			ops.addArguments("--ignore-certificate-errors");
//			ops.addArguments("--allow-running-insecure-content");
//			ops.addArguments("--window-size=1920,1080");
//			ops.addArguments("--no-sandbox");
//			ops.addArguments("--disable-extensions");
//			ops.addArguments("--proxy-server='direct://'");
//			ops.addArguments("--proxy-bypass-list=*");
//			ops.addArguments("--start-maximized");
//			driver = new ChromeDriver(ops);
//			driver.get(url);
			driver = new ChromeDriver(cops);
		} else if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions cops = new ChromeOptions();
			driver = new ChromeDriver(cops);
		}
		if (browser.equalsIgnoreCase("firefox")
				&& TestProperties.getProperty("headlessBoolean").equalsIgnoreCase("true")) {
			FirefoxOptions fops = new FirefoxOptions();
			fops.addArguments("--disable-notifications");
			fops.addArguments("--headless");
			fops.addArguments("--disable-gpu");
			fops.addArguments("--window-size=1920,1080");
			driver = new FirefoxDriver(fops);
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions fops = new FirefoxOptions();
			driver = new FirefoxDriver(fops);
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // this is deprecated one. not use.
		WebDriverContext.setDriver(driver);
		System.out.println("\033[1mBefore Method Test Ended!\033[0m");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("\033[1mAfter Method Started!\033[0m");
		if (driver != null) {
//			driver.close();
			driver.quit();
		}
		System.out.println("\033[1mAfter Method Ended!\033[0m");
	}

	@BeforeClass(alwaysRun = true)
	protected void setup() {
		System.out.println("\033[1mBefore Class Started!\033[0m");
		System.out.println("\033[1mBefore Class Ended!\033[0m");
	}

	@AfterClass(alwaysRun = true)
	public void wrapUp() {
		System.out.println("\033[1mAfter Class Started!\033[0m");
//		if (driver != null) {
//			driver.close();
//			driver.quit();
//		}
		System.out.println("\033[1mAfter Class Ended!\033[0m");
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("\033[1mBefore Test Started!\033[0m");
		System.out.println("\033[1mBefore Test Ended!\033[0m");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("\033[1mAfter Test Started!\033[0m");
//		if (driver != null) {
//			driver.close();
//			driver.quit();
//		}
		System.out.println("\033[1mAfter Test Ended!\033[0m");
	}

	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		System.out.println("\033[1mBefore Suite Started!\033[0m");
		LoggerUtil.info("************************** Test Execution Started ************************************");
		TestProperties.loadAllPropertie();
		System.out.println("\033[1mBefore Suite Ended!\033[10m");
	}

//	@AfterSuite(alwaysRun = true)     //why this method commented?--because this one giving error in the command prompt run.
//	public void wrapAllUp(ITestContext context) throws Exception {
//		System.out.println("\033[1mAfter Suite Started!\033[0m");
//		int total = ITestContext.context.getAllTestMethods().length;
//		int passed = context.getPassedTests().size();
//		int failed = context.getFailedTests().size();
//		int skipped = context.getSkippedTests().size();
//		LoggerUtil.info("Total number of testcases : " + total);
//		LoggerUtil.info("Number of testcases Passed : " + passed);
//		LoggerUtil.info("Number of testcases Failed : " + failed);
//		LoggerUtil.info("Number of testcases Skipped  : " + skipped);
//		boolean mailSent = EmailConfig.ReportEmail(); // MailUtil.sendMail(total, passed, failed, skipped);
//		System.out.println(mailSent);
//		LoggerUtil.info("************************** Test Execution Finished ************************************");
//		System.out.println("\033[1mAfter Suite Ended!\033[0m");
//	}

	@AfterSuite(alwaysRun = true) // maven test asking clean aftersuite method like this.
	public void wrapAllUp() throws Exception {
		System.out.println("\033[1mAfter Suite Started!\033[0m");
		boolean mailSent = EmailConfig.ReportEmail(); // MailUtil.sendMail(total, passed, failed, skipped);
		System.out.println(mailSent);
		LoggerUtil.info("************************** Test Execution Finished ************************************");
		System.out.println("\033[1mAfter Suite Ended!\033[0m");
	}

}
