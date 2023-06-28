package com.object.repository.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAdmin {

	@FindBy(id = "input-username")
	private WebElement UserNameTextField;

	@FindBy(id = "input-password")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//button[.=' Login']")
	private WebElement LoginBtn;

	public LoginAdmin(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	public void loginToAdmin(String USERNAME, String PASSWORD) {
		UserNameTextField.sendKeys(USERNAME);
		PasswordTextField.sendKeys(PASSWORD);
		LoginBtn.click();
	}
}
