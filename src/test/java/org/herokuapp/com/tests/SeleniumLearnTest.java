package org.herokuapp.com.tests;

import org.seleniumlearn.com.pages.SeleniumLearn;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumLearnTest {

	SeleniumLearn learn;

	@BeforeMethod
	public void beforeMethod() {
		learn = new SeleniumLearn();
	}

	@Test
	public void test() {
		learn.windowHandling();
	}
}
