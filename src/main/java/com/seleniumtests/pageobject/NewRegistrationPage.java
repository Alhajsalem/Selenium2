package com.seleniumtests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.seleniumtests.dataobject.RegistrationData;

public class NewRegistrationPage {

	private WebDriver driver;

	public NewRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	@CacheLookup
	@FindBy(name = "firstName")
	WebElement firstNameTextbox;

	@CacheLookup
	@FindBy(name = "lastName")
	WebElement lastNameTextbox;

	@CacheLookup
	@FindBy(name = "phone")
	WebElement phoneTextbox;

	@CacheLookup
	@FindBy(name = "userName")
	WebElement userNameTextbox;

	@CacheLookup
	@FindBy(name = "country")
	WebElement countryDropdown;

	@CacheLookup
	@FindBy(name = "email")
	WebElement emailTextbox;

	@CacheLookup
	@FindBy(name = "password")
	WebElement passwordTextbox;

	@CacheLookup
	@FindBy(name = "confirmPassword")
	WebElement confirmPasswordTextbox;

	@CacheLookup
	@FindBy(name = "register")
	WebElement registerButton;

	public NewRegistrationPage enterFirstName(String firstName) {
		firstNameTextbox.sendKeys(firstName);
		return this;
	}

	public NewRegistrationPage enterLastName(String lastName) {
		lastNameTextbox.sendKeys(lastName);
		return this;
	}

	public NewRegistrationPage enterPhone(String phone) {
		phoneTextbox.sendKeys(phone);
		return this;
	}

	public NewRegistrationPage enterUserName(String userName) {
		userNameTextbox.sendKeys(userName);
		return this;
	}

	public NewRegistrationPage selectCountry(String country) {
		new Select(countryDropdown).selectByVisibleText(country);
		return this;
	}

	public NewRegistrationPage enterEmail(String email) {
		emailTextbox.sendKeys(email);
		return this;
	}

	public NewRegistrationPage enterPassword(String password) {
		passwordTextbox.sendKeys(password);
		return this;
	}

	public NewRegistrationPage enterConfirmPassword(String password) {
		confirmPasswordTextbox.sendKeys(password);
		return this;
	}

	public AccountCreationPage clickRegister() {
		registerButton.click();
		return PageFactory.initElements(driver, AccountCreationPage.class);
	}

	public AccountCreationPage registerNewUser(RegistrationData registrationData) {
		Reporter.log("firstName: " +registrationData.getFirstName()+"<br>");
		Reporter.log("lastName: " +registrationData.getLastName()+"<br>");
		Reporter.log("phone: " +registrationData.getPhoneNumber()+"<br>");
		Reporter.log("userName: " +registrationData.getUserName()+"<br>");
		Reporter.log("country: " +registrationData.getCountry()+"<br>");
		Reporter.log("email: " +registrationData.getEmail()+"<br>");
		Reporter.log("password: " +registrationData.getPassword()+"<br>");
		Reporter.log("confirmPassword: " +registrationData.getConfirmPassword()+"<br>");
		return enterFirstName(registrationData.getFirstName())
				.enterLastName(registrationData.getLastName())
				.enterPhone(registrationData.getPhoneNumber())
				.enterUserName(registrationData.getUserName())
				.selectCountry(registrationData.getCountry())
				.enterEmail(registrationData.getEmail())
				.enterPassword(registrationData.getPassword())
				.enterConfirmPassword(registrationData.getConfirmPassword())
				.clickRegister();
	}
}
