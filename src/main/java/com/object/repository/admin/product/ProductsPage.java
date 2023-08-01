package com.object.repository.admin.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	@FindBy(linkText = "Products")
	private WebElement ProductsLinkText;

	@FindBy(xpath = "(//i[@class='fa-solid fa-plus'])[1]")
	private WebElement AddNewLookUpImg;

	@FindBy(id = "input-name-1")
	private WebElement ProductNameTextField;

	@FindBy(id = "input-meta-title-1")
	private WebElement MegaTitleTextField;

	@FindBy(id = "input-model")
	private WebElement ModelTextField;

	@FindBy(id = "input-keyword-0-1")
	private WebElement SEOTextField;

	@FindBy(xpath = "//i[@class='fa-solid fa-floppy-disk']")
	private WebElement SaveLookUpImg;

	public ProductsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void clickOnAddNewLookUpImg() {
		AddNewLookUpImg.click();
	}

	public void addNewProduct(String PNAME, String MEGATITLE, String MODELNAME, String SEO) {
		ProductNameTextField.sendKeys(PNAME);
		MegaTitleTextField.sendKeys(MEGATITLE);
		ModelTextField.sendKeys(MODELNAME);
		SEOTextField.sendKeys(SEO);
		SaveLookUpImg.click();
	}
}
