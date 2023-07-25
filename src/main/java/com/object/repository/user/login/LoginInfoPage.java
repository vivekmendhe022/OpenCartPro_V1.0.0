package com.object.repository.user.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all WebElements & their locator & Business logic
 * 
 * @author vivek
 *
 */
public class LoginInfoPage {

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	private WebElement MyAccountHeaderText;

	public LoginInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getMyAcountHeaderText() {
		return MyAccountHeaderText;
	}

	/**
	 * This methos will return text info about My account header
	 * 
	 * @return
	 */
	public String getMyAccountHeaderInfo() {
		return MyAccountHeaderText.getText();
	}
}
