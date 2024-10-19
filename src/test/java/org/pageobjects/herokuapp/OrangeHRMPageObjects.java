package org.pageobjects.herokuapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMPageObjects {

	// **********Add/Remove WebElements*****************
	@FindBy(name = "username")
	public WebElement username;
	@FindBy(name = "password")
	public WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement submitButton;
}
