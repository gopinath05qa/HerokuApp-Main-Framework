package org.herokuapp.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.pageobjects.herokuapp.LearnMorePageObjects;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;

public class LearnMorePage extends BasePage {

	SeleniumHelper helper;
	LearnMorePageObjects pageobj;

	// -------------------------------------//
	public LearnMorePage(WebDriver driver) {
		super(driver);
		helper = new SeleniumHelper(driver);
		pageobj = new LearnMorePageObjects();
		PageFactory.initElements(driver, pageobj);
	}
	// -------------------------------------//

	public void waitHandle() {
		helper.clickOnWebElement(pageobj.sevensecondwait);
//		WebElement use=helper.visibilityOf(pageobj.hiddenfirst, 7);  //if you want to click element follow this way
//		use.click();
		
//		helper.visibilityOfNoreturnElement(pageobj.hiddenfirst, 7);   //explicit wait..
		
//		helper.visibilityOfreturnElement(pageobj.hiddenfirst, 7).click();  //if you return na you can able to wait and click that element.

//		waiter.until(ExpectedConditions.visibilityOf(pageobj.hiddenfirst));    //fluent wait from BasePage class. working fine good.
		
		helper.fluentwaitForElement(pageobj.hiddenfirst, 7, 2).click();
		
		
		
		
		
		
//*********************something error so holed**********************		
//		helper.visibilityOfNoreturnElement(pageobj.hiddensecond, 10);
//		helper.clickOnWebElement(pageobj.twelesecondwait);
//		boolean e = helper.visibilityOfreturnElementisDisplayed(pageobj.hiddenthird, 12); // this is check true or false
//																							// condition method
//		System.out.println(e);
//		helper.clickOnWebElement(pageobj.fiveecondwaitalert);
	}

}
