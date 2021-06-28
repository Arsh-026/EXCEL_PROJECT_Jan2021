package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	//Element Library 
	@FindBy(how=How.XPATH, using = "//input[@id='account']") WebElement  FULL_NAME;
	@FindBy(how=How.XPATH, using = "//select[@id='cid']") WebElement COMPANY_FIELD;
	@FindBy(how=How.XPATH, using = "//input[@id='email']") WebElement EMAIL_FIELD;
	@FindBy(how=How.XPATH, using = "//input[@id='phone']") WebElement PHONE_FIELD;
	@FindBy(how=How.XPATH, using = "//input[@name='address']") WebElement ADDRESS_FIELD;
	@FindBy(how=How.XPATH, using = "//input[@name='city']") WebElement CITY_FIELD;
	@FindBy(how=How.XPATH, using = "//select[@name='country']") WebElement COUNTRY_FIELD;
	@FindBy(how=How.XPATH, using = "//input[@name='state']") WebElement STATE_FIELD;
	@FindBy(how=How.XPATH, using = "//input[@id='zip']") WebElement ZIP_FIELD;
	@FindBy(how=How.XPATH, using = "//button[@id='submit']") WebElement SUBMIT_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]") WebElement SUMMARY_BUTTON_ON_SUMMARY_PAGE;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']") WebElement OK_BUTTON;
	

	
	
	//Interactive Methods
	String enteredName;
	public void enterFullName(String fullName) {
		
		int generatedNumber = randomGenerator(999);
		enteredName = fullName + generatedNumber;
		FULL_NAME.sendKeys(enteredName);
		
	}
	
	public int randomGenerator(int bound) {
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(bound);
		return randomNumber;
		
	}

	public void chooseCompanyOption(String company) {
		
		SelectDropDown(COMPANY_FIELD, company);
	}

	public void SelectDropDown(WebElement elementLocator, String visibleText) {
		Select select = new Select(elementLocator);
		select.selectByVisibleText(visibleText);
		
	}
	
	public void enterEmail(String email) {
		int generatedNumber = randomGenerator(999);
		EMAIL_FIELD.sendKeys(generatedNumber + email);
	}
	
	public void enterPhoneNumber(String phone) {
		int generatedNumber = randomGenerator(999);
		EMAIL_FIELD.sendKeys(generatedNumber + phone);
	}
	
	public void enterAddress(String address) {
		ADDRESS_FIELD.sendKeys(address);
	}
	
	public void enterCity(String city) {
		CITY_FIELD.sendKeys(city);
	}
		
	public void chooseCountryOption(String country) {
		SelectDropDown(COUNTRY_FIELD, country);
		//COUNTRY_FIELD.click();
	}
	
	public void enterState(String state) {
		STATE_FIELD.sendKeys(state);
	}
	
	public void enterZip(String zip) {
		ZIP_FIELD.sendKeys(zip);
	}
	
	public void clickSubmitButton() {
		SUBMIT_BUTTON.click();
	}
	
	public void verifySummaryPage() {		
		waitForElement(driver, 5, SUMMARY_BUTTON_ON_SUMMARY_PAGE);
		Assert.assertEquals(SUMMARY_BUTTON_ON_SUMMARY_PAGE.getText(), "Summary", "Wrong page!!");
	}

	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	//tbody/tr[i]/td[3]/following-sibling::td[4]/a[2]
	
	public void verifyEnteredNameAndDelete() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		
		for(int i = 1; i<=10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//			System.out.println(name);
//			Assert.assertEquals(name, enteredName, "Entered name doesn't match");
//			break;
			
			if(name.contains(enteredName)) {
				System.out.println("entered name exist.");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
				//driver.findElement(By.xpath(before_xpath+ i + after_xpath + "/following-sibling::td[4]/a[2]")).click();
			}
		}
	}
}


//https://github.com/techfios-git/ExcelProject_Jan2021.git