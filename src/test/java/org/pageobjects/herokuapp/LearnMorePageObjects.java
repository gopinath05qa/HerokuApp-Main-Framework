package org.pageobjects.herokuapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LearnMorePageObjects {

	@FindBy(xpath = "//button[@id='display-other-button']")
	public WebElement sevensecondwait;
	@FindBy(xpath = "//button[@id='hidden']")
	public WebElement hiddenfirst;
	@FindBy(xpath = "//button[@id='quote']")
	public WebElement tensecondwait;
	@FindBy(xpath = "//button[@id='enable_btn']")
	public WebElement hiddensecond;
	@FindBy(id = "enable_btn")
	public WebElement twelesecondwait;
	@FindBy(xpath = "//span[@id='checkBox']")
	public WebElement hiddenthird;
	@FindBy(id = "alert")
	public WebElement fiveecondwaitalert;
	@FindBy(id = "change_text")
	public WebElement hiddenfourth;
	
	
}
