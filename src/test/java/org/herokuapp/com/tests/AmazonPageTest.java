package org.herokuapp.com.tests;

import org.herokuapp.com.pages.AmazonPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.basetest.BaseTest2;

public class AmazonPageTest extends BaseTest2 {

	public static AmazonPage amaz;

	@BeforeMethod
	public void amazonLevel1Test() {

		System.out.println("\033[1mBefore Method Test Started!\033[0m");
		System.out.println("Here URL Launching!");
		driver.get("https://www.amazon.in/ref=nav_logo");
		amaz = new AmazonPage(driver);
	}

	@Test
	public void amazonTest() throws InterruptedException {
		amaz.amaztest();
	}
}
