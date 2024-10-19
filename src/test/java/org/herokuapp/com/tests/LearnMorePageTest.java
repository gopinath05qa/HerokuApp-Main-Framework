package org.herokuapp.com.tests;

import org.herokuapp.com.pages.LearnMorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnMorePageTest {

	public static LearnMorePage lpage;
	
	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://learnmoreplayground.blogspot.com/p/explicit-wait.html");
		lpage = new LearnMorePage(driver);
	}
	
	@Test
	public void waitcheck() {
		lpage.waitHandle();
	}
	
}
