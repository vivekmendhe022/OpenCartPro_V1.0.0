package com.object.repository.user.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountInfoPage {

	@FindBy(xpath = "//h1[.='Register Account']")
	private WebElement RegisterHeader;

	public RegisterAccountInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getRegisterHeader() {
		return RegisterHeader;
	}

	public String getRegisterAccountHeader() {
		return RegisterHeader.getText();
	}

}
