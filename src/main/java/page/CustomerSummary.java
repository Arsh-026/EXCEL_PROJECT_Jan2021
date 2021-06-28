//package page;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//import org.testng.Assert;
//
//public class CustomerSummary extends BasePage {
//	
//	WebDriver driver;
//	
//	public CustomerSummary(WebDriver driver) {
//		this.driver = driver;
//		
//	}
//	
//	@FindBy(how = How.XPATH, using = "//a[@id='summary']") WebElement ACCOUNT_SUMMARY;
//	
//	public void verifyCustomerSummary() {
//		waitForElement(driver,10, ACCOUNT_SUMMARY);
//		Assert.assertEquals(ACCOUNT_SUMMARY.getText(), "Accounting Summary", "Summary page not found!");

		
		
		
//		
//	}
//
//}
