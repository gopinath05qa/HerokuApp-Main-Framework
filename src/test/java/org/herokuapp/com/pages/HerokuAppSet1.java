package org.herokuapp.com.pages;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobjects.herokuapp.PageObjects;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HerokuAppSet1 extends BasePage {

	SeleniumHelper seleniumHelper;
	PageObjects pageobjects;

//************************Constructor*****************************************//
	public HerokuAppSet1(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
		pageobjects = new PageObjects(driver);
	}
//*****************************************************************************//

	public void addRemoveElements() {
		seleniumHelper.clickOnWebElement(pageobjects.clickaddremovelink);
		try {
			for (int i = 1; i <= 5; i++) {
				seleniumHelper.clickOnWebElement(pageobjects.clickAddElementButton);
				System.out.println("Element Added Successfully!");
			}
			ReportUtil.addScreenShot(LogStatus.PASS, "Element Added Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Unable to add element!");
		}

		for (WebElement element : pageobjects.getDeleteElements) { // this is just used for -- "*for each loop".
			System.out.println(element.getText());
		}
		try {
			for (int i = 1; i <= 5; i++) {
				seleniumHelper.clickOnWebElement(pageobjects.deleteElements);
				System.out.println("Element Deleted Successfully!");
			}
			ReportUtil.addScreenShot(LogStatus.PASS, "Element Deleted Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Unable to delete Elements!");
		}
	}

	public void basicAuth() { // This task not done properly
		seleniumHelper.clickOnWebElement(pageobjects.clickBasicAuth);
		ReportUtil.addScreenShot(LogStatus.PASS, "Just basicauth screen opened!");
	}

	public void brokenImage() {

		seleniumHelper.clickOnWebElement(pageobjects.clickBrokenImage);
		System.out.println(pageobjects.getimageElements.size());

		System.out.println("1. Broken Image - Single Element Status Check:");
		int response = RestAssured.given().baseUri("https://the-internet.herokuapp.com/").when().get("asdf.jpg")
				.getStatusCode();
		System.out.println(response); // 1. This is for single element status code check

		System.out.println("2. Broken Image - Multi-Element Status Code Check by *For Loop*:");
		for (int i = 0; i < pageobjects.getimageElements.size(); i++) { // This is for multi-element status check
																		// (by for loop)
			Response response1 = RestAssured.given().get(pageobjects.getimageElements.get(i).getAttribute("src"));
			System.out.println(response1.getStatusCode());
		}

		System.out.println("3. Broken Image - Multi-Element Status Code Check by *For Each Loop*:");
		try {
			for (WebElement wlt : pageobjects.getimageElements) { // This is for multi-element status check (by for each
																	// loop)
				Response response2 = RestAssured.given().get(wlt.getAttribute("src"));
//			System.out.println(response2.getStatusCode());
				if (response2.getStatusCode() <= 400) {
					System.out.println("Status Code: " + response2.getStatusCode() + "---The Image is not Broken");
				} else {
					System.out.println("Status Code: " + response2.getStatusCode() + "---The Image is Brokened");
				}
			}
			ReportUtil.addScreenShot(LogStatus.PASS, "Broken Image Tested successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the broken image check!");
		}
	}

	public void challengingDom() { // This task not done properly
		seleniumHelper.clickOnWebElement(pageobjects.clickChallengingDom);

		for (int i = 0; i <= 0; i++) {
			System.out.println("Loop :" + i);
			if (seleniumHelper.isElementDisplayed(pageobjects.clickbaz)) {
				seleniumHelper.clickOnWebElement(pageobjects.clickbaz);
				System.out.println("baz Element has visibled!");
				ReportUtil.addScreenShot(LogStatus.PASS, "baz Element has visibled!");
			} else {
				System.out.println("baz element not found");
				ReportUtil.addScreenShot(LogStatus.FAIL, "baz element not found");
			}
			if (seleniumHelper.isElementDisplayed(pageobjects.clickfoo)) {
				seleniumHelper.clickOnWebElement(pageobjects.clickfoo);
				System.out.println("foo Element has visibled!");
				ReportUtil.addScreenShot(LogStatus.PASS, "foo Element has visibled!");
			} else {
				System.out.println("foo element not found");
				ReportUtil.addScreenShot(LogStatus.FAIL, "foo element not found");
			}
			if (seleniumHelper.isElementDisplayed(pageobjects.clickqux)) {
				seleniumHelper.clickOnWebElement(pageobjects.clickqux);
				System.out.println("qux Element has visibled!");
				ReportUtil.addScreenShot(LogStatus.PASS, "qux Element has visibled!");
			} else {
				System.out.println("qux element not found");
				ReportUtil.addScreenShot(LogStatus.FAIL, "qux element not found");
			}
		}
	}

	public void checkBoxes() {
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickCheckbox);
			seleniumHelper.clickOnWebElement(pageobjects.checkbox1);
			ReportUtil.addScreenShot(LogStatus.PASS, "Checkboxes checked Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the Checkbox!");
		}
	}

	public void contextMenus() {

		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickcontextmenubox);
			seleniumHelper.rightClick(pageobjects.rightclickpath);
////			seleniumHelper.AcceptAlert();  //something issue with this line
////			ReportUtil.addScreenShot(LogStatus.PASS, "Context Menu Pass!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something Issue in the Alert Acception!");
		}
	}

	public void dragandDrop() {
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickDragandDropLink);
			seleniumHelper.dragandDrop(pageobjects.sourceElement, pageobjects.targetElement);
			ReportUtil.addScreenShot(LogStatus.PASS, "Drag and drop Done Successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the Drag and Drop!");
		}
	}

	public void dropDown() {
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickDropDownLink);
			seleniumHelper.SelectUsingVisibleText(pageobjects.selectDropDown, "Option 1");
			List<String> allValues = seleniumHelper.getAllDropDownValues(pageobjects.selectDropDown);
			System.out.println(allValues);
			ReportUtil.addScreenShot(LogStatus.PASS, "DropDown done Successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the dropdown!");
		}
	}

	public void framesHandling() {
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickFramesLink);
			seleniumHelper.clickOnWebElement(pageobjects.clickNestedFrame);
			driver.switchTo().frame(pageobjects.nestedFrame1);
			driver.switchTo().frame(pageobjects.nestedFrame2);
			String text = pageobjects.getMiddleContent.getText();
			System.out.println(text);
			ReportUtil.addScreenShot(LogStatus.PASS, "Frames Handling Done Successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the Frames Handling!");
		}
	}

	public void getGeoLocation() {
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickGeoLocationLink);
			seleniumHelper.jsClick(pageobjects.clickWhereAmI);
			String lat = pageobjects.getLatvalue.getText(); // not working when use Headless browser.....Error
			String lon = pageobjects.getLongvalue.getText();
			System.out.println("Your Latitude :" + lat + "/ Your Longitude:" + lon);
			ReportUtil.addScreenShot(LogStatus.PASS, "getGeoLocation Done Successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL,
					"Something issue in the getGeoLocation!--This HeadLess Browser Issue--");
		}
	}

	public void uploadFileMethod1() {
		try {
			System.out.println("1. normal sendkeys file upload:");
			seleniumHelper.clickOnWebElement(pageobjects.clickFileUploadLink);
			String imagePath = "D:\\AutomationImageTest\\9040034f5d635f46a4fb92128964fcca.jpg";
			seleniumHelper.sendKeys(pageobjects.chooseFile, imagePath);
			seleniumHelper.clickOnWebElement(pageobjects.finalUpload);
			ReportUtil.addScreenShot(LogStatus.PASS, "File Uploaded Successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the file upload!");
		}
	}

	public void uploadFileMethod2() { // this is issue in headless browser
		try {
			String imagePath = "D:\\AutomationImageTest\\9040034f5d635f46a4fb92128964fcca.jpg";
			seleniumHelper.clickOnWebElement(pageobjects.clickFileUploadLink);
			StringSelection filePath = new StringSelection(imagePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
			Robot robot = new Robot();
			robot.delay(3000);
			seleniumHelper.clickOnWebElement(pageobjects.chooseFilePath);
			// Press CTRL+V (or CMD+V on Mac) to paste the file path
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			// Press ENTER to confirm the upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			seleniumHelper.clickOnWebElement(pageobjects.finalUpload);
			ReportUtil.addScreenShot(LogStatus.PASS, "File Upload Method2 Success!");
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the file upload method2!");
		}
	}

	public void webTableHandle() {
		seleniumHelper.clickOnWebElement(pageobjects.clickWebTableLink);
		List<WebElement> trows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println(trows.size());

		try {
			System.out.println("1.Print entire table Rows one by one, by use For Each loop:");
			for (WebElement rows : trows) {
				System.out.println(rows.getText());
			}
			System.out.println("2. Print entire table Rows one by one, by use Normal For loop:");
			for (int i = 0; i < trows.size(); i++) {
				System.out.println(trows.get(i).getText());
			}
			ReportUtil.addScreenShot(LogStatus.PASS, "Web Table Handled Successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the web table handle!");
		}
//		System.out.println("Print Each Cells: each data based");
//		List<WebElement> cells= trows.get(i).findElements(By.xpath("//table[@id='table1']/tbody/tr"));
	}

	public void mouseHover() {
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickMouseHoverLink);
			Thread.sleep(3000);
			seleniumHelper.hoverOverAndClickOnElement(pageobjects.hoverElement);
			String hoverText = seleniumHelper.getText(pageobjects.getHoverText);
			System.out.println(hoverText);
			ReportUtil.addScreenShot(LogStatus.PASS, "mouseHover Done Successfully!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the mouse hover!");
		}
	}

	public void scrollupDown() {

		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickScrollLink);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); // Scroll down to the bottom of the page
			js.executeScript("window.scrollBy(0, 500);"); // Scroll down by 500 pixels
			ReportUtil.addScreenShot(LogStatus.PASS, "500 pixel scroll down successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Something issue in the scrolling!");
		}
	}

	public void alertHandle() {
		seleniumHelper.clickOnWebElement(pageobjects.clickAlertsLink);
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clicksimpleAlert);
			Alert alert1 = driver.switchTo().alert();
			System.out.println("Alert says: " + alert1.getText());
			alert1.accept();
			ReportUtil.addScreenShot(LogStatus.PASS, "Simple Alert Success!");
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Simple Alert Fail!");
		}
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickconfirmAlert);
			Alert alert2 = driver.switchTo().alert();
			System.out.println(alert2.getText());
			alert2.accept();
			ReportUtil.addScreenShot(LogStatus.PASS, "Confirm Alert Success!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Confirm Alert Fail!");
		}
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickpromptAlert);
			Alert alert3 = driver.switchTo().alert();
			System.out.println(alert3.getText());
			alert3.sendKeys("Hi!");
			alert3.accept();
			ReportUtil.addScreenShot(LogStatus.PASS, "Prompt Alert Success!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL, "Prompt Alert Fail!");
		}
	}

	public void waitHandle() {
		try {
			seleniumHelper.clickOnWebElement(pageobjects.clickGeoLocationLink);

//          Explicit Wait: 			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(pageobjects.clickWhereAmI));
			element.click();

//			seleniumHelper.jsClick(pageobjects.clickWhereAmI);

			String lat = pageobjects.getLatvalue.getText(); // not working when use Headless browser.....Error
			String lon = pageobjects.getLongvalue.getText();
			System.out.println("Your Latitude :" + lat + "/ Your Longitude:" + lon);
			ReportUtil.addScreenShot(LogStatus.PASS, "getGeoLocation Done Successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReportUtil.addScreenShot(LogStatus.FAIL,
					"Something issue in the getGeoLocation!--This HeadLess Browser Issue--");
		}
	}
}