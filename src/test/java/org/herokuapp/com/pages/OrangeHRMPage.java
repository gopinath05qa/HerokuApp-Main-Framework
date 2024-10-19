package org.herokuapp.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.pageobjects.herokuapp.OrangeHRMPageObjects;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;

public class OrangeHRMPage extends BasePage {

	SeleniumHelper helper;
	OrangeHRMPageObjects pageobj;

	// -------------------------------------//
	public OrangeHRMPage(WebDriver driver) {
		super(driver);
		helper = new SeleniumHelper(driver);
		pageobj = new OrangeHRMPageObjects();
		PageFactory.initElements(driver, pageobj);
	}
	// -------------------------------------//

	public void appLogin(String uname, String pwd) throws InterruptedException {
		PageFactory.initElements(driver, OrangeHRMPageObjects.class);
		System.out.println(uname + "" + pwd);
		Thread.sleep(3000);
		helper.sendKeys(pageobj.username, uname);
		helper.sendKeys(pageobj.password, pwd);
		helper.clickOnWebElement(pageobj.submitButton);
	}

}
