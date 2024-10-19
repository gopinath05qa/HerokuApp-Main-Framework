package org.seleniumlearn.com.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.context.Constants;
import com.util.TestProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumLearn {

	String allwindows;

//*************1.Browser / URL launch / Chrome Headless*********************************************	
	public void browserLaunchMethod1() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

	public void browserLaunchMethod2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

	public void chromeHeadlessShell() {
//		System.setProperty("webdriver.chrome.driver", Constants.CHROME_Headless_DRIVER_PATH);  //no use for this "ChromeHeadlessShell" setup
//		WebDriverManager.chromedriver().setup();    //as well as without this, the browser get launching and working.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // Enable headless mode
		options.addArguments("--disable-gpu"); // Disable GPU acceleration
		// Initialize WebDriver with ChromeOptions
		WebDriver driver = new ChromeDriver(options);
		// Perform testing operations
		driver.get("https:www.google.com");
		System.out.println("Page Title: " + driver.getTitle());
	}

//*********************2.Navigations********************************************
	public void navigations() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://the-internet.herokuapp.com/"); // it will load same tab.
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
	}

//******************3.Window Handling / Frame Handling / Alert Handling****************************************
	public void moveNewTab() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.switchTo().newWindow(WindowType.TAB); // New tab open code
		driver.get("https://the-internet.herokuapp.com/tables");
	}

	public void windowHandling() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String parentWindow = driver.getWindowHandle();   //getting a parent window / current window id.
		System.out.println("Parent Window :" + parentWindow);
		driver.switchTo().newWindow(WindowType.TAB); // New tab open code
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		ArrayList<String> windowlist = new ArrayList<String>(driver.getWindowHandles());   //getting all window id's.
		driver.switchTo().window(windowlist.get(1)); // this is without any loopings directly switch the tab.

		for (String windows : windowlist) { // this is with help of looping and with conditions.
			System.out.println("All Windows :" + windows);
			if (parentWindow.equals(windows)) {
				driver.switchTo().window(windows);
			} else {
				System.out.println("No windows matching");
			}
		}
	}

//*********************4.TakeScreenshot*********************************************	
	public void takeScreenshot() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:AutomationImageTest\\Screenshot" + System.currentTimeMillis() + ".jpg");
		FileUtils.copyFile(src, des);
	}

//******************5.Scroll UP/Down************************************************	
	public void scrollUPDown() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SeleniumLearn launch = new SeleniumLearn();
//		launch.browserLaunchMethod1();
//		launch.browserLaunchMethod2();
//		launch.chromeHeadlessShell();
//		launch.navigations();
//		launch.moveNewTab();
//		launch.windowHandling();
//		launch.takeScreenshot();
		launch.scrollUPDown();

	}

}
