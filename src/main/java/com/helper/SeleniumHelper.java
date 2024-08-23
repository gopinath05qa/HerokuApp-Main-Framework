package com.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.util.LoggerUtil;

public class SeleniumHelper {

	WebDriver driver;
	protected WebDriverWait wait;

	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;
	}

	/** * Method to WebElement get */

	public WebElement getWebElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement getWebElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public WebElement getWebElementByName(String name) {
		return driver.findElement(By.name(name));
	}

	/** * Method to highlight WebElement */

	public void highlightWebElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')",
				element);
	}

	public void highlightWebElementwithoutBg(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red')", element);
	}

	/** * Method to File Upload */

	public void fileUpload(String filepath) throws AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		StringSelection stringselcetion = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselcetion, null);
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.setAutoDelay(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	/** * Method to handle alert */

	public Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void AcceptAlert() {
		getAlert().accept();
	}

	public void DismissAlert() {
		getAlert().dismiss();
	}

	public String getAlertText() {
		String text = getAlert().getText();
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			AcceptAlert();
		else
			LoggerUtil.info("Alert is not present");
	}

	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			DismissAlert();
		else
			LoggerUtil.info("Alert is not present");
	}

	public void switchToFrame(String accessType, String accessName) {
		if (accessType.equalsIgnoreCase("index"))
			driver.switchTo().frame(accessName);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/** * Button Click helper */

	public void clickOnWebElement(WebElement ele) {

		try {
			ele.click();
		} catch (Exception ElementClickInterceptedException) {
			LoggerUtil.error(ele + " - Unable to click the element");
		}
	}

	public void rightClick(WebElement elem) { // ---gopi added one---
		Actions actions = new Actions(driver);
		// Perform the right-click (context click) on the element
		actions.contextClick(elem).perform();
	}

	/** * Browser Helper methods */

	public void goBack() {
		driver.navigate().back();

	}

	public void goForward() {
		driver.navigate().forward();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public Set<String> getWindowHandlens() {
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);

		driver.switchTo().window(windowsId.get(index));
	}

	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		System.out.println("no of windows from parent method : " + windowsId);
		driver.switchTo().window(windowsId.get(0));
	}

	public void switchToParentWithChildClose() {
		switchToParentWindow();
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		System.out.println("no of windows : " + windowsId);
		for (int i = 1; i < windowsId.size(); i++) {
			LoggerUtil.info(windowsId.get(i));
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}

		switchToParentWindow();
	}

	/** * Checkbox or Radio button helper */

	public boolean isIselected(WebElement element) {
		boolean flag = element.isSelected();
		return flag;
	}

	public void selectCheckBox(WebElement element) {
		if (!isIselected(element))
			element.click();
	}

	public void unSelectCheckBox(WebElement element) {
		if (isIselected(element))
			element.click();
	}

	/** * DropDownHelper helper */

	public void SelectUsingVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void SelectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void SelectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
		return value;
	}

	public List<String> getAllDropDownValues(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();

		for (WebElement ele : elementList) {
			LoggerUtil.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}

	/** * Link Helper Methods */

	public void clickLink(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}

	public void clickPartialLink(String partialLinkText) {
		driver.findElement(By.partialLinkText(partialLinkText)).click();
	}

	public String getHyperLink(WebElement element) {
		String link = element.getAttribute("href");
		return link;
	}

	/** * JavaScriptExecutor Helper Methods */

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	}

	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		highlightWebElement(element);
		element.click();
	}

	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
	}

	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
	}

	public void jsClick(WebElement element) {
		try {
			highlightWebElement(element);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception ElementClickInterceptedException) {
			LoggerUtil.error(element + " - Unable to click the element");
		}
	}

	/** * Navigation Helper Methods */

	public void navigateTo(String url) {
		LoggerUtil.info("Navigate To - " + url);
		driver.get(url);
	}

	public String getTitle() {
		String title = driver.getTitle();
		LoggerUtil.info("Page Title - " + title);
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		LoggerUtil.info("Current URL - " + url);
		return url;
	}

	/** * Text Box Helper Methods */

	public void backspace(WebElement element) {
		try {
			highlightWebElement(element);
			element.sendKeys(Keys.BACK_SPACE);
		} catch (Exception e) {
			LoggerUtil.error("Unable to do sendKeys on the Locator : " + element + " Value : ");
		}
	}

	public void sendKeys(WebElement element, String value) {
		try {
			highlightWebElement(element);
			element.sendKeys(value);
		} catch (Exception e) {
			LoggerUtil.error("Unable to do sendKeys on the Locator : " + element + " Value : " + value);
		}
	}

	public void sendKeyswithouthighlight(WebElement element, String value) {
		try {
			highlightWebElement(element);
			element.sendKeys(value);
		} catch (Exception e) {
			LoggerUtil.error("Unable to do sendKeys on the Locator : " + element + " Value : " + value);
		}
	}

	public void clear(WebElement element) {
		element.clear();

	}

	public void clearWebField(WebElement element) {
		while (!element.getAttribute("value").equals("")) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	public String getText(WebElement element) {
		String text = null;
		try {
			highlightWebElement(element);
			text = element.getText();
		} catch (Exception e) {
			LoggerUtil.error("Unable to do get text for the " + element);
		}
		return text;
	}

	public void clearAndSendKeys(WebElement element, String value) {
		try {
			// element.clear();
			String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
			element.sendKeys(del + value);
			highlightWebElement(element);
		} catch (Exception e) {
			LoggerUtil.error("Unable to clear and sendKeys on the Locator : " + element + " Value : " + value);
		}
	}

	public void sendKeysWithJS(WebElement element, String Text) {
		highlightWebElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", element);
		element.sendKeys(Text);
	}

	/** * Wait Helper Methods */

//	@SuppressWarnings("deprecat")  //--- gopi -- This code line forcing to remove that's why i commanded
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.ignoring(NoSuchElementException.class);
		// wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.pollingEvery(Duration.ofSeconds(3));
		wait.until(elementLocated(element));
	}

	private Function<WebDriver, Boolean> elementLocated(final WebElement element) {
		return new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				LoggerUtil.debug("Waiting for Element : " + element);
				return element.isDisplayed();
			}
		};
	}

	private WebDriverWait getWait(Duration timeOutInSeconds) {
		LoggerUtil.debug("");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.ignoring(NoSuchElementException.class);
		// wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	public void waitForElementVisible(By locator, int timeOutInSeconds) {
		WebDriverWait wait = getWait(Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}

	public void waitForElementVisible(WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = getWait(Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void hardWait(int timeOutInMiliSec) throws InterruptedException {
		Thread.sleep(timeOutInMiliSec);
	}

	public WebElement handleStaleElement(By locator, int retryCount, int delayInSeconds) throws InterruptedException {
		WebElement element = null;

		while (retryCount >= 0) {
			try {
				element = driver.findElement(locator);
				return element;
			} catch (StaleElementReferenceException e) {
				hardWait(delayInSeconds);
				retryCount--;
			}
		}
		throw new StaleElementReferenceException("Element cannot be recovered");
	}

	public void elementExits(By locator, int timeOutInSeconds) {
		WebDriverWait wait = getWait(Duration.ofSeconds(timeOutInSeconds));
		wait.until(elementLocatedBy(locator));
	}

	public void elementExistAndVisible(By locator, int timeOutInSeconds) {
		WebDriverWait wait = getWait(Duration.ofSeconds(timeOutInSeconds));
		wait.until(elementLocatedBy(locator));
		scrollIntoView(driver.findElement(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void waitForIframe(By locator, int timeOutInSeconds) {
		WebDriverWait wait = getWait(Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		driver.switchTo().defaultContent();
	}

	private Function<WebDriver, Boolean> elementLocatedBy(final By locator) {
		return new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				return driver.findElements(locator).size() >= 1;
			}
		};
	}

	/**
	 * Method to return key by OS wise
	 */
	public Keys getKey() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win"))
			return Keys.CONTROL;
		else if (os.contains("nux") || os.contains("nix"))
			return Keys.CONTROL;
		else if (os.contains("mac"))
			return Keys.COMMAND;
		else
			return null;
	}

	/**
	 * Method to verify the element is displayed
	 */
	public boolean isElementDisplayed(WebElement ele) {
		boolean flag = false;
		try {
			waitForElementVisible(ele, 20);
			flag = ele.isDisplayed();
			if (flag)
				highlightWebElement(ele);
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (Exception e1) {
			flag = false;
		}
		return flag;
	}

	public boolean isElementDisplayedwithoutBgColor(WebElement ele) {
		boolean flag = false;
		try {
			waitForElementVisible(ele, 20);
			flag = ele.isDisplayed();
			if (flag)
				highlightWebElementwithoutBg(ele);
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (Exception e1) {
			flag = false;
		}
		return flag;
	}

	/**
	 * Method to verify the element is displayed
	 */
	public boolean isElementDisplayedwithoutWait(WebElement ele) {
		boolean flag = false;
		try {
			waitForElementVisible(ele, 2);
			flag = ele.isDisplayed();
			if (flag)
				highlightWebElement(ele);
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (Exception e1) {
			flag = false;
		}
		return flag;
	}

	public boolean isElementDisplayed(String xpath) {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			waitForElementVisible(element, 20);
			flag = element.isDisplayed();
			if (flag)
				highlightWebElement(element);
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (Exception e1) {
			flag = false;
		}
		return flag;
	}

	public boolean isElementPresent(String xpath) {
		boolean flag = false;
		try {
			driver.findElement(By.xpath(xpath));
			flag = true;

		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;
	}

	public boolean isElementEnabled(WebElement ele) {
		boolean flag = false;
		try {
			flag = ele.isEnabled();
			if (flag)
				highlightWebElement(ele);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * Method to zoom in/out page
	 */
	public void zoomInOut(String inOut) {
		WebElement Sel = driver.findElement(By.tagName("html"));
		if (inOut.equals("ADD"))
			Sel.sendKeys(Keys.chord(getKey(), Keys.ADD));
		else if (inOut.equals("SUBTRACT"))
			Sel.sendKeys(Keys.chord(getKey(), Keys.SUBTRACT));
		else if (inOut.equals("reset"))
			Sel.sendKeys(Keys.chord(getKey(), Keys.NUMPAD0));
	}

	/**
	 * Method to zoom in/out web page until web element displays
	 */
	public void zoomInOutTillElementDisplay(WebElement element, String inOut) {
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(element));
		while (true) {
			if (element.isDisplayed())
				break;
			else
				action.keyDown(getKey()).sendKeys(inOut).keyUp(getKey()).perform();
		}
	}

	public void scrollToBottomOfPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * Method to hover on element
	 */
	public void hoverOverElement(WebElement element) {
		highlightWebElement(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void hoverOverAndClickOnElement(WebElement element) {
		highlightWebElement(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	/**
	 * Method to Double click on Webelement
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().build().perform();
	}

	/**
	 * Method to get the text from webElement
	 */
	public String getAttributeValue(WebElement element, String text) {
		String value = null;
		if (isElementDisplayed(element)) {
			highlightWebElement(element);
			value = element.getAttribute(text);
			if (value.isEmpty()) {
				value = text;
			}
		}
		return value;
	}

	/**
	 * Method to move to the element and click on it
	 */
	public void moveToElementAndClickOnIt(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	/**
	 * Method to scroll page to particular element
	 */
	public void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * Method to scroll page to top or end
	 */
	public void scrollPage(String to) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if (to.equals("end"))
			executor.executeScript(
					"window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		else if (to.equals("top"))
			executor.executeScript(
					"window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
		else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}

	// ************************Mouse
	// Actions***************************************//
	public void dragandDrop(WebElement sourceElement, WebElement targetElement) {
		Actions actions = new Actions(driver);

		// Perform the drag-and-drop action
		actions.dragAndDrop(sourceElement, targetElement).perform();
	}

	/** * Method to Explicitly wait for element to be enabled=click */

//	public void waitForElementToBeClickable(WebElement element, int duration) {
//
//		WebDriverWait wait = (new WebDriverWait(driver, Integer.parseInt(duration) * 1000));
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//	}
}
