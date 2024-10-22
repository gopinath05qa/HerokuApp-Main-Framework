package interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public void amaztest() throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();

		Thread.sleep(3000);

		driver.get("https://www.amazon.in/ref=nav_logo");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
		driver.findElement(By.id("nav-search-submit-button")).click();

//		driver.findElement(By.xpath("//*[@id=\"CardInstanceUY2C0QZL6PoN0kBpJs8DzQ\"]/a")).click();

//		driver.findElement(
//				By.xpath("//ul[@data-csa-c-content-id='91049095031']//child::span[@class='a-expander-prompt']"))
//				.click();
//
		List<WebElement> elements = driver.findElements(
				By.xpath("//ul[@data-csa-c-content-id='91049095031']//child::span[@class='a-size-base a-color-base']"));

		for (WebElement r : elements) {

			String value = r.getText();
			System.out.println(value);

			if (value.equalsIgnoreCase("realme")) {
				driver.findElement(By.xpath("//span[text()='realme']")).click();
				break;
			} else {
				System.out.println("not available in the brand filter list");
			}

		}

		Thread.sleep(5000);

		WebElement elementToScroll = driver
				.findElement(By.xpath("(//div[@class='a-section a-spacing-mini sf-range-slider-row'])[1]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);

		Thread.sleep(3000);

		WebElement leftSlider = driver
				.findElement(By.xpath("//input[@id='p_36/range-slider_slider-item_lower-bound-slider']"));
		WebElement rightSlider = driver
				.findElement(By.xpath("//input[@id='p_36/range-slider_slider-item_upper-bound-slider']"));

		Thread.sleep(3000);

		int value = 50;

		int maxFinalValue1 = 0;

		for (int i = 1; i < value; i++) {

			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));",
					leftSlider, i);

//			((JavascriptExecutor) driver).executeScript(
//					"arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));", leftSlider, i);

			WebElement getValue = driver
					.findElement(By.xpath("//input[@id='p_36/range-slider_slider-item_lower-bound-slider']"));

			String areaValue = getValue.getAttribute("aria-valuetext");

			String cleanValue = areaValue.replace("₹", "").replace(",", "").replace("+", "");

			int minValue = Integer.parseInt(cleanValue);

//			System.out.println(minValue);

			if (minValue >= 2000 && minValue <= 6000) {
				int temp1 = minValue;
				maxFinalValue1 = temp1;
				break;
			}
		}
		System.out.println("The Min Value was :" + maxFinalValue1);

		int value2 = 180;

		int maxFinalValue = 0;

		for (int i = 100; i < value2; i++) {

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));", rightSlider,
					i);

			WebElement getValue = driver
					.findElement(By.xpath("//input[@id='p_36/range-slider_slider-item_upper-bound-slider']"));

			String areaValue1 = getValue.getAttribute("aria-valuetext");

			String cleanValue1 = areaValue1.replace("₹", "").replace(",", "").replace("+", "");

			int maxValue1 = Integer.parseInt(cleanValue1);

//			System.out.println(maxValue1);

			if (maxValue1 >= 20000 && maxValue1 <= 30000) {
				driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
				int temp = maxValue1;
				maxFinalValue = temp;
				break;
			}
		}
		System.out.println("The Max Value was :" + maxFinalValue);
//		if (maxFinalValue >= 20000 && maxFinalValue <= 21000)
//			System.out.println("It's come out within the range");
//		else {
//
//			System.out.println("not in the price range, so exit the loop and Final max Value :" + maxFinalValue);
//		}

		Thread.sleep(5000);

//		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

		List<WebElement> productNames = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		for (WebElement products : productNames) {

			System.out.println("The First Product Name :" + products.getText());
		}

		Thread.sleep(5000);

		List<WebElement> productPrices = driver.findElements(By.xpath(
				"//a[@class='a-link-normal s-no-hover s-underline-text s-underline-link-text s-link-style a-text-normal']/descendant::span[@class='a-price-whole']"));

		for (WebElement prices : productPrices) {

			System.out.println(prices.getText());

		}

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Amazon ama=new Amazon();
		ama.amaztest();
		
	}

}
