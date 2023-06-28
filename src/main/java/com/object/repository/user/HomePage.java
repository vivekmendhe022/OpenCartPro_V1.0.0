package com.object.repository.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//span[.='My Account']")
	private WebElement Account;

	@FindBy(linkText = "Register")
	private WebElement Register;

	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void clickOnMyAccountIcon() {
		Account.click();
		Register.click();
	}

}
