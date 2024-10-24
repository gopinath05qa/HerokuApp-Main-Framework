package org.herokuapp.com.tests;

import java.awt.AWTException;

import org.herokuapp.com.pages.HerokuAppPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.basetest.BaseTest2;
import com.factory.PageinstancesFactory;

//@Test(testName = "HerokuApp Test", description = "To Automate HerokuApp Functionalities")

//@Epic("Regression Test CRM") // It's depends for Allure Report.
//@Feature("Client Test") // It's depends for Allure Report.

public class HerokuAppPageTest extends BaseTest2 {

	HerokuAppPage app1;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("\033[1mBefore Method Test Started!\033[0m");
		System.out.println("Here URL Launching!");
		driver.get("https://the-internet.herokuapp.com/");
		app1 = new HerokuAppPage(driver);

////**********This one also working fine, but we need to optimize more thinks here..*************//
//      // Open a new tab using JavaScript    
//      ((JavascriptExecutor) driver).executeScript("window.open()");
//      // Switch to the new tab
//      driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
//      // Navigate to a URL in the new tab
//      driver.get("https://the-internet.herokuapp.com/");
		System.out.println("\033[1mBefore Method Test Ended!\033[0m");
	}

	@Test(groups = {
			"First Set" }, enabled = true, priority = 0, testName = "Add/Remove Elements Test", description = "To Automate Add/Remove Elements")
	public void addandRemoveElements() {
//		HerokuAppSet1 lau = PageinstancesFactory.getInstance(HerokuAppSet1.class);   //old code pagefact1 ******This also working fine!
		app1.addRemoveElements();
	}

	@Test(groups = "First Set", enabled = true, priority = 1, testName = "Basic Auth Test", description = "To Automate Basic Auth")
	public void basicAuthTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.basicAuth();
	}

	@Test(groups = "First Set", enabled = true, priority = 2, testName = "Broken Image Test", description = "To Automate Broken Image")
	public void brokenImagesTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.brokenImage();
	}

//	@Test(retryAnalyzer = RetryListener.class, enabled = true, priority = 3, testName = "Add/Remove Elements Test", description = "To Automate Add/Remove Elements")
	@Test(groups = "First Set", enabled = false, priority = 3, testName = "Add/Remove Elements Test", description = "To Automate Add/Remove Elements")
	public void challengingDomTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.challengingDom();
	}

	@Test(groups = "First Set", enabled = true, priority = 4, testName = "Check Box Test", description = "To Automate Check Box")
	public void checkBoxTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.checkBoxes();
	}

	@Test(groups = "Second Set", enabled = true, priority = 5, testName = "Context Menu Test", description = "To Automate Context Menu")
	public void contextMenuTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.contextMenus();
	}

	@Test(groups = "Second Set", enabled = true, priority = 6, testName = "Drag and Drop Test", description = "To Automate Drag and Drop")
	public void dragandDropTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.dragandDrop();
	}

	@Test(groups = "Second Set", enabled = true, priority = 7, testName = "Drop Down Test", description = "To Automate Drop Down")
	public void dropDownTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.dropDown();
	}

	@Test(groups = "Second Set", enabled = true, priority = 8, testName = "Frame Handling Test", description = "To Automate Frame Handling")
	public void frameHandlingTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.framesHandling();
	}

	@Test(groups = "Second Set", enabled = true, priority = 9, testName = "Geo Location Test", description = "To Automate Geo Location Test")
	public void geoLocationTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.getGeoLocation();
	}

	@Test(groups = "Third Set", enabled = true, priority = 10, testName = "File Upload Method1", description = "To Automate File Upload Method1")
	public void fileUploadTest1() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.uploadFileMethod1();
	}

	@Test(groups = "Third Set", enabled = false, priority = 11, testName = "File Upload Method2", description = "To Automate File Upload Method2")
	public void fileUploadTest2() throws AWTException {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.uploadFileMethod2();
	}

	@Test(groups = "Third Set", enabled = true, priority = 12, testName = "Web Table", description = "To Automate WebTableHandle")
	public void webTable() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.webTableHandle();
	}

	@Test(groups = "Third Set", enabled = true, priority = 13, testName = "Mouse Hover", description = "To Automate Mouse Hover")
	public void mouseHoverTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.mouseHover();
	}

	@Test(groups = "Third Set", enabled = true, priority = 14, testName = "Scroll Uo to Down", description = "To Automate Scroll up-down")
	public void scrollupdowntest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.scrollupDown();
	}

	@Test(groups = "Third Set", enabled = true, priority = 15, testName = "alert handle", description = "To Automate Alert Handling")
	public void alertHandle() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.alertHandle();
	}

	@Test(groups = "Third Set", enabled = true, priority = 16, testName = "wait handle", description = "To Automate wait Handling")
	public void waitHandleTest() {
		HerokuAppPage lau = PageinstancesFactory.getInstance(HerokuAppPage.class);
		lau.waitHandle();
	}

}
