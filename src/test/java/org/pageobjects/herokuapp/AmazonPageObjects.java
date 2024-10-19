package org.pageobjects.herokuapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPageObjects {

	@FindBy(xpath = "//div[@id='CardInstancevYrWgbY8GA3Zn2xm1CjAdQ']//img[@alt='iphone13']")
	public WebElement amazonlink;
}
