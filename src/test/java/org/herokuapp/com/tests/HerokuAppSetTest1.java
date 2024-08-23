package org.herokuapp.com.tests;

import java.awt.AWTException;

import org.herokuapp.com.pages.HerokuAppSet1;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.basetest.BaseTest;
import com.factory.PageinstancesFactory;
import com.listeners.RetryListener;

//@Test(testName = "HerokuApp Test", description = "To Automate HerokuApp Functionalities")

public class HerokuAppSetTest1 extends BaseTest {

	@Test(groups = {
			"First Set" }, enabled = true, priority = 0, testName = "Add/Remove Elements Test", description = "To Automate Add/Remove Elements")
	public void addandRemoveElements() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.addRemoveElements();
	}

	@Test(groups = "First Set", enabled = true, priority = 1, testName = "Basic Auth Test", description = "To Automate Basic Auth")
	public void basicAuthTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.basicAuth();
	}

	@Test(groups = "First Set", enabled = true, priority = 2, testName = "Broken Image Test", description = "To Automate Broken Image")
	public void brokenImagesTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.brokenImage();
	}

//	@Test(retryAnalyzer = RetryListener.class, enabled = true, priority = 3, testName = "Add/Remove Elements Test", description = "To Automate Add/Remove Elements")
	@Test(groups = "First Set", enabled = true, priority = 3, testName = "Add/Remove Elements Test", description = "To Automate Add/Remove Elements")
	public void challengingDomTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.challengingDom();
	}

	@Test(groups = "First Set", enabled = true, priority = 4, testName = "Check Box Test", description = "To Automate Check Box")
	public void checkBoxTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.checkBoxes();
	}

	@Test(groups = "Second Set", enabled = true, priority = 5, testName = "Context Menu Test", description = "To Automate Context Menu")
	public void contextMenuTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.contextMenus();
	}

	@Test(groups = "Second Set", enabled = true, priority = 6, testName = "Drag and Drop Test", description = "To Automate Drag and Drop")
	public void dragandDropTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.dragandDrop();
	}

	@Test(groups = "Second Set", enabled = true, priority = 7, testName = "Drop Down Test", description = "To Automate Drop Down")
	public void dropDownTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.dropDown();
	}

	@Test(groups = "Second Set", enabled = true, priority = 8, testName = "Frame Handling Test", description = "To Automate Frame Handling")
	public void frameHandlingTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.framesHandling();
	}

	@Test(groups = "Second Set", enabled = true, priority = 9, testName = "Geo Location Test", description = "To Automate Geo Location Test")
	public void geoLocationTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.getGeoLocation();
	}

	@Test(groups = "Third Set", enabled = true, priority = 10, testName = "File Upload Method1", description = "To Automate File Upload Method1")
	public void fileUploadTest1() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.uploadFileMethod1();
	}

	@Test(groups = "Third Set", enabled = false, priority = 11, testName = "File Upload Method2", description = "To Automate File Upload Method2")
	public void fileUploadTest2() throws AWTException {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.uploadFileMethod2();
	}

	@Test(groups = "Third Set", enabled = true, priority = 12, testName = "Web Table", description = "To Automate WebTableHandle")
	public void webTable() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.webTableHandle();
	}

	@Test(groups = "Third Set", enabled = true, priority = 13, testName = "Mouse Hover", description = "To Automate Mouse Hover")
	public void mouseHoverTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.mouseHover();
	}

	@Test(groups = "Third Set", enabled = true, priority = 14, testName = "Scroll Uo to Down", description = "To Automate Scroll up-down")
	public void scrollupdowntest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.scrollupDown();
	}

	@Test(groups = "Third Set", enabled = true, priority = 15, testName = "alert handle", description = "To Automate Alert Handling")
	public void alertHandle() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.alertHandle();
	}

	@Test(groups = "Third Set", enabled = true, priority = 16, testName = "wait handle", description = "To Automate wait Handling")
	public void waitHandleTest() {
		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);
		lau.waitHandle();
	}
}
