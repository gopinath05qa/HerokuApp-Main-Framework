package org.herokuapp.com.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.herokuapp.com.pages.OrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.basetest.BaseTest2;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class OrangeHRMTest {

	public String excelpath = System.getProperty("user.dir") + "\\ExcelData\\excel.xls";

	public static OrangeHRMPage Orgpage;

	String[][] data = null;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Orgpage = new OrangeHRMPage(driver);
	}

	@BeforeMethod
	public void beforeMethod() {

		System.out.println("\033[1mBefore Method Test Started!\033[0m");
		System.out.println("Here URL Launching!");
		System.out.println("\033[1mBefore Method Test Ended!\033[0m");
	}

	@DataProvider(name = "logindata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = GetExcelData();
		return data;
	}

	public String[][] GetExcelData() throws BiffException, IOException {

		System.out.println("entered dataprovider");
		FileInputStream m = new FileInputStream(excelpath);
		Workbook excel = Workbook.getWorkbook(m);
		Sheet sheet = excel.getSheet("loginsheet");
		int rowcount = sheet.getRows();
		int columncount = sheet.getColumns();
		System.out.println(rowcount + "" + columncount);

		String testdata[][] = new String[rowcount - 1][columncount - 1];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 1; j < columncount; j++) {
				testdata[i - 1][j - 1] = sheet.getCell(j, i).getContents();
			}
		}

		return testdata;
	}

	@Test(dataProvider = "logindata")
	public void logincheck(String uname123, String pwd123) throws InterruptedException {
		Orgpage.appLogin(uname123, pwd123);
	}

}
