package com.object.repository.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistartionInfoPage {

	@FindBy(xpath = "//h1[contains(.,'Created')]")
	private WebElement AccountCreatedText;

	public RegistartionInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getAccountCreatedText() {
		return AccountCreatedText;
	}

	public String getRegistrationHeader() {
		return AccountCreatedText.getText();
	}

}
