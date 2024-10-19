package org.herokuapp.com.tests;

import org.herokuapp.com.pages.AmazonTestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPageTest {

	public static AmazonTestPage aPage;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.get(
				"https://www.amazon.in/dp/B09G9HD6PD/?_encoding=UTF8&pd_rd_w=zFScg&content-id=amzn1.sym.e2696c35-fbdb-445c-ae76-197617b1470a&pf_rd_p=e2696c35-fbdb-445c-ae76-197617b1470a&pf_rd_r=5H86PGMMX8ZECBTA9028&pd_rd_wg=7fBus&pd_rd_r=cfd5a5ad-dc2e-47a9-9f59-7b4a61b60f90&ref_=pd_hp_d_hero_unk");
		aPage = new AmazonTestPage(driver);
	}

	@Test
	public void waitcheck() {
		aPage.waitHandle();
	}
}
