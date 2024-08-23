package com.basepage;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

/**
 * Second commit The Class BasePage every Page should extend this class.
 *
 */
public class BasePage {

	/** The driver. */
	protected WebDriver driver;

	/** The waiter. */
	protected FluentWait<WebDriver> waiter;

	/**
	 * Instantiates a new base page.
	 *
	 * @param driver the driver commit check
	 */
	public BasePage(WebDriver driver) {
//		super();                //***Just "gopi' commanded this. if face any issue un-command it.
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
	}

}
