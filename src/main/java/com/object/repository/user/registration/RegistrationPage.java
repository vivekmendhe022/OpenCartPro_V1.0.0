package com.object.repository.user.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class RegistrationPage extends WebDriverUtility {

	@FindBy(id = "input-firstname")
	private WebElement FirstNameTextField;

	@FindBy(id = "input-lastname")
	private WebElement LastNameTextField;

	@FindBy(id = "input-email")
	private WebElement EmailTextField;

	@FindBy(id = "input-password")
	private WebElement PasswordTextField;

	@FindBy(id = "input-newsletter")
	private WebElement SubscribeCircularToggleButton;

	@FindBy(name = "agree")
	private WebElement PrivacyPolicyCircularToggleButton;

	@FindBy(xpath = "//button[.='Continue']")
	private WebElement ContinueBtn;

	public RegistrationPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getFirstNameTextField() {
		return FirstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getEmailTextField() {
		return EmailTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getSubscribeCircularToggleButton() {
		return SubscribeCircularToggleButton;
	}

	public WebElement getPrivacyPolicyCircularToggleButton() {
		return PrivacyPolicyCircularToggleButton;
	}

	public WebElement getContinueBtn() {
		return ContinueBtn;
	}

	public void createRegistrationForUser(WebDriver d, String FIRSTNAME, String LASTNAME, String EMAIL,
			String PASSWORD) {
		FirstNameTextField.sendKeys(FIRSTNAME);
		LastNameTextField.sendKeys(LASTNAME);
		EmailTextField.sendKeys(EMAIL);
		PasswordTextField.sendKeys(PASSWORD);
		scrollBy(d);
		waitForElementToBeVisible(d, SubscribeCircularToggleButton);
		SubscribeCircularToggleButton.click();
		scrollBy(d);
		waitForElementToBeVisible(d, PrivacyPolicyCircularToggleButton);
		PrivacyPolicyCircularToggleButton.click();
		ContinueBtn.click();
	}
}
