package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends BasePage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	//Element Library 
	@FindBy(how=How.XPATH, using = "//h2[contains(text(),'Dashboard')]") WebElement DASHBOARD_ELEMENT;
	@FindBy(how=How.XPATH, using = "//span[text()='Customers']") WebElement CUSTOMER_BUTTON;
	@FindBy(how=How.XPATH, using = "//a[text()='Add Customer']") WebElement ADD_CUSTOMER;
	@FindBy(how=How.XPATH, using = "//a[contains(text(),'List Customers')]") WebElement LIST_CUSTOMER;
	
	//Interactive Methods
	public void validateDashboardPage() {
		waitForElement(driver, 3, DASHBOARD_ELEMENT );
		Assert.assertEquals(DASHBOARD_ELEMENT.getText(), "Dashboard", "Dashboard page not found.");
		
	}
	
	public void clickCustomerButton() {
		CUSTOMER_BUTTON.click();
	}
	
	public void clickAddCustomerButton() {
		ADD_CUSTOMER.click();
	}
	
	public void clickListCustomerButton() {
		LIST_CUSTOMER.click();
	}
}

