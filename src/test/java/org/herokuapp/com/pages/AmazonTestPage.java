package org.herokuapp.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.pageobjects.herokuapp.AmazonPageObjects;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;

public class AmazonTestPage extends BasePage {

	SeleniumHelper helper;
	AmazonPageObjects pageobj1;

	// -------------------------------------//
	public AmazonTestPage(WebDriver driver) {
		super(driver);
		helper = new SeleniumHelper(driver);
		pageobj1 = new AmazonPageObjects();
		PageFactory.initElements(driver, pageobj1);
	}
	// -------------------------------------//

	public void waitHandle() {
		helper.clickOnWebElement(pageobj1.amazonlink);
	}
}
