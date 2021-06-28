package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddCustomerPage;
//import page.CustomerSummary;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String company = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlread.getCellData("AddContactInfo", "Email", 2);
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	String state = exlread.getCellData("AddContactInfo", "State", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);
	
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();
		 
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.chooseCompanyOption(company);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhoneNumber(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.chooseCountryOption(country);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.clickSubmitButton();
		
		addCustomerPage.verifySummaryPage();
		
//		CustomerSummary customerSummary = PageFactory.initElements(driver, CustomerSummary.class);
//		customerSummary.verifyCustomerSummary();
		
		dashboardPage.clickListCustomerButton();
		addCustomerPage.verifyEnteredNameAndDelete();
		
		BrowserFactory.tearDown();
	}

}







//https://github.com/techfios-git/POM_Project_Jan2021.git
