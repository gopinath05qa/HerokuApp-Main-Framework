package com.basetest;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest2 {

	public String excelpath = System.getProperty("user.dir") + "\\ExcelData\\excel.xls";
	
	protected WebDriver driver;

//	@BeforeMethod(alwaysRun = true) // ***here also working, but i commended here and used in each test
//									// methods****//
//	public void beforeMethod() {
//		System.out.println("\033[1mBefore Method Test Started!\033[0m");
//		System.out.println("Here URL Launching!");
//		driver.get("https://the-internet.herokuapp.com/");
////***********This one also working fine, but we need to optimize more thinks here..*********//
////      // Open a new tab using JavaScript    
////      ((JavascriptExecutor) driver).executeScript("window.open()");
////      // Switch to the new tab
////      driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
////      // Navigate to a URL in the new tab
////      driver.get("https://the-internet.herokuapp.com/");
//		System.out.println("\033[1mBefore Method Test Ended!\033[0m");
//	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("\033[1mAfter Method Started!\033[0m");
		System.out.println("\033[1mAfter Method Ended!\033[0m");
	}

	@Parameters({ "browser", "url" })
	@BeforeClass(alwaysRun = true)
	protected void setup(String browser, String url) {
		System.out.println("\033[1mBefore Class Started!\033[0m");

		if (browser.equalsIgnoreCase("chrome")
				&& TestProperties.getProperty("headlessBoolean").equalsIgnoreCase("true")) {
			ChromeOptions cops = new ChromeOptions();
			cops.addArguments("--disable-notifications");
			cops.addArguments("--headless");
			cops.addArguments("--disable-gpu");
			cops.addArguments("--window-size=1920,1080");
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
		WebDriverContext.setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("\033[1mBefore Class Ended!\033[0m");
	}

	@AfterClass(alwaysRun = true)
	public void wrapUp() {
		System.out.println("\033[1mAfter Class Started!\033[0m");
		if (driver != null) {
//			driver.close();
			driver.quit();
		}
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
		System.out.println("\033[1mAfter Test Ended!\033[0m");
	}

	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		System.out.println("\033[1mBefore Suite Started!\033[0m");
		LoggerUtil.info("************************** Test Execution Started ************************************");
		TestProperties.loadAllPropertie();
		System.out.println("\033[1mBefore Suite Ended!\033[10m");
	}

	@AfterSuite(alwaysRun = true) // maven test asking clean aftersuite method like this.
	public void wrapAllUp() throws Exception {
		System.out.println("\033[1mAfter Suite Started!\033[0m");
		boolean mailSent = EmailConfig.ReportEmail(); // MailUtil.sendMail(total, passed, failed, skipped);
		System.out.println(mailSent);
		LoggerUtil.info("************************** Test Execution Finished ************************************");
		System.out.println("\033[1mAfter Suite Ended!\033[0m");
	}

}
