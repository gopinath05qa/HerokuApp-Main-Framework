package org.pageobjects.herokuapp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.basepage.BasePage;

public class PageObjects extends BasePage {

	public PageObjects(WebDriver driver) {
		super(driver);
	}

	// **********Add/Remove WebElements*****************
	@FindBy(xpath = "//*[text()='Add/Remove Elements']")
	public WebElement clickaddremovelink;
	@FindBy(xpath = "//button[@onclick='addElement()']")
	public WebElement clickAddElementButton;
	@FindBy(xpath = "//button[@class='added-manually']")
	public List<WebElement> getDeleteElements;
	@FindBy(xpath = "//button[@class='added-manually']")
	public WebElement deleteElements;

	// Basic Auth
	@FindBy(linkText = "Basic Auth")
	public WebElement clickBasicAuth;

	// Broken Image
	@FindBy(linkText = "Broken Images")
	public WebElement clickBrokenImage;
	@FindBy(xpath = "//img[contains(@src, '.jpg')]")
	public List<WebElement> getimageElements; // It will handle multiple web-elements

	// Challenging DOM
	@FindBy(linkText = "Challenging DOM")
	public WebElement clickChallengingDom;
	@FindBy(xpath = "//a[text()='baz']")
	public WebElement clickbaz;
	@FindBy(xpath = "//a[text()='foo']")
	public WebElement clickfoo;
	@FindBy(xpath = "//a[text()='qux']")
	public WebElement clickqux;

	// Checkboxes
	@FindBy(linkText = "Checkboxes")
	public WebElement clickCheckbox;
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public WebElement checkbox1;

	// context menu
	@FindBy(linkText = "Context Menu")
	public WebElement clickcontextmenubox;
	@FindBy(id = "hot-spot")
	public WebElement rightclickpath;

	// DragandDrop
	@FindBy(linkText = "Drag and Drop")
	public WebElement clickDragandDropLink;
	@FindBy(id = "column-a")
	public WebElement sourceElement;
	@FindBy(id = "column-b")
	public WebElement targetElement;

	// DropDown
	@FindBy(linkText = "Dropdown")
	public WebElement clickDropDownLink;
	@FindBy(id = "dropdown")
	public WebElement selectDropDown;

	// Switch to Frame
	@FindBy(linkText = "Frames")
	public WebElement clickFramesLink;
	@FindBy(linkText = "Nested Frames")
	public WebElement clickNestedFrame;
	@FindBy(xpath = "//frame[@name='frame-top']")
	public WebElement nestedFrame1;
	@FindBy(xpath = "//frame[@name='frame-middle']")
	public WebElement nestedFrame2;
	@FindBy(xpath = "//div[@id='content']")
	public WebElement getMiddleContent;

	// GeoLocation
	@FindBy(linkText = "Geolocation")
	public WebElement clickGeoLocationLink;
	@FindBy(xpath = "//button[@onclick='getLocation()']")
	public WebElement clickWhereAmI;
	@FindBy(xpath = "(//p/div)[1]")
	public WebElement getLatvalue;
	@FindBy(xpath = "(//p/div)[2]")
	public WebElement getLongvalue;

	// Upload File
	@FindBy(linkText = "File Upload")
	public WebElement clickFileUploadLink;
	@FindBy(id = "file-upload")
	public WebElement chooseFile;
	@FindBy(id = "file-submit")
	public WebElement finalUpload;
	@FindBy(id = "drag-drop-upload")
	public WebElement chooseFilePath;

	// web table
	@FindBy(linkText = "Sortable Data Tables")
	public WebElement clickWebTableLink;
	@FindBy(linkText = "//table[@id='table1']/tbody/tr")
	public WebElement trows;
	@FindBy(linkText = "//table[@id='table1']/tbody/tr/td")
	public WebElement tcells;

	// Mouse Hover
	@FindBy(linkText = "Hovers")
	public WebElement clickMouseHoverLink;
	@FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
	public WebElement hoverElement;
	@FindBy(xpath = "(//div[@class='figcaption'])[1]")
	public WebElement getHoverText;

	// scroll element
	@FindBy(linkText = "Infinite Scroll")
	public WebElement clickScrollLink;

	// Alert Handle
	@FindBy(linkText = "JavaScript Alerts")
	public WebElement clickAlertsLink;
	@FindBy(xpath = "//button[text()='Click for JS Alert']")
	public WebElement clicksimpleAlert;
	@FindBy(xpath = "//button[text()='Click for JS Confirm']")
	public WebElement clickconfirmAlert;
	@FindBy(xpath = "//button[text()='Click for JS Prompt']")
	public WebElement clickpromptAlert;

}
