package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	
	public int randomGenerator(int bound) {
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(bound);
		return randomNumber;

	}

	public void SelectDropDown(WebElement elementLocator, String visibleText) {
		Select select = new Select(elementLocator);
		select.selectByVisibleText(visibleText);
	}

	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	
}



