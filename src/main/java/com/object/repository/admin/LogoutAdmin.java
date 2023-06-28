package com.object.repository.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutAdmin {

	@FindBy(xpath = "//span[.='Logout']")
	private WebElement LogoutIcon;

	public LogoutAdmin(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getLogoutIcon() {
		return LogoutIcon;
	}

	public void adminLogout() {
		LogoutIcon.click();
	}
}
