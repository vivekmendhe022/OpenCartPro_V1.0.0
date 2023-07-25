package com.object.repository.user.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class cantains login page WebElements and their locators info.
 * 
 * @author vivek
 *
 */
public class LoginPage {

	@FindBy(name = "email")
	private WebElement EmailTextField;

	@FindBy(name = "password")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement LoginBtn;

	public LoginPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getEmailTextField() {
		return EmailTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	/**
	 * This method perform login as a valid user to the application
	 * @param EMAIL
	 * @param PASSWORD
	 */
	public void loginAsUser(String EMAIL, String PASSWORD) {
		EmailTextField.sendKeys(EMAIL);
		PasswordTextField.sendKeys(PASSWORD);
		LoginBtn.click();
	}
}
