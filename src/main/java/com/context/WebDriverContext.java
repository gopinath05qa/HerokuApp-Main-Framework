package com.context;

import org.openqa.selenium.WebDriver;

public class WebDriverContext {

//	private static InheritableThreadLocal<WebDriver> driverinstance = new InheritableThreadLocal<>();  //this actual old one

	private static ThreadLocal<WebDriver> driverinstance = new ThreadLocal<>();  //this recently created one only.
	
	public static WebDriver getDriver() {
		if (driverinstance.get() == null)
			throw new IllegalStateException(
					"WebDriver has not been set, Please set WebDriver instance by WebDriverContext.setDriver...");
		else
			return driverinstance.get();
	}

	public static void setDriver(WebDriver driver) {
		driverinstance.set(driver);
	}

	public static void removeDriver() {
		driverinstance.remove();
	}
}
